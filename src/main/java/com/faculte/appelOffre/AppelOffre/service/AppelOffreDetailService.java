/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.service;

import com.faculte.appelOffre.AppelOffre.bean.AppelOffre;
import com.faculte.appelOffre.AppelOffre.bean.AppelOffreDetail;
import java.util.List;

/**
 *
 * @author YSN
 */
public interface AppelOffreDetailService {

    public int saveAppelOffreDetails(AppelOffreDetail appelOffreDetail);

    public List<AppelOffreDetail> findByAppelOffreObjectif(String objectif);

}
