/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.rest.converter;

import com.faculte.appelOffre.AppelOffre.domain.rest.Vo.OffreVo;
import com.faculte.appelOffre.AppelOffre.domain.bean.Offre;
import com.fst.commandeapiv4.common.util.DateUtil;
import com.fst.commandeapiv4.common.util.NumberUtil;
import org.springframework.stereotype.Component;

/**
 *
 * @author ASUS
 */
@Component
public class OffreConverter extends AbstractConverter<Offre, OffreVo> {
    
    @Override
    public Offre toItem(OffreVo vo) {
        if (vo == null) {
            return null;
        } else {
            Offre item = new Offre();
            item.setId(vo.getId());
            item.setReference(vo.getReference());
            item.setRefrenceFournisseur(vo.getRefrenceFournisseur());
            item.setMontantHt(NumberUtil.toBigDecimal(vo.getMontantHt()));
            item.setMontantTtc(NumberUtil.toBigDecimal(vo.getMontantTtc()));
            item.setTva(NumberUtil.toBigDecimal(vo.getTva()));
            item.setObjectif(vo.getObjectif());
            item.setDate(DateUtil.parse(vo.getDate()));
            item.setAppelOffre(new AppelOffreConverter().toItem(vo.getAppelOffreVo()));
            item.setOffreDetails(new OffreDetailsConverter().toItem(vo.getOffreDetailsVo()));
            return item;
            
        }
    }
    
    @Override
    public OffreVo toVo(Offre item) {
        if (item == null) {
            return new OffreVo();
        } else {
            OffreVo vo = new OffreVo();
            vo.setId(item.getId());
            vo.setReference(item.getReference());
            vo.setRefrenceFournisseur(item.getRefrenceFournisseur());
            vo.setMontantHt(NumberUtil.toString(item.getMontantHt()));
            vo.setTva(NumberUtil.toString(item.getTva()));
            vo.setMontantTtc(NumberUtil.toString(item.getMontantTtc()));
            vo.setAppelOffreVo(new AppelOffreConverter().toVo(item.getAppelOffre()));
            vo.setDate(DateUtil.formateDate(item.getDate()));
            vo.setObjectif(item.getObjectif());
            vo.setOffreDetailsVo(new OffreDetailsConverter().toVo(item.getOffreDetails()));
            return vo;
            
        }
        
    }
    
}
