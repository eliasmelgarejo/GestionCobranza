/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.configuracion.model;

import com.ideaspymes.gestioncobranza.configuracion.model.enums.Estado;
import com.ideaspymes.gestioncobranza.configuracion.model.enums.EstadoDeuda;
import com.ideaspymes.gestioncobranza.generico.IAuditable;
import java.io.Serializable;
import java.util.Date;
import java.util.List;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;

/**
 *
 * @author Elias
 */
@Entity
public class Deuda implements Serializable, IAuditable {
    
    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String origenDeuda;
    private Double totalCapital;
    private Double totalMoratorio;
    private Double totalPunitorio;
    private Double totalDeuda;
    @Enumerated(EnumType.STRING)
    private EstadoDeuda estadoDeuda;
    @OneToMany(mappedBy = "deuda")
    private List<Cuota> cuotas;
    
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

    public String getOrigenDeuda() {
        return origenDeuda;
    }

    public void setOrigenDeuda(String origenDeuda) {
        this.origenDeuda = origenDeuda;
    }

    public Double getTotalCapital() {
        return totalCapital;
    }

    public void setTotalCapital(Double totalCapital) {
        this.totalCapital = totalCapital;
    }

    public Double getTotalMoratorio() {
        return totalMoratorio;
    }

    public void setTotalMoratorio(Double totalMoratorio) {
        this.totalMoratorio = totalMoratorio;
    }

    public Double getTotalPunitorio() {
        return totalPunitorio;
    }

    public void setTotalPunitorio(Double totalPunitorio) {
        this.totalPunitorio = totalPunitorio;
    }

    public Double getTotalDeuda() {
        return totalDeuda;
    }

    public void setTotalDeuda(Double totalDeuda) {
        this.totalDeuda = totalDeuda;
    }

    public EstadoDeuda getEstadoDeuda() {
        return estadoDeuda;
    }

    public void setEstadoDeuda(EstadoDeuda estadoDeuda) {
        this.estadoDeuda = estadoDeuda;
    }

    public List<Cuota> getCuotas() {
        return cuotas;
    }

    public void setCuotas(List<Cuota> cuotas) {
        this.cuotas = cuotas;
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
        if (!(object instanceof Deuda)) {
            return false;
        }
        Deuda other = (Deuda) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "com.ideaspymes.gestioncobranza.configuracion.model.Deuda[ id=" + id + " ]";
    }
    
}
