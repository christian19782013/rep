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
        System.out.println("object:" + value);

        List<ImalabCabecera> lista = new ArrayList<>();
        lista = getItemsAvailableSelectMany();
        Iterator<ImalabCabecera> iterator = lista.iterator();

        while (iterator.hasNext()) {
            ImalabCabecera next = iterator.next();
            if (next.getId().equals(new BigDecimal(value))) {
                System.out.println("next:  " + next.toString());
                return next;
            }

        }
        return null;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        System.out.println("string:" + value);
        
        System.out.println("(valueObj instanceof ImalabCabecera) = " + (value instanceof ImalabCabecera));
        BigDecimal k = (value instanceof ImalabCabecera) ? ((ImalabCabecera) value).getId() : null;

        
        System.out.println("ec.infocenter.pom_01_ldomain.ImalabCabecera[ id=" + k + " ]");
        
        
        System.out.println("k = " + k);
        return (k != null) ? k.toString() : null;

    }

    public List<ImalabCabecera> getItemsAvailableSelectMany() {
        return ejbFacade.findAll();
    }
}
