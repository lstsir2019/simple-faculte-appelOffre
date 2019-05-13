/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.rest.converter;

import com.faculte.appelOffre.AppelOffre.domain.rest.Vo.AppelOffreVo;
import com.faculte.appelOffre.AppelOffre.domain.bean.AppelOffre;
import com.fst.commandeapiv4.common.util.DateUtil;
import com.fst.commandeapiv4.common.util.NumberUtil;
import org.springframework.stereotype.Component;

/**
 *
 * @author YSN
 */
@Component
public class AppelOffreConverter extends AbstractConverter<AppelOffre, AppelOffreVo> {

    @Override
    public AppelOffre toItem(AppelOffreVo vo) {
        if (vo == null) {
            return null;
        } else {
            AppelOffre item = new AppelOffre();
            item.setObjectif(vo.getObjectif());
            item.setId(vo.getId());
            item.setReference(vo.getReference());
            item.setMontantHT(NumberUtil.toBigDecimal(vo.getMontantHT()));
            item.setTva(NumberUtil.toBigDecimal(vo.getTva()));
            item.setMontantTTC(NumberUtil.toBigDecimal(vo.getMontantTTC()));
            item.setMontantGarantieTemp(NumberUtil.toBigDecimal(vo.getMontantGarantieTemp()));
            //   item.setOffreSelected(new OffreConverter().toItem(vo.getOffreSelectedVo()));
            item.setDate(DateUtil.parse(vo.getDate()));
            item.setAppelOffreDetails(new AppelOffreDetailConverter().toItem(vo.getAppelOffreDetailVo()));
            return item;
        }
    }

    @Override
    public AppelOffreVo toVo(AppelOffre item) {
        if (item == null) {
            return null;
        } else {
            AppelOffreVo vo = new AppelOffreVo();
            vo.setId(item.getId());
            vo.setReference(item.getReference());
            vo.setObjectif(item.getObjectif());
            vo.setMontantHT(NumberUtil.toString(item.getMontantHT()));
            vo.setTva(NumberUtil.toString(item.getTva()));
            vo.setMontantTTC(NumberUtil.toString(item.getMontantTTC()));
            vo.setMontantGarantieTemp(NumberUtil.toString(item.getMontantGarantieTemp()));
            vo.setDate(DateUtil.formateDate(item.getDate()));
            vo.setAppelOffreDetailVo(new AppelOffreDetailConverter().toVo(item.getAppelOffreDetails()));
            return vo;
        }
    }

}
