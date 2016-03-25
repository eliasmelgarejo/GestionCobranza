/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.configuracion.servicio.impl;

import com.ideaspymes.gestioncobranza.configuracion.model.Cliente;
import com.ideaspymes.gestioncobranza.configuracion.model.Cliente;
import com.ideaspymes.gestioncobranza.configuracion.model.Persona;
import com.ideaspymes.gestioncobranza.configuracion.model.Usuario;
import com.ideaspymes.gestioncobranza.configuracion.servicio.interfaces.IClienteDAO;
import com.ideaspymes.gestioncobranza.generico.ABMService;
import com.ideaspymes.gestioncobranza.generico.QueryParameter;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.ejb.TransactionAttribute;
import javax.ejb.TransactionAttributeType;
import javax.persistence.Query;


/*
 * @author christian
 */
@Stateless
@TransactionAttribute(TransactionAttributeType.REQUIRES_NEW)
public class ClienteDAO implements IClienteDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Cliente create(Cliente entity, Usuario usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Cliente edit(Cliente entity, Usuario usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Cliente entity, Usuario usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Cliente find(Object id) {
        return abmService.find(id, Cliente.class);
    }

    @Override
    public List<Cliente> findAll() {
        return abmService.getEM().createQuery("select obj from Cliente obj").getResultList();
    }

    @Override
    public List<Cliente> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

    @Override
    public List<Cliente> findFilter(String filter) {
        System.out.println("Filters: " + filter);
        Query query = abmService.getEM().createNativeQuery("SELECT * FROM persona " + filter, Persona.class);
        List<Cliente> items = (List<Cliente>) query.getResultList();
        return items;
    }

}
