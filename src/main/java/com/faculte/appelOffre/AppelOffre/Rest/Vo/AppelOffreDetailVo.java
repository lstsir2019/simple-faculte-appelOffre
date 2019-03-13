/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.Rest.Vo;



/**
 *
 * @author YSN
 */
public class AppelOffreDetailVo {
    private Long id;
    private String refProduit;
    private String prixUnitaire;
    private String quantite;
    private String total;
    private AppelOffreVo appelOffreVo;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRefProduit() {
        return refProduit;
    }

    public void setRefProduit(String refProduit) {
        this.refProduit = refProduit;
    }

    public String getPrixUnitaire() {
        return prixUnitaire;
    }

    public void setPrixUnitaire(String prixUnitaire) {
        this.prixUnitaire = prixUnitaire;
    }

    public String getQuantite() {
        return quantite;
    }

    public void setQuantite(String quantite) {
        this.quantite = quantite;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public AppelOffreVo getAppelOffreVo() {
        return appelOffreVo;
    }

    public void setAppelOffreVo(AppelOffreVo appelOffreVo) {
        this.appelOffreVo = appelOffreVo;
    }
    
}
