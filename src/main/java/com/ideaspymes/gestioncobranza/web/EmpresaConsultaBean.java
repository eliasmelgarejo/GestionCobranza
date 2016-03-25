/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.web;

import com.ideaspymes.gestioncobranza.configuracion.model.Empresa;
import com.ideaspymes.gestioncobranza.configuracion.servicio.interfaces.IEmpresaDAO;
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
public class EmpresaConsultaBean extends ConsultaGenerico<Empresa> implements Serializable {

    @EJB
    private IEmpresaDAO ejb;

    @Override
    public Class<Empresa> getClazz() {
        return Empresa.class;
    }

    @Override
    public AbstractDAO<Empresa> getEjb() {
        return ejb;
    }

}
