/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Imovel;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Vini
 */
@Stateful
public class DAOImovel<T> extends DAOGenerico<Imovel> implements Serializable {

    public DAOImovel() {
        super(); 
        super.setClassePersistente(Imovel.class);
    }
    
     @Override
    public Imovel getObjectById(Integer id) throws Exception {
        Imovel obj = (Imovel) super.getEm().find(super.getClassePersistente(), id);
        obj.getCaracteristicas().size();
        return obj;
    }

}
