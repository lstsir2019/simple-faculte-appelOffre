/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.rest;

import com.faculte.appelOffre.AppelOffre.domain.rest.converter.AbstractConverter;
import com.faculte.appelOffre.AppelOffre.domain.rest.converter.OffreConverter;
import com.faculte.appelOffre.AppelOffre.domain.rest.Vo.OffreDetailVo;
import com.faculte.appelOffre.AppelOffre.domain.rest.Vo.OffreVo;
import com.faculte.appelOffre.AppelOffre.domain.bean.Offre;
import com.faculte.appelOffre.AppelOffre.domain.bean.OffreDetail;
import com.faculte.appelOffre.AppelOffre.domain.model.service.OffreDetailService;
import com.faculte.appelOffre.AppelOffre.domain.model.service.OffreService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
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
 * @author ASUS
 */
@RestController()
@CrossOrigin(origins = {"http://localhost:4200"})
@RequestMapping("/appelOffre-api/offres")
public class OffreRest {

    @Autowired
    private OffreService offreService;

    @Autowired
    private OffreDetailService offreDetailService;

    @Autowired
    //  @Qualifier("offreDetailConverter")
    private AbstractConverter<OffreDetail, OffreDetailVo> offreDetailConverter;

    @Autowired
    //  @Qualifier("offreConverter")
    private AbstractConverter<Offre, OffreVo> offreConverter;

    @PostMapping("/")
    public OffreVo create(@RequestBody OffreVo offreVo) {
        Offre offre = offreConverter.toItem(offreVo);
        return offreConverter.toVo(offreService.createOffrewithOffreDetails(offre));
    }

    @PutMapping("/")
    public Offre updateOffre(@RequestBody Offre offre) {
        return offreService.updateOffre(offre);
    }

//    @DeleteMapping("/")
//    public int deleteOffre(@RequestBody OffreVo offreVo) {
//        return offreService.deleteOffre(offreConverter.toItem(offreVo));
//    }

    @DeleteMapping("/reference/{reference}")
    public int deleteOffre(@PathVariable String reference) {
        return offreService.deleteOffre(offreConverter.toItem(new OffreVo(reference)));
    }

    @GetMapping("/reference/{reference}")
    public OffreVo findByReference(@PathVariable String reference) {
        OffreConverter offreConverter = new OffreConverter();
        return offreConverter.toVo(offreService.findByReference(reference));
    }

    @GetMapping("/")
    public List<OffreVo> findAll() {
        OffreConverter offreConverter = new OffreConverter();
        return offreConverter.toVo(offreService.findAll());
    }

    @GetMapping("/apeloffre/reference/{reference}")
    public List<OffreVo> findByAppelOffreReference(@PathVariable String reference) {
        OffreConverter offreConverter = new OffreConverter();
        return offreConverter.toVo(offreService.findByAppelOffreReference(reference));
    }

    public OffreService getOffreService() {
        return offreService;
    }

    public void setOffreService(OffreService offreService) {
        this.offreService = offreService;
    }

    public OffreDetailService getOffreDetailService() {
        return offreDetailService;
    }

    public void setOffreDetailService(OffreDetailService offreDetailService) {
        this.offreDetailService = offreDetailService;
    }

}
