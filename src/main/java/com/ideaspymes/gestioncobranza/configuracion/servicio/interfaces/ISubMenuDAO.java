/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.configuracion.servicio.interfaces;

import com.ideaspymes.gestioncobranza.configuracion.model.SubMenu;
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
public interface ISubMenuDAO extends AbstractDAO<SubMenu> {

    @Override
    SubMenu create(SubMenu entity, Usuario usuario);

    @Override
    SubMenu edit(SubMenu entity, Usuario usuario);

    @Override
    SubMenu find(Object id);

    @Override
    List<SubMenu> findAll();

    @Override
    List<SubMenu> findAll(String query, QueryParameter params);

    @Override
    void remove(SubMenu entity, Usuario usuario);

}
