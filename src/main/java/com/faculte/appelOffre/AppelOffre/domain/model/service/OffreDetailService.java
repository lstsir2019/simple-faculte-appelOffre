/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.model.service;

import com.faculte.appelOffre.AppelOffre.domain.bean.AppelOffre;
import com.faculte.appelOffre.AppelOffre.domain.bean.Offre;
import com.faculte.appelOffre.AppelOffre.domain.bean.OffreDetail;
import java.util.List;

/**
 *
 * @author ASUS
 */
public interface OffreDetailService {

    public int saveOffreDetails(Offre offre, List<OffreDetail> offreDetails);

    public List<OffreDetail> findByOffreReference(String reference);

}
