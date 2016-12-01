/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Caracteristicas;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Vini
 */
@Stateful
public class DAOCaracteristicas<T> extends DAOGenerico<Caracteristicas> implements Serializable{
    public DAOCaracteristicas(){
        super();
        super.setClassePersistente(Caracteristicas.class);
    }
}  
 