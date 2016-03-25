/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.configuracion.model;

import com.ideaspymes.gestioncobranza.configuracion.model.enums.Estado;
import com.ideaspymes.gestioncobranza.configuracion.model.enums.EstadoGestionReclamoDetalle;
import com.ideaspymes.gestioncobranza.generico.IAuditable;
import com.ideaspymes.gestioncobranza.generico.Listado;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;

/**
 *
 * @author Elias
 */
@Entity
public class GestionReclamoDetalle implements Serializable, IAuditable {
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @ManyToOne
    @Listado(descripcion = "Respuesta",mostrar=true)
    private Respuesta respuesta;
    @Listado(descripcion = "Fecha",mostrar = true)
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fecha;
    @ManyToOne
    private GestionReclamo gestionReclamo;
    @OneToOne
    private TipoGestionReclamoDetalle tipoGestionReclamoDetalle;
    @Listado(descripcion = "Estado",mostrar = true)
    @Enumerated(EnumType.STRING)
    private EstadoGestionReclamoDetalle estadoGestionReclamoDetalle;
    
     //Auditoria
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegitro;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaUltimaModificacion;
    @ManyToOne
    private Usuario usuarioUltimaModificacion;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public EstadoGestionReclamoDetalle getEstadoGestionReclamoDetalle() {
        return estadoGestionReclamoDetalle;
    }

    public void setEstadoGestionReclamoDetalle(EstadoGestionReclamoDetalle estadoGestionReclamoDetalle) {
        this.estadoGestionReclamoDetalle = estadoGestionReclamoDetalle;
    }

    public GestionReclamo getGestionReclamo() {
        return gestionReclamo;
    }

    public void setGestionReclamo(GestionReclamo gestionReclamo) {
        this.gestionReclamo = gestionReclamo;
    }

    public Respuesta getRespuesta() {
        return respuesta;
    }

    public void setRespuesta(Respuesta respuesta) {
        this.respuesta = respuesta;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

    public TipoGestionReclamoDetalle getTipoGestionReclamoDetalle() {
        return tipoGestionReclamoDetalle;
    }

    public void setTipoGestionReclamoDetalle(TipoGestionReclamoDetalle tipoGestionReclamoDetalle) {
        this.tipoGestionReclamoDetalle = tipoGestionReclamoDetalle;
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

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof GestionReclamoDetalle)) {
            return false;
        }
        GestionReclamoDetalle other = (GestionReclamoDetalle) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ideaspymes.gestioncobranza.configuracion.model.Ejemplo[ id=" + id + " ]";
    }
    
}
