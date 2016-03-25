/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.configuracion.servicio.interfaces;

import com.ideaspymes.gestioncobranza.configuracion.model.Modulo;
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
public interface IModuloDAO extends AbstractDAO<Modulo> {

    @Override
    Modulo create(Modulo entity, Usuario usuario);

    @Override
    Modulo edit(Modulo entity, Usuario usuario);

    @Override
    Modulo find(Object id);

    @Override
    List<Modulo> findAll();

    @Override
    List<Modulo> findAll(String query, QueryParameter params);

    @Override
    void remove(Modulo entity, Usuario usuario);

}
