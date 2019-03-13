/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.faculte.appelOffre.AppelOffre.Rest.Converter;

import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author YSN
 */
public abstract class AbstractConverter<T,Vo> {
    public abstract T toItem(Vo vo);
    public  abstract Vo toVo(T item);
    public List<T> toItem(List<Vo> vos){
        if (vos==null ||vos.isEmpty()) {
            return null;
        }else{
            List<T> items =new ArrayList();
            for (Vo vo : vos) {
                items.add(toItem(vo));
            }
            return items;
        }
    }
    
    public List<Vo> toVo(List<T> Items){
         if (Items==null ||Items.isEmpty()) {
            return null;
        }else{
            List<Vo> vos =new ArrayList();
            for (T item : Items) {
                vos.add(toVo(item));
            }
            return vos ;
        }
    }
    
}