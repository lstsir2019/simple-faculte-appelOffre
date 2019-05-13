/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.model.service;

import com.faculte.appelOffre.AppelOffre.domain.bean.AppelOffre;
import com.faculte.appelOffre.AppelOffre.domain.bean.Offre;
import java.util.Date;
import java.util.List;

/**
 *
 * @author YSN
 */
public interface AppelOffreService {

    public AppelOffre saveAppelOffreWithAppelOffreDetails(AppelOffre appelOffre);

    public AppelOffre findByReference(String reference);
    
    public AppelOffre removeByReference(String reference);
    
    public AppelOffre findByObjectif(String Objectif);

    public List<AppelOffre> findByCriteria(Date dateMin, Date dateMax, String objectif, String reference);

    public List<AppelOffre> findAll();

    public int offreSelected(String referenceOffre);
    
    public Offre findOffreSelectedByReference(String reference);

}
