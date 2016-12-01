/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.dao;

import br.edu.ifsul.modelo.Pessoa;
import java.io.Serializable;
import javax.ejb.Stateful;

/**
 *
 * @author Vini
 */
@Stateful
public class DAOPessoa<T> extends DAOGenerico<Pessoa> implements Serializable {

    public DAOPessoa() {
        super();
        super.setClassePersistente(Pessoa.class);
    }

    @Override
    public Pessoa getObjectById(Integer id) throws Exception {
        Pessoa obj = (Pessoa) super.getEm().find(super.getClassePersistente(), id);
        obj.getTelefones().size();
        return obj;

    }
}
