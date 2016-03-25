/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.web.converters;

import com.ideaspymes.gestioncobranza.configuracion.model.Cliente;
import com.ideaspymes.gestioncobranza.generico.ConverterGenerico;
import javax.faces.convert.FacesConverter;


/**
 *
 * @author christian
 */
@FacesConverter(forClass = Cliente.class)
public class ClienteConverter extends ConverterGenerico<Cliente> {

    @Override
    public String getBeanName() {
        return "clienteBean";
    }
}
