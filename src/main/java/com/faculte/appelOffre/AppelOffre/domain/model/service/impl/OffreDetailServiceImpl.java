/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.model.service.impl;

import com.faculte.appelOffre.AppelOffre.domain.model.dao.OffreDetailDao;
import com.faculte.appelOffre.AppelOffre.domain.bean.Offre;
import com.faculte.appelOffre.AppelOffre.domain.bean.OffreDetail;
import com.faculte.appelOffre.AppelOffre.domain.model.service.OffreDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author ASUS
 */
@Service
public class OffreDetailServiceImpl implements OffreDetailService {

    @Autowired
    private OffreDetailDao offreDetailDao;

    @Override
    public int saveOffreDetails(Offre offre, List<OffreDetail> offreDetails) {

        if (offreDetails == null || offreDetails.isEmpty()) {
            return -1;
        } else {
            for (OffreDetail offreDetail : offreDetails) {
                offreDetail.setOffre(offre);
                offreDetailDao.save(offreDetail);
            }
            return 1;
        }

    }

    @Override
    public List<OffreDetail> findByOffreReference(String reference) {
        return offreDetailDao.findByOffreReference(reference);
    }

}
