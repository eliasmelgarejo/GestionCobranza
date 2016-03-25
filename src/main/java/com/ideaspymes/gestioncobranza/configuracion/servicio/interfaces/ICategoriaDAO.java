/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.configuracion.servicio.interfaces;

import com.ideaspymes.gestioncobranza.configuracion.model.Categoria;
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
public interface ICategoriaDAO extends AbstractDAO<Categoria> {

    @Override
    Categoria create(Categoria entity, Usuario usuario);

    @Override
    Categoria edit(Categoria entity, Usuario usuario);

    @Override
    Categoria find(Object id);

    @Override
    List<Categoria> findAll();

    @Override
    List<Categoria> findAll(String query, QueryParameter params);

    @Override
    void remove(Categoria entity, Usuario usuario);
    
}
