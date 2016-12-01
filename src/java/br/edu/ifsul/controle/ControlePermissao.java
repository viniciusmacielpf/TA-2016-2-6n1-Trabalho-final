///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package br.edu.ifsul.controle;
//
//import br.edu.ifsul.dao.DAOPermissao;
//import br.edu.ifsul.dao.DAOPermissao;
//import br.edu.ifsul.dao.DAOSetor;
//import br.edu.ifsul.modelo.Permissao;
//import br.edu.ifsul.modelo.Permissao;
//import br.edu.ifsul.modelo.Setor;
//import br.edu.ifsul.util.Util;
//import java.io.Serializable;
//import javax.ejb.EJB;
//import javax.enterprise.context.SessionScoped;
//import javax.inject.Named;
//
///**
// *
// * @author Vini
// */
//@Named(value = "controlePermissao")
//@SessionScoped
//public class ControlePermissao implements Serializable{
//    
//    @EJB
//    private DAOPermissao<Permissao> dao;
//    private Permissao obj;
//    private Boolean editando;
//    @EJB 
//    private DAOSetor<Setor> daoSetor;
//
//    public DAOPermissao<Permissao> getDao() {
//        return dao;
//    } 
//    
//    public String listar(){
//        editando = false;
//        return "/privado/permissao/listar?faces-redirect=true";
//        
//    }
//
//    public void novo(){
//        editando = true;
//        obj = new Permissao();
//    }
//    
//    public void alterar(String id){
//    
//        try {
//            obj = dao.getObjectById(id);
//            editando = true;
//        } catch (Exception e) {
//            Util.mensagemErro("Erro ao recuperar objeto" + Util.geMensagemErro(e));
//        }
//            
//    }
//    
//    public void remover(String id){
//        try {
//            obj = dao.getObjectById(id);
//            dao.remove(obj);
//            Util.mensagemInformacao("Removido com sucesso");
//            
//        } catch (Exception e) {
//            Util.mensagemErro("Erro ao remover objeto" + Util.geMensagemErro(e));
//        }
//    }
//    
//    public void salvar(){
//        try {
//            if(obj.getNome()== null ){
//                dao.persist(obj);
//                        
//            }else {
//                dao.merge(obj);
//            }
//            editando = false;
//            Util.mensagemInformacao("Objeto persistido com sucesso");
//            
//        } catch (Exception e) {
//             Util.mensagemErro("Erro ao remover objeto" + Util.geMensagemErro(e));
//        }
//            
//    }
//    
// 
//
//    public Boolean getEditando() {
//        return editando;
//    }
//
//    public void setEditando(Boolean editando) {
//        this.editando = editando;
//    }
//
//    public DAOSetor<Setor> getDaoSetor() {
//        return daoSetor;
//    }
//
//    public void setDaoSetor(DAOSetor<Setor> daoSetor) {
//        this.daoSetor = daoSetor;
//    }
//
//    public Permissao getObj() {
//        return obj;
//    }
//
//    public void setObj(Permissao obj) {
//        this.obj = obj;
//    }
//     
//    
//}
