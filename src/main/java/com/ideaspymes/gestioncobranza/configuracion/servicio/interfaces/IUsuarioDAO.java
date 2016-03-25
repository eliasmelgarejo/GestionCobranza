/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.configuracion.servicio.interfaces;

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
public interface IUsuarioDAO extends AbstractDAO<Usuario> {

    @Override
    Usuario create(Usuario entity, Usuario usuario);

    @Override
    Usuario edit(Usuario entity, Usuario usuario);

    @Override
    Usuario find(Object id);

    @Override
    List<Usuario> findAll();

    @Override
    List<Usuario> findAll(String query, QueryParameter params);

    @Override
    void remove(Usuario entity, Usuario usuario);

}
