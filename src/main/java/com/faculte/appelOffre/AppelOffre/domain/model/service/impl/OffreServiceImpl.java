/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.model.service.impl;

import com.faculte.appelOffre.AppelOffre.domain.model.dao.AppelOffreDao;
import com.faculte.appelOffre.AppelOffre.domain.model.dao.OffreDao;
import com.faculte.appelOffre.AppelOffre.domain.bean.AppelOffre;
import com.faculte.appelOffre.AppelOffre.domain.bean.Offre;
import com.faculte.appelOffre.AppelOffre.domain.bean.OffreDetail;
import com.faculte.appelOffre.AppelOffre.domain.model.service.AppelOffreService;
import com.faculte.appelOffre.AppelOffre.domain.model.service.OffreDetailService;
import com.faculte.appelOffre.AppelOffre.domain.model.service.OffreService;
import java.math.BigDecimal;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class OffreServiceImpl implements OffreService {

    @Autowired
    private OffreDao offreDao;

    @Autowired
    private OffreDetailService offreDetailService;

    @Autowired
    private AppelOffreService appelOffreService;

    public OffreDao getOffreDao() {
        return offreDao;
    }

    public void setOffreDao(OffreDao offreDao) {
        this.offreDao = offreDao;
    }

    @Override
    public Offre createOffrewithOffreDetails(Offre offre) {
        if (offre.getReference() != null && !offre.getReference().isEmpty() && validateProduit(offre.getOffreDetails())) {
            Offre of = findByReference(offre.getReference());
            AppelOffre appelOffre = appelOffreService.findByReference(offre.getAppelOffre().getReference());
            if (null != appelOffre && null == of) {
                calculerTotal(offre, offre.getOffreDetails());
                offre.setAppelOffre(appelOffre);
                offreDao.save(offre);
                offreDetailService.saveOffreDetails(offre, offre.getOffreDetails());
                return offre;
            }
        }
        return null;
    }

    private void calculerTotal(Offre offre, List<OffreDetail> offreDetails) {
        BigDecimal total = BigDecimal.ZERO;
        BigDecimal totalht = BigDecimal.ZERO;
        if (offreDetails != null || !offreDetails.isEmpty()) {
            for (OffreDetail offreDetail : offreDetails) {
                total = total.add(offreDetail.getPrixUnitaire().multiply(offreDetail.getQuantite()));
                offreDetail.setTotal(total);
            }
        }
        offre.setMontantHt(total);
        offre.setMontantTtc(offre.getMontantHt().add(offre.getMontantHt().multiply(offre.getTva())));

    }

    private boolean validateProduit(List<OffreDetail> offreDetails) {
        if (offreDetails == null || offreDetails.isEmpty()) {
            return false;
        } else {
            int cmp = 0;
            for (OffreDetail offreDetail : offreDetails) {
//                 if (produitProxy.findByReference(appelOffreDetail.getRefProduit())!= null) {
                cmp++;
//                }
            }
            return (cmp == offreDetails.size());
        }
    }

    @Override
    public int removeByAppelOffreReference(String reference) {
        List<Offre> offres = findByAppelOffreReference(reference);
        if (offres != null) {
            offreDao.deleteAll(offres);
            return 1;
        }
        return -1;
    }

    @Override
    public Offre updateOffre(Offre offre) {
        Offre ofr = offreDao.findByReference(offre.getReference());
        if (ofr == null) {
            return null;
        } else {
            offre.setAppelOffre(offre.getAppelOffre());
            offre.setDate(offre.getDate());
            offre.setMontantHt(offre.getMontantHt());
            offre.setRefrenceFournisseur(offre.getRefrenceFournisseur());
            offre.setMontantTtc(offre.getMontantTtc());
            offre.setTva(offre.getTva());
            offreDao.save(offre);
            return offre;
        }

    }

    @Override
    public int deleteOffre(Offre offre) {
        Offre ofr = offreDao.findByReference(offre.getReference());
        if (ofr == null) {
            return -1;
        } else {
            offreDao.delete(ofr);
            return 1;
        }

    }

    @Override
    public Offre findByReference(String reference) {
        return offreDao.findByReference(reference);
    }

    @Override
    public List<Offre> findAll() {
        return offreDao.findAll();
    }

    @Override
    public List<Offre> findByAppelOffreReference(String reference) {
        return offreDao.findByAppelOffreReferenceOrderByMontantTtcAsc(reference);
    }

    @Override
    public AppelOffre findByAppelOffreId(long id) {
        return offreDao.findByAppelOffreId(id);
    }
}
