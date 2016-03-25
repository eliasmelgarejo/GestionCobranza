 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.configuracion.servicio.interfaces;

import com.ideaspymes.gestioncobranza.configuracion.model.Cliente;
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
public interface IClienteDAO extends AbstractDAO<Cliente> {

    @Override
    Cliente create(Cliente entity, Usuario usuario);

    @Override
    Cliente edit(Cliente entity, Usuario usuario);

    @Override
    Cliente find(Object id);

    @Override
    List<Cliente> findAll();

    @Override
    List<Cliente> findAll(String query, QueryParameter params);

    @Override
    void remove(Cliente entity, Usuario usuario);
    
}
