/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.configuracion.servicio.interfaces;

import com.ideaspymes.gestioncobranza.configuracion.model.Empresa;
import com.ideaspymes.gestioncobranza.configuracion.model.Usuario;
import com.ideaspymes.gestioncobranza.generico.AbstractDAO;
import com.ideaspymes.gestioncobranza.generico.QueryParameter;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Acer
 */
@Local
public interface IEmpresaDAO extends AbstractDAO<Empresa> {

    @Override
    Empresa create(Empresa entity, Usuario usuario);

    @Override
    Empresa edit(Empresa entity, Usuario usuario);

    @Override
    Empresa find(Object id);

    @Override
    List<Empresa> findAll();

    @Override
    List<Empresa> findAll(String query, QueryParameter params);

    @Override
    void remove(Empresa entity, Usuario usuario);

}
