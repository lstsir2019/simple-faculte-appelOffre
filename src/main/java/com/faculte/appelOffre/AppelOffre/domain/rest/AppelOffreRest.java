/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.rest;

import com.faculte.appelOffre.AppelOffre.common.util.GeneratePdf;
import com.faculte.appelOffre.AppelOffre.domain.rest.converter.AbstractConverter;
import com.faculte.appelOffre.AppelOffre.domain.rest.converter.AppelOffreConverter;
import com.faculte.appelOffre.AppelOffre.domain.rest.Vo.AppelOffreDetailVo;
import com.faculte.appelOffre.AppelOffre.domain.rest.Vo.AppelOffreVo;
import com.faculte.appelOffre.AppelOffre.domain.rest.Vo.OffreVo;
import com.faculte.appelOffre.AppelOffre.domain.bean.AppelOffre;
import com.faculte.appelOffre.AppelOffre.domain.bean.AppelOffreDetail;
import com.faculte.appelOffre.AppelOffre.domain.bean.Offre;
import com.faculte.appelOffre.AppelOffre.domain.bean.OffreDetail;
import com.faculte.appelOffre.AppelOffre.domain.model.service.AppelOffreDetailService;
import com.faculte.appelOffre.AppelOffre.domain.model.service.AppelOffreService;
import com.faculte.appelOffre.AppelOffre.domain.model.service.OffreDetailService;
import com.faculte.appelOffre.AppelOffre.domain.model.service.OffreService;
import com.faculte.appelOffre.AppelOffre.domain.rest.Vo.OffreDetailVo;
import com.fst.commandeapiv4.common.util.DateUtil;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import net.sf.jasperreports.engine.JRException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
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
    private OffreService offreService;

    @Autowired
    private OffreDetailService offreDetailService;

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
    @Autowired
    @Qualifier("offreDetailsConverter")
    private AbstractConverter<OffreDetail, OffreDetailVo> offreDetailConverter;

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

    @GetMapping("/pdf/reference/{reference}")
    public ResponseEntity<Object> imprimerAppelOffreWithOffre(@PathVariable String reference) throws JRException, IOException {
        AppelOffre appelOffre = appelOffreService.findByReference(reference);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("objectif", appelOffre.getObjectif());
        parameters.put("reference", appelOffre.getReference());
        parameters.put("HT", String.valueOf(appelOffre.getMontantHT()));
        parameters.put("ttc", String.valueOf(appelOffre.getMontantTTC()));
        parameters.put("Mgt", String.valueOf(appelOffre.getMontantGarantieTemp()));
        parameters.put("tva", String.valueOf(appelOffre.getTva()));
        List<OffreDetailVo> offreDetails = new ArrayList<>();
        if (appelOffre.getOffreSelected() != null) {
            parameters.put("referenceOffre", appelOffre.getOffreSelected().getReference());
            parameters.put("montantTtcOffre", String.valueOf(appelOffre.getOffreSelected().getMontantTtc()));
            parameters.put("montantHtOffre", String.valueOf(appelOffre.getOffreSelected().getMontantHt()));
            parameters.put("tvaOffre", String.valueOf(appelOffre.getOffreSelected().getTva()));
            parameters.put("fournisseur", appelOffre.getOffreSelected().getRefrenceFournisseur());
            offreDetails = offreDetailConverter.toVo(offreDetailService.findByOffreReference(appelOffre.getOffreSelected().getReference()));

        } else {
            parameters.put("montantTtcOffre", " ");
            parameters.put("montantHtOffre", " ");
            parameters.put("tvaOffre", " ");
            parameters.put("fournisseur", " ");
        }
        if (offreDetails.isEmpty()) {
            offreDetails.add(new OffreDetailVo());
        }

        return GeneratePdf.generate("appelOffre", parameters, offreDetails, "/reports/AppelOffre.jasper");
    }

    @GetMapping("/pdf/referenceOffres/{reference}")
    public ResponseEntity<Object> imprimerAppelOffreWithOffres(@PathVariable String reference) throws JRException, IOException {
        AppelOffre appelOffre = appelOffreService.findByReference(reference);

        Map<String, Object> parameters = new HashMap<>();
        parameters.put("objectif", appelOffre.getObjectif());
        parameters.put("reference", appelOffre.getReference());
        parameters.put("HT", String.valueOf(appelOffre.getMontantHT()));
        parameters.put("ttc", String.valueOf(appelOffre.getMontantTTC()));
        parameters.put("Mgt", String.valueOf(appelOffre.getMontantGarantieTemp()));
        parameters.put("tva", String.valueOf(appelOffre.getTva()));
        List<OffreVo> offres = offreConverter.toVo(offreService.findByAppelOffreReference(reference));

        if (offres.isEmpty()) {
            offres.add(new OffreVo());
        }

        return GeneratePdf.generate("appelOffre", parameters, offres, "/reports/AppelOffreWithOffre.jasper");
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

    @GetMapping("/refrence/{reference}/selected")
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
