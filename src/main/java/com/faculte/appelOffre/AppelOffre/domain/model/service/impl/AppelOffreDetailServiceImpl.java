/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.model.service.impl;

import com.faculte.appelOffre.AppelOffre.domain.model.dao.AppelOffreDetailDao;
import com.faculte.appelOffre.AppelOffre.domain.bean.AppelOffre;
import com.faculte.appelOffre.AppelOffre.domain.bean.AppelOffreDetail;
import com.faculte.appelOffre.AppelOffre.domain.model.service.AppelOffreDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author YSN
 */
@Service
public class AppelOffreDetailServiceImpl implements AppelOffreDetailService {

    @Autowired
    private AppelOffreDetailDao appelOffreDetailDao;

    @Override
    public int saveAppelOffreDetails(AppelOffre appelOffre, List<AppelOffreDetail> appelOffreDetails) {
        if (appelOffreDetails == null || appelOffreDetails.isEmpty()) {
            return -1;
        } else {
            for (AppelOffreDetail appelOffreDetail : appelOffreDetails) {
                appelOffreDetail.setAppelOffre(appelOffre);
                appelOffreDetailDao.save(appelOffreDetail);
            }
            return 1;
        }
    }

    @Override
    public List<AppelOffreDetail> findByAppelOffreReference(String reference) {
        return appelOffreDetailDao.findByAppelOffreReference(reference);
    }

    @Override
    public List<AppelOffreDetail> findByAppelOffreObjectif(String objectif) {
        return appelOffreDetailDao.findByAppelOffreObjectif(objectif);
    }

    public AppelOffreDetailDao getAppelOffreDetailDao() {
        return appelOffreDetailDao;
    }

    public void setAppelOffreDetailDao(AppelOffreDetailDao appelOffreDetailDao) {
        this.appelOffreDetailDao = appelOffreDetailDao;
    }

}
