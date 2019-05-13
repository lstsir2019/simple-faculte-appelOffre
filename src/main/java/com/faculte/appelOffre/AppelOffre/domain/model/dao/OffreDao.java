/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.model.dao;

import com.faculte.appelOffre.AppelOffre.domain.bean.AppelOffre;
import com.faculte.appelOffre.AppelOffre.domain.bean.Offre;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author ASUS
 */
@Repository
public interface OffreDao extends JpaRepository<Offre, Long> {

    public Offre findByReference(String reference);

    public List<Offre> findByAppelOffreReferenceOrderByMontantTtcAsc(String reference);
    
    public AppelOffre findByAppelOffreId(long id);

}
