/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.service;

import com.faculte.appelOffre.AppelOffre.bean.AppelOffre;
import java.util.List;

/**
 *
 * @author YSN
 */
public interface AppelOffreService {

    public AppelOffre saveAppelOffreWithAppelOffreDetails(AppelOffre appelOffre);

    public AppelOffre findByObjectif(String Objectif);
    public List<AppelOffre> findAll();

}
