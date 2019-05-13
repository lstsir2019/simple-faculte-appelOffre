/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.model.dao;

import com.faculte.appelOffre.AppelOffre.domain.bean.AppelOffre;
import com.faculte.appelOffre.AppelOffre.domain.bean.AppelOffreDetail;
import java.util.List;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author YSN
 */
@Repository
public interface AppelOffreDetailDao extends JpaRepository<AppelOffreDetail, Long> {

    public List<AppelOffreDetail> findByAppelOffreObjectif(String objectif);

    public List<AppelOffreDetail> findByAppelOffreReference(String reference);
}
