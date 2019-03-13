/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.Rest.Vo;

import com.faculte.appelOffre.AppelOffre.bean.AppelOffreDetail;
import java.math.BigDecimal;
import java.util.List;

/**
 *
 * @author YSN
 */
public class AppelOffreVo {

    private Long id;
    private String objectif;
    private String montantHT;
    private String montantTTC;
    private String montantGarantieTemp;
    private List<AppelOffreDetailVo> appelOffreDetailVo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
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

    public List<AppelOffreDetailVo> getAppelOffreDetailVo() {
        return appelOffreDetailVo;
    }

    public void setAppelOffreDetailVo(List<AppelOffreDetailVo> appelOffreDetailVo) {
        this.appelOffreDetailVo = appelOffreDetailVo;
    }


    
}
