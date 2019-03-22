/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.service.impl;

import com.faculte.appelOffre.AppelOffre.Dao.AppelOffreDetailDao;
import com.faculte.appelOffre.AppelOffre.bean.AppelOffre;
import com.faculte.appelOffre.AppelOffre.bean.AppelOffreDetail;
import com.faculte.appelOffre.AppelOffre.service.AppelOffreDetailService;
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
    public int saveAppelOffreDetails(AppelOffreDetail appelOffreDetail) {
        appelOffreDetailDao.save(appelOffreDetail);
        return 1;
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
