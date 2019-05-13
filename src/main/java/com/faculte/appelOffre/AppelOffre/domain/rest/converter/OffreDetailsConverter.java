/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.rest.converter;

import com.faculte.appelOffre.AppelOffre.domain.rest.Vo.OffreDetailVo;
import com.faculte.appelOffre.AppelOffre.domain.bean.OffreDetail;
import com.fst.commandeapiv4.common.util.NumberUtil;
import org.springframework.stereotype.Component;

/**
 *
 * @author ASUS
 */
@Component
public class OffreDetailsConverter extends AbstractConverter<OffreDetail, OffreDetailVo> {

    @Override
    public OffreDetail toItem(OffreDetailVo vo) {
        if (vo == null) {
            return null;
        } else {
            OffreDetail item = new OffreDetail();
            item.setId(vo.getId());
            item.setPrixUnitaire(NumberUtil.toBigDecimal(vo.getPrixUnitaire()));
            item.setQuantite(NumberUtil.toBigDecimal(vo.getQuantite()));
            item.setRefProduit(vo.getRefProduit());
            item.setTotal(NumberUtil.toBigDecimal(vo.getTotal()));
           // item.setOffre(new OffreConverter().toItem(vo.getOffreVo()));
            return item;

        }
    }

    @Override
    public OffreDetailVo toVo(OffreDetail item) {
        if (item == null) {
            return null;
        } else {
            OffreDetailVo vo = new OffreDetailVo();
            vo.setId(item.getId());
            vo.setPrixUnitaire(NumberUtil.toString(item.getPrixUnitaire()));
            vo.setQuantite(NumberUtil.toString(item.getQuantite()));
            vo.setRefProduit(item.getRefProduit());
            vo.setTotal(NumberUtil.toString(item.getTotal()));
            vo.setPrixUnitaire(NumberUtil.toString(item.getPrixUnitaire()));
          //  vo.setOffreVo(new OffreConverter().toVo(item.getOffre()));
            return vo;
        }
    }

}
