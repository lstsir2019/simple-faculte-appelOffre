/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.service.impl;

import com.faculte.appelOffre.AppelOffre.Dao.AppelOffreDao;
import com.faculte.appelOffre.AppelOffre.bean.AppelOffre;
import com.faculte.appelOffre.AppelOffre.bean.AppelOffreDetail;
import com.faculte.appelOffre.AppelOffre.service.AppelOffreDetailService;
import com.faculte.appelOffre.AppelOffre.service.AppelOffreService;
import java.math.BigDecimal;
import java.util.List;
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
    private AppelOffreDetailService appelOffreDetailService;

    @Override
    public AppelOffre saveAppelOffreWithAppelOffreDetails(AppelOffre appelOffre) {
        AppelOffre a = findByObjectif(appelOffre.getObjectif());
        if (a != null) {
            return null;
        } else {

            appelOffreDao.save(appelOffre);
            List<AppelOffreDetail> appelOffreDetails=appelOffre.getAppelOffreDetails();
            for (AppelOffreDetail appelOffreDetail : appelOffreDetails) {
                appelOffreDetail.setAppelOffre(appelOffre);
                appelOffreDetailService.saveAppelOffreDetails(appelOffreDetail);
            }
                       return appelOffre;
        }
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
        if (appelOffreDetails != null || !appelOffreDetails.isEmpty()) {
            for (AppelOffreDetail appelOffreDetail : appelOffreDetails) {
                total = total.add(appelOffreDetail.getPrixUnitaire().multiply(appelOffreDetail.getQuantite()));
            }
        }
        appelOffre.setMontantHT(total);
    }

    @Override
    public List<AppelOffre> findAll() {
        return appelOffreDao.findAll();
    }

}
