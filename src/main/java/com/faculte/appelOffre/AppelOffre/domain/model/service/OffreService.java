/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.model.service;

import com.faculte.appelOffre.AppelOffre.domain.bean.AppelOffre;
import com.faculte.appelOffre.AppelOffre.domain.bean.Offre;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface OffreService {

    public Offre createOffrewithOffreDetails(Offre offre);

    public Offre updateOffre(Offre offre);

    public int deleteOffre(Offre offre);

    public Offre findByReference(String reference);

    public List<Offre> findAll();

    public List<Offre> findByAppelOffreReference(String reference);

    public int removeByAppelOffreReference(String reference);

    public AppelOffre findByAppelOffreId(long id);

}
