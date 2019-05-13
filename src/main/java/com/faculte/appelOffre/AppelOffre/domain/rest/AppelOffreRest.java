/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.rest;

import com.faculte.appelOffre.AppelOffre.domain.rest.converter.AbstractConverter;
import com.faculte.appelOffre.AppelOffre.domain.rest.converter.AppelOffreConverter;
import com.faculte.appelOffre.AppelOffre.domain.rest.Vo.AppelOffreDetailVo;
import com.faculte.appelOffre.AppelOffre.domain.rest.Vo.AppelOffreVo;
import com.faculte.appelOffre.AppelOffre.domain.rest.Vo.OffreVo;
import com.faculte.appelOffre.AppelOffre.domain.bean.AppelOffre;
import com.faculte.appelOffre.AppelOffre.domain.bean.AppelOffreDetail;
import com.faculte.appelOffre.AppelOffre.domain.bean.Offre;
import com.faculte.appelOffre.AppelOffre.domain.model.service.AppelOffreDetailService;
import com.faculte.appelOffre.AppelOffre.domain.model.service.AppelOffreService;
import com.fst.commandeapiv4.common.util.DateUtil;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author YSN
 */
@RestController()
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/AppelOffre/AppelOffres")
public class AppelOffreRest {

    @Autowired
    private AppelOffreService appelOffreService;

    @Autowired
    private AppelOffreDetailService appelOffreDetailService;

    @Autowired
    @Qualifier("appelOffreConverter")
    private AbstractConverter<AppelOffre, AppelOffreVo> appelOffreConverter;

    @Autowired
    @Qualifier("offreConverter")
    private AbstractConverter<Offre, OffreVo> offreConverter;

    @Autowired
    @Qualifier("appelOffreDetailConverter")
    private AbstractConverter<AppelOffreDetail, AppelOffreDetailVo> appelOffreDetailConverter;

    @GetMapping("/objectif/{objectif}/appeloffre-details")
    public List<AppelOffreDetailVo> findByAppelOffre(@PathVariable("objectif") String objectif) {
        final List<AppelOffreDetail> appelOffreDetails = appelOffreDetailService.findByAppelOffreObjectif(objectif);
        return appelOffreDetailConverter.toVo(appelOffreDetails);
    }

    @GetMapping("/appelOffre/reference/{reference}")
    public List<AppelOffreDetailVo> findByAppelOffreReference(@PathVariable("reference") String reference) {
        final List<AppelOffreDetail> appelOffreDetails = appelOffreDetailService.findByAppelOffreReference(reference);
        return appelOffreDetailConverter.toVo(appelOffreDetails);
    }

    @GetMapping("/reference/{reference}")
    public AppelOffreVo findByReference(@PathVariable("reference") String reference) {
        return appelOffreConverter.toVo(appelOffreService.findByReference(reference));
    }

    @GetMapping("/")
    public List<AppelOffreVo> findAll() {
        return appelOffreConverter.toVo(appelOffreService.findAll());
    }

    @PostMapping("/")
    public AppelOffreVo saveAppelOffreWithAppelOffreDetail(@RequestBody AppelOffreVo appelOffreVo) {
        AppelOffre appelOffre = appelOffreConverter.toItem(appelOffreVo);
        AppelOffre appelOffre1 = appelOffreService.saveAppelOffreWithAppelOffreDetails(appelOffre);
        return appelOffreConverter.toVo(appelOffre1);
    }

    @GetMapping("/objectif/{objectif}")
    public AppelOffreVo findByObjectif(@PathVariable("objectif") String objectif) {
        return new AppelOffreConverter().toVo(appelOffreService.findByObjectif(objectif));
    }

    @PutMapping("/offre/reference/{reference}")
    public int offreSelected(@PathVariable String reference) {
        return appelOffreService.offreSelected(reference);
    }

    @DeleteMapping("/reference/{reference}")
    public AppelOffre removeByReference(@PathVariable String reference) {
        return appelOffreService.removeByReference(reference);
    }
    
    

    @PostMapping("/criteria")
    public List<AppelOffreVo> findByCriteria(@RequestBody AppelOffreVo appelOffreVo) {
        System.out.println(appelOffreVo);
        return appelOffreConverter.toVo(appelOffreService.findByCriteria(DateUtil.parse(appelOffreVo.getDateMin()), DateUtil.parse(appelOffreVo.getDateMax()), appelOffreVo.getObjectif(), appelOffreVo.getReference()));
    }
    
    @GetMapping("/reference/{reference}")
    public OffreVo findOffreSelectedByReference(@PathVariable String reference) {
        return offreConverter.toVo(appelOffreService.findOffreSelectedByReference(reference));
    }
    
    

    public AppelOffreService getAppelOffreService() {
        return appelOffreService;
    }

    public void setAppelOffreService(AppelOffreService appelOffreService) {
        this.appelOffreService = appelOffreService;
    }

    public AbstractConverter<AppelOffre, AppelOffreVo> getAppelOffreConverter() {
        return appelOffreConverter;
    }

    public void setAppelOffreConverter(AbstractConverter<AppelOffre, AppelOffreVo> appelOffreConverter) {
        this.appelOffreConverter = appelOffreConverter;
    }

    public AppelOffreDetailService getAppelOffreDetailService() {
        return appelOffreDetailService;
    }

    public void setAppelOffreDetailService(AppelOffreDetailService appelOffreDetailService) {
        this.appelOffreDetailService = appelOffreDetailService;
    }

    public AbstractConverter<Offre, OffreVo> getOffreConverter() {
        return offreConverter;
    }

    public void setOffreConverter(AbstractConverter<Offre, OffreVo> offreConverter) {
        this.offreConverter = offreConverter;
    }

    public AbstractConverter<AppelOffreDetail, AppelOffreDetailVo> getAppelOffreDetailConverter() {
        return appelOffreDetailConverter;
    }

    public void setAppelOffreDetailConverter(AbstractConverter<AppelOffreDetail, AppelOffreDetailVo> appelOffreDetailConverter) {
        this.appelOffreDetailConverter = appelOffreDetailConverter;
    }

}
