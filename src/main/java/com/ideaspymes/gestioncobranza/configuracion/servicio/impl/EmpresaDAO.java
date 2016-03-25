/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.configuracion.servicio.impl;

import com.ideaspymes.gestioncobranza.configuracion.servicio.interfaces.IEmpresaDAO;
import com.ideaspymes.gestioncobranza.configuracion.model.enums.Estado;
import com.ideaspymes.gestioncobranza.configuracion.model.Empresa;
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
public class EmpresaDAO implements IEmpresaDAO {

    @EJB(beanName = "ABMServiceBean")
    private ABMService abmService;

    @Override
    public Empresa create(Empresa entity, Usuario usuario) {
        return abmService.create(entity, usuario);
    }

    @Override
    public Empresa edit(Empresa entity, Usuario usuario) {
        return abmService.update(entity, usuario);
    }

    @Override
    public void remove(Empresa entity, Usuario usuario) {
        abmService.delete(entity, usuario);
    }

    @Override
    public Empresa find(Object id) {
        return abmService.find(id, Empresa.class);
    }

    @Override
    public List<Empresa> findAll() {
        return abmService.getEM().createQuery("select obj from Empresa obj where obj.estado <> :estado")
                .setParameter("estado", Estado.BORRADO)
                .getResultList();
    }

    @Override
    public List<Empresa> findAll(String query, QueryParameter params) {
        return abmService.findByQuery(query, params.parameters());
    }

    @Override
    public List<Empresa> findFilter(String filter) {
        System.out.println("Filters: " + filter);
        Query query = abmService.getEM().createNativeQuery("SELECT * FROM empresa " + filter, Empresa.class);
        List<Empresa> items = (List<Empresa>) query.getResultList();
        return items;
    }
}
