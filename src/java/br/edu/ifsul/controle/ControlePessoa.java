/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.DAOPessoa;
import br.edu.ifsul.dao.DAOTelefone;
import br.edu.ifsul.modelo.Pessoa;
import br.edu.ifsul.modelo.Telefone;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Vini
 */
@Named(value = "controlePessoa")
@SessionScoped
public class ControlePessoa implements Serializable {

    @EJB
    private DAOPessoa<Pessoa> dao;
    private Pessoa obj;
    private Boolean editando;

    private Telefone telefone;
    private Boolean editandoTelefone;
    private Boolean novoTelefone;

    public DAOPessoa<Pessoa> getDao() {
        return dao;
    }

    public String listar() {
        editando = false;
        return "/privado/pessoa/listar?faces-redirect=true";

    }

    public void novo() {
        editando = true;
        editandoTelefone = false;
        obj = new Pessoa();
    }

    public void alterar(Integer id) {

        try {
            obj = dao.getObjectById(id);
            editando = true;
            editandoTelefone = false;
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto" + Util.geMensagemErro(e));
        }

    }

    public void remover(Integer id) {
        try {
            obj = dao.getObjectById(id);
            dao.remove(obj);
            Util.mensagemInformacao("Removido com sucesso");

        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto" + Util.geMensagemErro(e));
        }
    }

    public void salvar() {
        try {
            if (obj.getId() == null) {
                dao.persist(obj);

            } else {
                dao.merge(obj);
            }
            editando = false;
            editandoTelefone = false;
            Util.mensagemInformacao("Objeto persistido com sucesso");

        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto" + Util.geMensagemErro(e));
        }

    }

    public void novoTelefone() {
        telefone = new Telefone();
        editandoTelefone = true;
        novoTelefone = true;
    }

    public void salvarTelefone() {
        if (telefone.getId() == null) {
            if (novoTelefone) {
                obj.addTelefone(telefone);
            } 
        }
        editandoTelefone = false;
        Util.mensagemInformacao("Telefone persistido com sucesso!");
    }

    public void alterarTelefone(int index) {
        telefone = obj.getTelefones().get(index);
        editandoTelefone = true;
        novoTelefone = false;
    }

    public void excluirTelefone(int index) {
        obj.removeTelefone(index);
        Util.mensagemInformacao("Telefone removido com sucesso!");
    }

    public Boolean getEditando() {
        return editando;
    }

    public void setEditando(Boolean editando) {
        this.editando = editando;
    }

    public Pessoa getObj() {
        return obj;
    }

    public void setObj(Pessoa obj) {
        this.obj = obj;
    }

    public Telefone getTelefone() {
        return telefone;
    }

    public void setTelefone(Telefone telefone) {
        this.telefone = telefone;
    }

    public Boolean getEditandoTelefone() {
        return editandoTelefone;
    }

    public void setEditandoTelefone(Boolean editandoTelefone) {
        this.editandoTelefone = editandoTelefone;
    }

    public Boolean getNovoTelefone() {
        return novoTelefone;
    }

    public void setNovoTelefone(Boolean novoTelefone) {
        this.novoTelefone = novoTelefone;
    }

}
