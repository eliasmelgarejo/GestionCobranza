/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.configuracion.model;

import com.ideaspymes.gestioncobranza.configuracion.model.enums.CicloIngreso;
import com.ideaspymes.gestioncobranza.configuracion.model.enums.Estado;
import com.ideaspymes.gestioncobranza.configuracion.model.enums.TipoEmpresa;
import com.ideaspymes.gestioncobranza.generico.IAuditable;
import java.io.Serializable;
import java.util.Date;
import javax.persistence.*;
import javax.validation.constraints.NotNull;

/**
 *
 * @author christian
 */
@Entity
public class ActividadLaboral implements Serializable, IAuditable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Version
    private Long version;
    @NotNull
    private String nombreEmpresa;
    private String cargo;
    @NotNull
    private double ingreso;
    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaIngreso;
    @Enumerated(EnumType.STRING)
    private CicloIngreso cicloIngreso;
    @Enumerated(EnumType.STRING)
    private TipoEmpresa tipoEmpresa;
    private boolean aportaIPS;
    @ManyToOne
    private Cliente cliente;

    //Auditoria
    @Enumerated(EnumType.STRING)
    private Estado estado;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaRegitro;
    @Temporal(javax.persistence.TemporalType.TIMESTAMP)
    private Date fechaUltimaModificacion;
    @ManyToOne
    private Usuario usuarioUltimaModificacion;

    public ActividadLaboral() {

        this.estado = Estado.ACTIVO;
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

    public Long getVersion() {
        return version;
    }

    public void setVersion(Long version) {
        this.version = version;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Estado getEstado() {
        return estado;
    }

    public void setEstado(Estado estado) {
        this.estado = estado;
    }

    public boolean isAportaIPS() {
        return aportaIPS;
    }

    public void setAportaIPS(boolean aportaIPS) {
        this.aportaIPS = aportaIPS;
    }

    @Override
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCargo() {
        return cargo;
    }

    public void setCargo(String cargo) {
        this.cargo = cargo.toUpperCase();
    }

    public CicloIngreso getCicloIngreso() {
        return cicloIngreso;
    }

    public void setCicloIngreso(CicloIngreso cicloIngreso) {
        this.cicloIngreso = cicloIngreso;
    }

    public Date getFechaIngreso() {
        return fechaIngreso;
    }

    public void setFechaIngreso(Date fechaIngreso) {
        this.fechaIngreso = fechaIngreso;
    }

    public double getIngreso() {
        return ingreso;
    }

    public void setIngreso(double ingreso) {
        this.ingreso = ingreso;
    }

    public String getNombreEmpresa() {
        return nombreEmpresa;
    }

    public void setNombreEmpresa(String nombreEmpresa) {
        this.nombreEmpresa = nombreEmpresa.toUpperCase();
    }

    public TipoEmpresa getTipoEmpresa() {
        return tipoEmpresa;
    }

    public void setTipoEmpresa(TipoEmpresa tipoEmpresa) {
        this.tipoEmpresa = tipoEmpresa;
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
        if (!(object instanceof ActividadLaboral)) {
            return false;
        }
        ActividadLaboral other = (ActividadLaboral) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "py.com.ideaspymes.facilerp.pesistencia.base.ActividadLaboral[ id=" + id + " ]";
    }

}
