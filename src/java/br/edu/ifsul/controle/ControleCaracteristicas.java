/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.controle;

import br.edu.ifsul.dao.DAOCaracteristicas;
import br.edu.ifsul.modelo.Caracteristicas;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Vini
 */
@Named(value = "controleCaracteristicas")
@SessionScoped
public class ControleCaracteristicas implements Serializable{
     
    @EJB
    private DAOCaracteristicas<Caracteristicas> dao;
    private Caracteristicas obj;
    private Boolean editando;
    

    public DAOCaracteristicas<Caracteristicas> getDao() {
        return dao;
    }
    
    public String listar(){
        editando = false;
        return "/privado/caracteristicas/listar?faces-redirect=true";
        
    }

    public void novo(){
        editando = true;
        obj = new Caracteristicas();
    }
    
    public void alterar(Integer id){
    
        try {
            obj = dao.getObjectById(id);
            editando = true; 
        } catch (Exception e) {
            Util.mensagemErro("Erro ao recuperar objeto" + Util.geMensagemErro(e));
        }
            
    }
    
    public void remover(Integer id){
        try {
            obj = dao.getObjectById(id);
            dao.remove(obj);
            Util.mensagemInformacao("Removido com sucesso");
            
        } catch (Exception e) {
            Util.mensagemErro("Erro ao remover objeto" + Util.geMensagemErro(e));
        }
    }
    
    public void salvar(){
        try {
            if(obj.getId() == null ){
                dao.persist(obj);
                        
            }else {
                dao.merge(obj);
            }
            editando = false;
            Util.mensagemInformacao("Objeto persistido com sucesso");
            
        } catch (Exception e) {
             Util.mensagemErro("Erro ao remover objeto" + Util.geMensagemErro(e));
        }
            
    }
    
 

    public Boolean getEditando() {
        return editando;
    }

    public void setEditando(Boolean editando) {
        this.editando = editando;
    }

   
    public Caracteristicas getObj() {
        return obj;
    }

    public void setObj(Caracteristicas obj) {
        this.obj = obj;
    }
     
     
}
