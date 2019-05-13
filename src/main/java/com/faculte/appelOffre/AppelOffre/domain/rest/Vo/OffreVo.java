/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.rest.Vo;

import com.fasterxml.jackson.annotation.JsonGetter;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.List;

/**
 *
 * @author ASUS
 */
public class OffreVo {

    private Long id;
    private String objectif;
    private String reference;
    private String refrenceFournisseur;
    private String montantTtc;
    private String tva;
    private String montantHt;
    private String date;
    private AppelOffreVo appelOffreVo;

    private List<OffreDetailVo> offreDetailsVo;

    public OffreVo() {
    }

    public OffreVo(String reference) {
        this.reference = reference;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public AppelOffreVo getAppelOffreVo() {
        return appelOffreVo;
    }

    public void setAppelOffreVo(AppelOffreVo appelOffreVo) {
        this.appelOffreVo = appelOffreVo;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getRefrenceFournisseur() {
        return refrenceFournisseur;
    }

    public void setRefrenceFournisseur(String refrenceFournisseur) {
        this.refrenceFournisseur = refrenceFournisseur;
    }

    public String getMontantTtc() {
        return montantTtc;
    }

    public void setMontantTtc(String montantTtc) {
        this.montantTtc = montantTtc;
    }

    public String getTva() {
        return tva;
    }

    public void setTva(String tva) {
        this.tva = tva;
    }

    public String getMontantHt() {
        return montantHt;
    }

    public void setMontantHt(String montantHt) {
        this.montantHt = montantHt;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    @JsonIgnore
    public List<OffreDetailVo> getOffreDetailsVo() {
        return offreDetailsVo;
    }

    @JsonSetter
    public void setOffreDetailsVo(List<OffreDetailVo> offreDetailsVo) {
        this.offreDetailsVo = offreDetailsVo;
    }

    @Override
    public String toString() {
        return "OffreVo{" + "id=" + id + ", objectif=" + objectif + ", reference=" + reference + ", refProduit=" + refrenceFournisseur + ", montantTtc=" + montantTtc + ", tva=" + tva + ", montantHt=" + montantHt + ", date=" + date + ", appelOffreVo=" + appelOffreVo + ", offreDetailsVo=" + offreDetailsVo + '}';
    }

}
