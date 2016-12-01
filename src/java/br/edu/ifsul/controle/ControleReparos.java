/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package br.edu.ifsul.controle;

import br.edu.ifsul.dao.DAOReparos;
import br.edu.ifsul.modelo.Imovel;
import br.edu.ifsul.modelo.Reparos;
import br.edu.ifsul.util.Util;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author Vini
 */
@Named(value = "controleReparo")
@SessionScoped
public class ControleReparos implements Serializable{
    
    @EJB
    private DAOReparos<Reparos> dao;
   
    private Reparos obj;
    private Boolean editando;
    

    public DAOReparos<Reparos> getDao() {
        return dao;
    }
    
    public String listar(){
        editando = false;
        return "/privado/reparos/listar?faces-redirect=true";
        
    }

    public void novo(){
        editando = true;
        obj = new Reparos();
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

   
    public Reparos getObj() {
        return obj;
    }

    public void setObj(Reparos obj) {
        this.obj = obj;
    }
     
    
}
