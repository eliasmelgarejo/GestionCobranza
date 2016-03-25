/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.web;

import com.ideaspymes.gestioncobranza.configuracion.model.Cliente;
import com.ideaspymes.gestioncobranza.configuracion.servicio.interfaces.IClienteDAO;
import com.ideaspymes.gestioncobranza.generico.AbstractDAO;
import com.ideaspymes.gestioncobranza.generico.BeanGenerico;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author christian
 */
@Named
@ViewScoped
public class ClienteBean extends BeanGenerico<Cliente> implements Serializable {

    @EJB
    private IClienteDAO ejb;

    @Override
    public AbstractDAO<Cliente> getEjb() {
        return ejb;
    }

    @Override
    public Cliente getNuevo() {
        return new Cliente();
    }

}
