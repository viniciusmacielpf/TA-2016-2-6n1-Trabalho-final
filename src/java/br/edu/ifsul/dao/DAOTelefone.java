/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Telefone;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Vini
 */
@Stateful
public class DAOTelefone<T> extends DAOGenerico<Telefone> implements Serializable{
    public DAOTelefone(){
        super();
        super.setClassePersistente(Telefone.class);
    }
} 
 