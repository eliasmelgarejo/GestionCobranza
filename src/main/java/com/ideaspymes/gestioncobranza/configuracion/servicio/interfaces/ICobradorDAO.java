/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.configuracion.servicio.interfaces;

import com.ideaspymes.gestioncobranza.configuracion.model.Cobrador;
import com.ideaspymes.gestioncobranza.configuracion.model.Usuario;
import com.ideaspymes.gestioncobranza.generico.AbstractDAO;
import com.ideaspymes.gestioncobranza.generico.QueryParameter;
import java.util.List;
import javax.ejb.Local;

/**
 *
 * @author Elias Melgarejo
 */
@Local
public interface ICobradorDAO extends AbstractDAO<Cobrador> {

    @Override
    Cobrador create(Cobrador entity, Usuario usuario);

    @Override
    Cobrador edit(Cobrador entity, Usuario usuario);

    @Override
    Cobrador find(Object id);

    @Override
    List<Cobrador> findAll();

    @Override
    List<Cobrador> findAll(String query, QueryParameter params);

    @Override
    void remove(Cobrador entity, Usuario usuario);

}
