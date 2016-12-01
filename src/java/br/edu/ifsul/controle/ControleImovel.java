/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.controle;

import br.edu.ifsul.dao.DAOCaracteristicas;
import br.edu.ifsul.dao.DAOReparos;
import br.edu.ifsul.dao.DAOImovel;
import br.edu.ifsul.modelo.Caracteristicas;
import br.edu.ifsul.modelo.Reparos;
import br.edu.ifsul.modelo.Imovel;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Vini
 */
@Named(value = "controleImovel")
@SessionScoped
public class ControleImovel implements Serializable {

    @EJB
    private DAOImovel<Imovel> dao;
    private Imovel obj;
    private Boolean editando;

    @EJB
    private DAOReparos<Reparos> daoReparo;
    private Reparos reparo;
    private Boolean editandoReparo;
    @EJB
    private DAOCaracteristicas<Caracteristicas> daoCaracteristicas;
    private Caracteristicas caracteristicas;
    private Boolean editandoCaracteristica;

    public DAOImovel<Imovel> getDao() {
        return dao;
    }

    public String listar() {
        editando = false;
        return "/privado/imovel/listar?faces-redirect=true";

    }

    public void novo() {
        editando = true;
        obj = new Imovel();
        editandoCaracteristica = false;
    }

    public ControleImovel() {
        editando = false;
        editandoCaracteristica = false;
    }

    public void alterar(Integer id) {

        try {
            obj = dao.getObjectById(id);
            editando = true;
            editandoCaracteristica = false;
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
            Util.mensagemInformacao("Objeto persistido com sucesso");

        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto" + Util.geMensagemErro(e));
        }

    }

   

    public void salvarCaracteristicas() {
        if (!obj.getCaracteristicas().contains(caracteristicas)) {
            obj.getCaracteristicas().add(caracteristicas);
            editandoCaracteristica = false;
            Util.mensagemInformacao("Caracteristica adicionada com sucesso!!");
        } else {
            Util.mensagemErro("Caracteristica ja vinculada");
        }
    }

    public void excluirCaracteristica(Caracteristicas objt) {
        try {
            obj.getCaracteristicas().remove(objt);
            Util.mensagemInformacao("Caracteristica Removida");
        } catch (Exception e) {
            System.out.println("Error"+e.getMessage());
        }

    }

    public void novoCaracteristicas() {
        editandoCaracteristica = true;

    }

 

    public void setDao(DAOImovel<Imovel> dao) {
        this.dao = dao;
    }

    public Imovel getObj() {
        return obj;
    }

    public void setObj(Imovel obj) {
        this.obj = obj;
    }

    public Boolean getEditando() {
        return editando;
    }

    public void setEditando(Boolean editando) {
        this.editando = editando;
    }

    public DAOReparos<Reparos> getDaoReparo() {
        return daoReparo;
    }

    public void setDaoReparo(DAOReparos<Reparos> daoReparo) {
        this.daoReparo = daoReparo;
    }

    public Reparos getReparo() {
        return reparo;
    }

    public void setReparo(Reparos reparo) {
        this.reparo = reparo;
    }

    

    public DAOCaracteristicas<Caracteristicas> getDaoCaracteristicas() {
        return daoCaracteristicas;
    }

    public void setDaoCaracteristicas(DAOCaracteristicas<Caracteristicas> daoCaracteristicas) {
        this.daoCaracteristicas = daoCaracteristicas;
    }

    public Caracteristicas getCaracteristicas() {
        return caracteristicas;
    }

    public void setCaracteristicas(Caracteristicas caracteristicas) {
        this.caracteristicas = caracteristicas;
    }

    public Boolean getEditandoCaracteristica() {
        return editandoCaracteristica;
    }

    public void setEditandoCaracteristica(Boolean editandoCaracteristica) {
        this.editandoCaracteristica = editandoCaracteristica;
    }

    public Boolean isEditando() {
        return editando;
    }

   

}
