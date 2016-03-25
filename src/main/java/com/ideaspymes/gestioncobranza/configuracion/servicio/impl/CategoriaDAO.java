/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.configuracion.servicio.impl;

import com.ideaspymes.gestioncobranza.configuracion.model.Categoria;
import com.ideaspymes.gestioncobranza.configuracion.model.Usuario;
import com.ideaspymes.gestioncobranza.configuracion.servicio.interfaces.ICategoriaDAO;
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
public class CategoriaDAO implements ICategoriaDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Categoria create(Categoria entity, Usuario usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Categoria edit(Categoria entity, Usuario usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Categoria entity, Usuario usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Categoria find(Object id) {
        return abmService.find(id, Categoria.class);
    }

    @Override
    public List<Categoria> findAll() {
        return abmService.getEM().createQuery("select obj from Categoria obj").getResultList();
    }

    @Override
    public List<Categoria> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

    @Override
    public List<Categoria> findFilter(String filter) {
        System.out.println("Filters: " + filter);
        Query query = abmService.getEM().createNativeQuery("SELECT * FROM categoria " + filter, Categoria.class);
        List<Categoria> items = (List<Categoria>) query.getResultList();
        return items;
    }

}
