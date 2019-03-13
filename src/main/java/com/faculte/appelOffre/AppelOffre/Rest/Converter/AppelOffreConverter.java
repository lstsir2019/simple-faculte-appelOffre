/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.Rest.Converter;

import com.faculte.appelOffre.AppelOffre.Rest.Vo.AppelOffreVo;
import com.faculte.appelOffre.AppelOffre.bean.AppelOffre;
import com.fst.commandeapiv4.common.util.NumberUtil;
import org.springframework.stereotype.Component;



/**
 *
 * @author YSN
 */
@Component
public class AppelOffreConverter extends AbstractConverter<AppelOffre, AppelOffreVo>{

    @Override
    public AppelOffre toItem(AppelOffreVo vo) {
        if(vo==null){
            return null;
        }else{
            AppelOffre item=new AppelOffre();
            item.setObjectif(vo.getObjectif());
            item.setId(vo.getId());
            item.setMontantHT(NumberUtil.toBigDecimal(vo.getMontantHT()));
            item.setMontantTTC(NumberUtil.toBigDecimal(vo.getMontantTTC()));
            item.setMontantGarantieTemp(NumberUtil.toBigDecimal(vo.getMontantGarantieTemp()));
            item.setAppelOffreDetails(new AppelOffreDetailConverter().toItem(vo.getAppelOffreDetailVo()));
            return item;
        }
    }

    @Override
    public AppelOffreVo toVo(AppelOffre item) {
         if (item==null) {
             return null;
        }else{
             AppelOffreVo vo=new AppelOffreVo();
             vo.setId(item.getId());
             vo.setObjectif(item.getObjectif());
             vo.setMontantHT(NumberUtil.toString(item.getMontantHT()));
             vo.setMontantTTC(NumberUtil.toString(item.getMontantTTC()));
             vo.setMontantGarantieTemp(NumberUtil.toString(item.getMontantGarantieTemp()));
             vo.setAppelOffreDetailVo(new AppelOffreDetailConverter().toVo(item.getAppelOffreDetails()));
             return vo;
         }
    }
    
}
