/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.configuracion.servicio.impl;

import com.ideaspymes.gestioncobranza.configuracion.model.Cobrador;
import com.ideaspymes.gestioncobranza.configuracion.model.Cobrador;
import com.ideaspymes.gestioncobranza.configuracion.model.Usuario;
import com.ideaspymes.gestioncobranza.configuracion.servicio.interfaces.ICobradorDAO;
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
public class CobradorDAO implements ICobradorDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Cobrador create(Cobrador entity, Usuario usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Cobrador edit(Cobrador entity, Usuario usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Cobrador entity, Usuario usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Cobrador find(Object id) {
        return abmService.find(id, Cobrador.class);
    }

    @Override
    public List<Cobrador> findAll() {
        return abmService.getEM().createQuery("select obj from Cobrador obj").getResultList();
    }

    @Override
    public List<Cobrador> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }
    
    @Override
    public List<Cobrador> findFilter(String filter) {
        System.out.println("Filters: " + filter);
        Query query = abmService.getEM().createNativeQuery("SELECT * FROM cobrador " + filter, Cobrador.class);
        List<Cobrador> items = (List<Cobrador>) query.getResultList();
        return items;
    }

}
