/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.configuracion.servicio.impl;

import com.ideaspymes.gestioncobranza.configuracion.servicio.interfaces.ISucursalDAO;
import com.ideaspymes.gestioncobranza.configuracion.model.enums.Estado;
import com.ideaspymes.gestioncobranza.configuracion.model.Sucursal;
import com.ideaspymes.gestioncobranza.configuracion.model.Usuario;
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
public class SucursalDAO implements ISucursalDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Sucursal create(Sucursal entity, Usuario usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Sucursal edit(Sucursal entity, Usuario usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Sucursal entity, Usuario usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Sucursal find(Object id) {
        return abmService.find(id, Sucursal.class);
    }

    @Override
    public List<Sucursal> findAll() {
        return abmService.getEM().createQuery("select obj from Sucursal obj where obj.estado <> :estado")
                .setParameter("estado", Estado.BORRADO)
                .getResultList();
    }

    @Override
    public List<Sucursal> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

    @Override
    public List<Sucursal> findFilter(String filter) {
        System.out.println("Filters: " + filter);
        Query query = abmService.getEM().createNativeQuery("SELECT * FROM sucursal " + filter, Sucursal.class);
        List<Sucursal> items = (List<Sucursal>) query.getResultList();
        return items;
    }

}
