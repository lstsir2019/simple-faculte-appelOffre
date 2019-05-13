/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.model.dao;

import com.faculte.appelOffre.AppelOffre.domain.bean.OffreDetail;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 *
 * @author ASUS
 */
public interface OffreDetailDao extends JpaRepository<OffreDetail, Long> {

    public List<OffreDetail> findByOffreReference(String reference);

}
