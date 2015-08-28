/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ec.infocenter.pom_04_web.converter;

import ec.infocenter.pom_01_ldomain.ImalabCabecera;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import javax.ejb.EJB;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;

/**
 *
 * @author christian
 */
@FacesConverter("convv")
public class Converter1 implements Converter {

    @EJB
    private ec.infocenter.pom_04_web.session.ImalabCabeceraFacade ejbFacade;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        System.out.println("object");
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("string = ");
        return null;

    }

    public List<ImalabCabecera> getItemsAvailableSelectMany() {
        return ejbFacade.findAll();
    }
}
