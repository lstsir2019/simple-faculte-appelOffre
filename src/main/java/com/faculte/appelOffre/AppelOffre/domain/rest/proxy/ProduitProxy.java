/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.domain.rest.proxy;

import com.faculte.appelOffre.AppelOffre.domain.rest.Vo.exchange.ProduitVo;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;



/**
 *
 * @author YSN
 */
@FeignClient(name = "microservice-produits", url = "localhost:8070")
public interface ProduitProxy {

    @GetMapping("/produit_api/produit/reference/{reference}")
    public ProduitVo findByReference(@PathVariable("reference") String reference);
//    @GetMapping("/produit_api/produit/")
//    public List<ProduitVo> findAll();

}
