/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.configuracion.model;

import com.ideaspymes.gestioncobranza.configuracion.model.enums.Estado;
import com.ideaspymes.gestioncobranza.configuracion.model.enums.EstadoContactoTelefonico;
import com.ideaspymes.gestioncobranza.configuracion.model.enums.TipoContactoTelefonico;
import com.ideaspymes.gestioncobranza.generico.IAuditable;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.Transient;
import javax.persistence.Version;

/**
 *
 * @author ACER
 */
@Entity
public class ContactoTelefonico implements Serializable, IAuditable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    private String numero;
    private TipoContactoTelefonico tipo;
    private boolean principal;
    @Enumerated(EnumType.STRING)
    private EstadoContactoTelefonico estadoContactoTelefonico;
    @ManyToOne
    private Cliente cliente;
    @Transient
    private String estiloPrincipal;

    //Auditoria
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegitro;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaUltimaModificacion;
    @ManyToOne
    private Usuario usuarioUltimaModificacion;

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public TipoContactoTelefonico getTipo() {
        return tipo;
    }

    public void setTipo(TipoContactoTelefonico tipo) {
        this.tipo = tipo;
    }

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public EstadoContactoTelefonico getEstadoContactoTelefonico() {
        return estadoContactoTelefonico;
    }

    public void setEstadoContactoTelefonico(EstadoContactoTelefonico estadoContactoTelefonico) {
        this.estadoContactoTelefonico = estadoContactoTelefonico;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public Date getFechaRegitro() {
        return fechaRegitro;
    }

    public void setFechaRegitro(Date fechaRegitro) {
        this.fechaRegitro = fechaRegitro;
    }

    public Date getFechaUltimaModificacion() {
        return fechaUltimaModificacion;
    }

    public void setFechaUltimaModificacion(Date fechaUltimaModificacion) {
        this.fechaUltimaModificacion = fechaUltimaModificacion;
    }

    public Usuario getUsuarioUltimaModificacion() {
        return usuarioUltimaModificacion;
    }

    public void setUsuarioUltimaModificacion(Usuario usuarioUltimaModificacion) {
        this.usuarioUltimaModificacion = usuarioUltimaModificacion;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public boolean isPrincipal() {
        return principal;
    }

    public void setPrincipal(boolean principal) {
        this.principal = principal;
    }

    public String getEstiloPrincipal() {
        if (principal) {
            estiloPrincipal = "background-color:#22bbcc";
        }
        return estiloPrincipal;
    }

    public void setEstiloPrincipal(String estiloPrincipal) {
        this.estiloPrincipal = estiloPrincipal;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof ContactoTelefonico)) {
            return false;
        }
        ContactoTelefonico other = (ContactoTelefonico) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    public boolean igual(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final ContactoTelefonico other = (ContactoTelefonico) obj;
        if ((this.numero == null) ? (other.numero != null) : !this.numero.equals(other.numero)) {
            return false;
        }
        if (this.tipo != other.tipo) {
            return false;
        }
        if (this.principal != other.principal) {
            return false;
        }
        if (this.estado != other.estado) {
            return false;
        }
        if (this.cliente != other.cliente && (this.cliente == null || !this.cliente.equals(other.cliente))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.ideaspymes.facilerp.pesistencia.base.ContactoTelefonico[ id=" + id + " ]";
    }

}
