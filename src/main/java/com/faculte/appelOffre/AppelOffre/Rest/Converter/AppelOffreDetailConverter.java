/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.Rest.Converter;

import com.faculte.appelOffre.AppelOffre.Rest.Vo.AppelOffreDetailVo;
import com.faculte.appelOffre.AppelOffre.bean.AppelOffre;
import com.faculte.appelOffre.AppelOffre.bean.AppelOffreDetail;
import com.fst.commandeapiv4.common.util.NumberUtil;
import org.springframework.stereotype.Component;

/**
 *
 * @author YSN
 */
@Component
public class AppelOffreDetailConverter extends AbstractConverter<AppelOffreDetail, AppelOffreDetailVo>{

    @Override
    public AppelOffreDetail toItem(AppelOffreDetailVo vo) {
        if (vo==null) {
            return null;
        }else{
            AppelOffreDetail item=new AppelOffreDetail();
            item.setId(vo.getId());
            item.setRefProduit(vo.getRefProduit());
            item.setPrixUnitaire(NumberUtil.toBigDecimal(vo.getPrixUnitaire()));
            item.setQuantite(NumberUtil.toBigDecimal(vo.getQuantite()));
            item.setTotal(NumberUtil.toBigDecimal(vo.getTotal()));
            return item;
        }
    }

    @Override
    public AppelOffreDetailVo toVo(AppelOffreDetail item) {
        if(item==null){
        return null;
        }else{
            AppelOffreDetailVo vo=new AppelOffreDetailVo();
            vo.setId(item.getId());
            vo.setRefProduit(item.getRefProduit());
            vo.setPrixUnitaire(NumberUtil.toString(item.getPrixUnitaire()));
            vo.setQuantite(NumberUtil.toString(item.getQuantite()));
            vo.setTotal(NumberUtil.toString(item.getTotal()));
            return vo;
        }
    }

   
    
}
