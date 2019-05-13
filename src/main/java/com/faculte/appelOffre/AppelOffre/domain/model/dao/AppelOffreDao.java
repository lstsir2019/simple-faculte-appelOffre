/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.model.dao;

import com.faculte.appelOffre.AppelOffre.domain.bean.AppelOffre;
import com.faculte.appelOffre.AppelOffre.domain.bean.Offre;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author YSN
 */
@Repository
public interface AppelOffreDao extends JpaRepository<AppelOffre, Long> {

    public AppelOffre findByObjectif(String Objectif);
    
    public AppelOffre findByReference(String reference);
    
    public Offre findOffreSelectedByReference(String reference);
    
    
}

