/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.rest;

import com.faculte.appelOffre.AppelOffre.domain.rest.converter.AbstractConverter;
import com.faculte.appelOffre.AppelOffre.domain.rest.Vo.OffreDetailVo;
import com.faculte.appelOffre.AppelOffre.domain.bean.OffreDetail;
import com.faculte.appelOffre.AppelOffre.domain.model.service.OffreDetailService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author ASUS
 */
@RestController
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/appelOffre-api/offreDetails")
public class OffreDetailRest {

    @Autowired
    private OffreDetailService detailService;
    @Autowired
    //  @Qualifier("offreDetailConverter")
    private AbstractConverter<OffreDetail, OffreDetailVo> offreDetailConverter;

    @GetMapping("/offre/reference/{reference}")
    public List<OffreDetailVo> findByOffreReference(@PathVariable String reference) {
        return offreDetailConverter.toVo(detailService.findByOffreReference(reference));
    }

}
