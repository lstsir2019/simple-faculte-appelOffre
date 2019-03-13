/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.Rest;

import com.faculte.appelOffre.AppelOffre.Rest.Converter.AbstractConverter;
import com.faculte.appelOffre.AppelOffre.Rest.Converter.AppelOffreConverter;
import com.faculte.appelOffre.AppelOffre.Rest.Vo.AppelOffreVo;
import com.faculte.appelOffre.AppelOffre.bean.AppelOffre;
import com.faculte.appelOffre.AppelOffre.service.AppelOffreService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author YSN
 */
@RestController()
@RequestMapping("/AppelOffre/AppelOffres")
public class AppelOffreRest {

    @Autowired
    private AppelOffreService appelOffreService;

    @Autowired
    @Qualifier("appelOffreConverter")
    private AbstractConverter<AppelOffre, AppelOffreVo> appelOffreConverter;

    @PostMapping("/")
    public AppelOffreVo saveAppelOffreWithAppelOffreDetail(@RequestBody AppelOffreVo appelOffreVo) {
        AppelOffre appelOffre= appelOffreConverter.toItem(appelOffreVo);
        AppelOffre appelOffre1= appelOffreService.saveAppelOffreWithAppelOffreDetails(appelOffre);
        return appelOffreConverter.toVo(appelOffre);
    }

    @GetMapping("/objectif/{objectif}")
    public AppelOffreVo findByObjectif(@PathVariable("objectif") String objectif) {
        return new AppelOffreConverter().toVo(appelOffreService.findByObjectif(objectif));
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

   

}
