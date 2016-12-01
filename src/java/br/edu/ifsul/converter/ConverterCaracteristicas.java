/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifsul.converter;


import br.edu.ifsul.modelo.Caracteristicas;
import java.io.Serializable;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author Vini
 */
@FacesConverter(value = "converterCaracteristicas")
public class ConverterCaracteristicas implements Serializable, Converter {

    @PersistenceContext(unitName = "TA-2016-2-6n1-Mode-TrabalholPU")
    private EntityManager em;

    //converte da tela para o objeto - parm string ID to objeto
    @Override
    public Object getAsObject(FacesContext fc, UIComponent uic, String string) {
        if (string == null || string.equals("Selecione um registro")) {
            return null;
        }
        return em.find(Caracteristicas.class, Integer.parseInt(string));
    }

    @Override 
    public String getAsString(FacesContext fc, UIComponent uic, Object o) {
        if (o == null) {
            return null;
        }
        Caracteristicas obj = (Caracteristicas) o;
        return obj.getId().toString();
    }

}
