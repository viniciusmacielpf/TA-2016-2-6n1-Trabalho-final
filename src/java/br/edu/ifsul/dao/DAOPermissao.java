///*
// * To change this license header, choose License Headers in Project Properties.
// * To change this template file, choose Tools | Templates
// * and open the template in the editor.
// */
//
//package br.edu.ifsul.dao;
//
//import br.edu.ifsul.modelo.Permissao;
//import java.io.Serializable;
//import java.util.List;
//import javax.ejb.Stateful;
//
///**
// *
// * @author Vini
// */
//@Stateful
//public class DAOPermissao<T> extends DAOGenerico<Permissao> implements Serializable{
//    public DAOPermissao(){
//        super();
//        super.setOrdem("nome");
//        super.setClassePersistente(Permissao.class);
//    }
//    
//    public T getObjectById(String id) throws Exception {
//        return (T) super.getEm().find(super.getClassePersistente(), id);
//    }
//    
//    public List<Permissao> getListaObjetos() {
//        String jpql = "from " + super.getClassePersistente().getSimpleName();
//        String where = "";
//        super.setFiltro(super.getFiltro().replaceAll("[';-]",""));
//        if (super.getFiltro().length() > 0) {
//            if (super.getOrdem().equals("nome")) {
//                try {
//                    where += " where " + super.getOrdem() + " = '" + super.getFiltro() + "' ";
//                } catch (Exception e) {
//                    System.out.println("erro" + e.getMessage());
//                }
//            } else {
//                where += " where upper(" + super.getOrdem() + ") like '" + super.getFiltro().toUpperCase() + "%' ";
//            }
//        } 
//        jpql += where;
//        jpql += " order by " + super.getOrdem();
////        System.out.println("jpql"+jpql);
//        super.setTotalObjetos(super.getEm().createQuery("select id from " + super.getClassePersistente().getSimpleName() + where
//                + " order by " + super.getOrdem()).getResultList().size());
//
//        return super.getEm().createQuery(jpql).setFirstResult(super.getPosicaoAtual()).setMaxResults(super.getMaximoObjetos()).getResultList();
//
//    }
//} 
// 