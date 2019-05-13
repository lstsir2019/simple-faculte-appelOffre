/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.model.service.impl;

import com.faculte.appelOffre.AppelOffre.domain.model.dao.AppelOffreDao;
import com.faculte.appelOffre.AppelOffre.domain.model.dao.OffreDao;
import com.faculte.appelOffre.AppelOffre.domain.rest.proxy.ProduitProxy;
import com.faculte.appelOffre.AppelOffre.domain.bean.AppelOffre;
import com.faculte.appelOffre.AppelOffre.domain.bean.AppelOffreDetail;
import com.faculte.appelOffre.AppelOffre.domain.bean.Offre;
import com.faculte.appelOffre.AppelOffre.domain.model.service.AppelOffreDetailService;
import com.faculte.appelOffre.AppelOffre.domain.model.service.AppelOffreService;
import com.faculte.appelOffre.AppelOffre.domain.model.service.OffreService;
import com.faculte.simplefacultestock.commun.util.SearchUtil;
import java.math.BigDecimal;
import java.util.List;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author YSN
 */
@Service
public class AppelOffreServiceImpl implements AppelOffreService {
    
    @Autowired
    private AppelOffreDao appelOffreDao;
    @Autowired
    private OffreDao offreDao;
    
    @Autowired
    private AppelOffreDetailService appelOffreDetailService;
    
    @Autowired
    private ProduitProxy produitProxy;
    
    @PersistenceContext
    private EntityManager entityManager;
    
    @Autowired
    private OffreService offreService;
    
    @Override
    public AppelOffre saveAppelOffreWithAppelOffreDetails(AppelOffre appelOffre) {
        if (validateProduit(appelOffre.getAppelOffreDetails())) {
            AppelOffre ao = findByReference(appelOffre.getReference());
            if (ao == null) {
                calculerTotal(appelOffre, appelOffre.getAppelOffreDetails());
                appelOffreDao.save(appelOffre);
                appelOffreDetailService.saveAppelOffreDetails(appelOffre, appelOffre.getAppelOffreDetails());
                return appelOffre;
            }
        }
        return null;
    }
    
    @Override
    public AppelOffre removeByReference(String reference) {
        AppelOffre appelOffre = findByReference(reference);
        if (appelOffre != null) {
            offreService.removeByAppelOffreReference(appelOffre.getReference());
            appelOffreDao.delete(appelOffre);
        }
        return appelOffre;
    }
    
    @Override
    public AppelOffre findByReference(String reference) {
        return appelOffreDao.findByReference(reference);
    }
    
    @Override
    public AppelOffre findByObjectif(String Objectif) {
        return appelOffreDao.findByObjectif(Objectif);
    }
    
    public AppelOffreDao getAppelOffreDao() {
        return appelOffreDao;
    }
    
    public void setAppelOffreDao(AppelOffreDao appelOffreDao) {
        this.appelOffreDao = appelOffreDao;
    }
    
    private void calculerTotal(AppelOffre appelOffre, List<AppelOffreDetail> appelOffreDetails) {
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal totalht = BigDecimal.ZERO;
        if (appelOffreDetails != null || !appelOffreDetails.isEmpty()) {
            for (AppelOffreDetail appelOffreDetail : appelOffreDetails) {
                total = total.add(appelOffreDetail.getPrixUnitaire().multiply(appelOffreDetail.getQuantite()));
                appelOffreDetail.setTotal(total);
            }
        }
        appelOffre.setMontantHT(total);
        appelOffre.setMontantTTC(appelOffre.getMontantHT().add(appelOffre.getMontantHT().multiply(appelOffre.getTva())));
        
    }
    
    @Override
    public List<AppelOffre> findAll() {
        return appelOffreDao.findAll();
    }
    
    private boolean validateProduit(List<AppelOffreDetail> appelOffreDetails) {
        if (appelOffreDetails == null || appelOffreDetails.isEmpty()) {
            return false;
        } else {
            int cmp = 0;
            for (AppelOffreDetail appelOffreDetail : appelOffreDetails) {
//                 if (produitProxy.findByReference(appelOffreDetail.getRefProduit())!= null) {
                cmp++;
//                }
            }
            return (cmp == appelOffreDetails.size());
        }
    }
    
    @Override
    public int offreSelected(String referenceOffre) {
        if (referenceOffre == null || referenceOffre.isEmpty()) {
            return -1;
        } else /* if (!appelOffre.getReference().equals(offre.getAppelOffre().getReference())) {
            return -3;
        } else*/ {
            Offre offre1 = offreService.findByReference(referenceOffre);
            if (null == offre1 || offre1.getAppelOffre() == null) {
                return -2;
            } else {
                offre1.getAppelOffre().setOffreSelected(offre1);
                appelOffreDao.save(offre1.getAppelOffre());
                return 1;
            }
        }
    }
    
    @Override
    public List<AppelOffre> findByCriteria(Date dateMin, Date dateMax, String objectif, String reference) {
        return entityManager.createQuery(constructQuery(dateMin, dateMax, objectif, reference)).getResultList();
    }
    
    private String constructQuery(Date dateMin, Date dateMax, String objectif, String reference) {
        String query = "SELECT a FROM AppelOffre a where 1=1 ";
        query += SearchUtil.addConstraintMinMaxDate("a", "date", dateMin, dateMax);
        query += SearchUtil.addConstraint("a", "objectif", "LIKE", objectif);
        query += SearchUtil.addConstraint("a", "reference", "LIKE", reference);
        return query;
    }
    
    public AppelOffreDetailService getAppelOffreDetailService() {
        return appelOffreDetailService;
    }
    
    public void setAppelOffreDetailService(AppelOffreDetailService appelOffreDetailService) {
        this.appelOffreDetailService = appelOffreDetailService;
    }
    
    public ProduitProxy getProduitProxy() {
        return produitProxy;
    }
    
    public void setProduitProxy(ProduitProxy produitProxy) {
        this.produitProxy = produitProxy;
    }
    
    public OffreService getOffreService() {
        return offreService;
    }
    
    public void setOffreService(OffreService offreService) {
        this.offreService = offreService;
    }
    
    public OffreDao getOffreDao() {
        return offreDao;
    }
    
    public void setOffreDao(OffreDao offreDao) {
        this.offreDao = offreDao;
    }

    @Override
    public Offre findOffreSelectedByReference(String reference) {
        return appelOffreDao.findOffreSelectedByReference(reference);
    }
    
}
