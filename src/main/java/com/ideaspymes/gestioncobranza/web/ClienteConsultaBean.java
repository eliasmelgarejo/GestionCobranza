/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.web;

import com.ideaspymes.gestioncobranza.configuracion.model.Cliente;
import com.ideaspymes.gestioncobranza.configuracion.servicio.interfaces.IClienteDAO;
import com.ideaspymes.gestioncobranza.generico.AbstractDAO;
import com.ideaspymes.gestioncobranza.generico.ConsultaGenerico;
import java.io.Serializable;
import javax.ejb.EJB;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 *
 * @author Christian
 */
@Named
@ViewScoped
public class ClienteConsultaBean extends ConsultaGenerico<Cliente> implements Serializable {

    @EJB
    private IClienteDAO ejb;

    @Override
    public Class<Cliente> getClazz() {
        return Cliente.class;
    }

    @Override
    public AbstractDAO<Cliente> getEjb() {
        return ejb;
    }

}
