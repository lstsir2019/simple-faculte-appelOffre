/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.rest.Vo;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonSetter;
import java.util.List;

/**
 *
 * @author YSN
 */
public class AppelOffreVo {

    private Long id;
    private String objectif;
    private String reference;
    private String montantHT;
    private String tva;
    private String montantTTC;
    private String montantGarantieTemp;
    private String date;
    private String dateMin ;
    private String dateMax ; 
    private List<AppelOffreDetailVo> appelOffreDetailVo;

    private OffreVo offreSelectedVo;

    public String getDateMin() {
        return dateMin;
    }

    public void setDateMin(String dateMin) {
        this.dateMin = dateMin;
    }

    public String getDateMax() {
        return dateMax;
    }

    public void setDateMax(String dateMax) {
        this.dateMax = dateMax;
    }
    
    

    public OffreVo getOffreSelectedVo() {
        return offreSelectedVo;
    }

    public void setOffreSelectedVo(OffreVo offreSelectedVo) {
        this.offreSelectedVo = offreSelectedVo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getReference() {
        return reference;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }

    public String getObjectif() {
        return objectif;
    }

    public void setObjectif(String objectif) {
        this.objectif = objectif;
    }

    public String getMontantHT() {
        return montantHT;
    }

    public void setMontantHT(String montantHT) {
        this.montantHT = montantHT;
    }

    public String getTva() {
        return tva;
    }

    public void setTva(String tva) {
        this.tva = tva;
    }

    public String getMontantTTC() {
        return montantTTC;
    }

    public void setMontantTTC(String montantTTC) {
        this.montantTTC = montantTTC;
    }

    public String getMontantGarantieTemp() {
        return montantGarantieTemp;
    }

    public void setMontantGarantieTemp(String montantGarantieTemp) {
        this.montantGarantieTemp = montantGarantieTemp;
    }

    @JsonIgnore
    public List<AppelOffreDetailVo> getAppelOffreDetailVo() {
        return appelOffreDetailVo;
    }

    @JsonSetter
    public void setAppelOffreDetailVo(List<AppelOffreDetailVo> appelOffreDetailVo) {
        this.appelOffreDetailVo = appelOffreDetailVo;
    }

    @Override
    public String toString() {
        return "AppelOffreVo{" + "id=" + id + ", objectif=" + objectif + ", reference=" + reference + ", montantHT=" + montantHT + ", tva=" + tva + ", montantTTC=" + montantTTC + ", montantGarantieTemp=" + montantGarantieTemp + ", date=" + date + ", dateMin=" + dateMin + ", dateMax=" + dateMax + ", appelOffreDetailVo=" + appelOffreDetailVo + ", offreSelectedVo=" + offreSelectedVo + '}';
    }

}
