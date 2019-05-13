/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.model.service;

import com.faculte.appelOffre.AppelOffre.domain.bean.AppelOffre;
import com.faculte.appelOffre.AppelOffre.domain.bean.AppelOffreDetail;
import java.util.List;

/**
 *
 * @author YSN
 */
public interface AppelOffreDetailService {

    public int saveAppelOffreDetails(AppelOffre appelOffre,List<AppelOffreDetail> appelOffreDetails);

    public List<AppelOffreDetail> findByAppelOffreObjectif(String objectif);

    public List<AppelOffreDetail> findByAppelOffreReference(String reference);

}
