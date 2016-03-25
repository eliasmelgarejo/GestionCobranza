/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.configuracion.model;

import com.ideaspymes.gestioncobranza.configuracion.model.enums.EstadoCivil;
import com.ideaspymes.gestioncobranza.configuracion.model.enums.Sexo;
import com.ideaspymes.gestioncobranza.configuracion.model.enums.TipoContactoTelefonico;
import com.ideaspymes.gestioncobranza.configuracion.model.enums.TipoDireccion;
import com.ideaspymes.gestioncobranza.generico.Listado;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Temporal;



/**
 *
 * @author christian
 */
@Entity
public class Cliente extends Persona {

    @Listado(descripcion = "Nombres" ,mostrar = true)
    private String primerNombre;

    private String segundoNombre;

    @Listado(descripcion = "Apellidos" ,mostrar = true)
    private String primerApellido;

    private String segundoApellido;
    @Enumerated(EnumType.STRING)
    private Sexo sexo;
    @Enumerated(EnumType.STRING)
    private EstadoCivil estadoCivil;

    @Temporal(javax.persistence.TemporalType.DATE)
    private Date fechaNac;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<Direccion> direcciones;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<ReferenciaCliente> referenciaClientes;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<ContactoTelefonico> contactoTelefonicos;
    @OneToMany(mappedBy = "cliente", cascade = CascadeType.ALL)
    private List<ActividadLaboral> actividadesLaborales;

    //datos requeridos para solicitud y analisis
    private BigDecimal lineaDeCredito = new BigDecimal(BigInteger.ZERO);
    @ManyToOne
    private Categoria categoria;

    private String nacionalidad = "PARAGUAYA";

    private boolean esTitular;

    @ManyToOne
    private Cliente conyuge;
    
    @ManyToOne
    private Cartera cartera;

    public Cartera getCartera() {
        return cartera;
    }

    public void setCartera(Cartera cartera) {
        this.cartera = cartera;
    }

    public boolean isEsTitular() {
        return esTitular;
    }

    public void setEsTitular(boolean esTitular) {
        this.esTitular = esTitular;
    }

    public EstadoCivil getEstadoCivil() {
        return estadoCivil;
    }

    public void setEstadoCivil(EstadoCivil estadoCivil) {
        this.estadoCivil = estadoCivil;
    }

    public List<ContactoTelefonico> getContactoTelefonicos() {
        return contactoTelefonicos;
    }

    public void setContactoTelefonicos(List<ContactoTelefonico> contactoTelefonicos) {
        this.contactoTelefonicos = contactoTelefonicos;
    }

    public List<ReferenciaCliente> getReferenciaClientes() {
        return referenciaClientes;
    }

    public void setReferenciaClientes(List<ReferenciaCliente> referenciaClientes) {
        this.referenciaClientes = referenciaClientes;
    }

    public Sexo getSexo() {
        return sexo;
    }

    public void setSexo(Sexo sexo) {
        this.sexo = sexo;
    }

    public List<Direccion> getDirecciones() {
        if (direcciones == null) {
            direcciones = new ArrayList<Direccion>();
        }
        return direcciones;
    }

    public void setDirecciones(List<Direccion> direcciones) {
        this.direcciones = direcciones;
    }

    public List<ActividadLaboral> getActividadesLaborales() {
        return actividadesLaborales;
    }

    public void setActividadesLaborales(List<ActividadLaboral> actividadesLaborales) {
        this.actividadesLaborales = actividadesLaborales;
    }

    public String getPrimerApellido() {
        return primerApellido;
    }

    public void setPrimerApellido(String primerApellido) {
        this.primerApellido = primerApellido.toUpperCase();
    }

    public String getPrimerNombre() {
        return primerNombre;
    }

    public void setPrimerNombre(String primerNombre) {
        this.primerNombre = primerNombre.toUpperCase();
    }

    public String getSegundoApellido() {
        return segundoApellido;
    }

    public void setSegundoApellido(String segundoApellido) {
        this.segundoApellido = segundoApellido.toUpperCase();
    }

    public String getSegundoNombre() {
        return segundoNombre;
    }

    public void setSegundoNombre(String segundoNombre) {
        this.segundoNombre = segundoNombre.toUpperCase();
    }

    public Date getFechaNac() {
        return fechaNac;
    }

    public void setFechaNac(Date fechaNac) {
        this.fechaNac = fechaNac;
    }

    //modifica para que corra por debajo
    public BigDecimal getLineaDeCredito() {
        return lineaDeCredito;
    }

    public void setLineaDeCredito(BigDecimal lineaDeCredito) {
        this.lineaDeCredito = lineaDeCredito;
    }

    //modificar para que corra por debajo
    public Categoria getCategoria() {
        return categoria;
    }

    public void setCategoria(Categoria categoria) {
        this.categoria = categoria;
    }

    public String getNacionalidad() {
        return nacionalidad;
    }

    public void setNacionalidad(String nacionalidad) {
        this.nacionalidad = nacionalidad.toUpperCase();
    }

    public String devuelveTelefonoParticular() {

        for (ContactoTelefonico c : contactoTelefonicos) {
            if (c.getTipo().LINEA_BAJA == TipoContactoTelefonico.LINEA_BAJA) {
                return c.getNumero();
            }
        }
        return null;
    }

    public String devuelveTelefonoLaboral() {

        for (ContactoTelefonico c : contactoTelefonicos) {
            if (c.getTipo().TRABAJO == TipoContactoTelefonico.TRABAJO) {
                return c.getNumero();
            }
        }
        return null;
    }

    public String devuelveDireccionParticular() {

        for (Direccion d : direcciones) {
            if (d.getTipo().PARTICULAR == TipoDireccion.PARTICULAR) {
                return d.getDireccion() + " " + d.getNrocasa();
            }
        }
        return null;
    }

    public String devuelveDireccionLaboral() {

        for (Direccion d : direcciones) {
            if (d.getTipo().LABORAL == TipoDireccion.LABORAL) {
                return d.getDireccion() + " " + d.getNrocasa();
            }
        }
        return null;
    }

    public String devuelveCiudadParticular() {

        for (Direccion d : direcciones) {
            if (d.getTipo().PARTICULAR == TipoDireccion.PARTICULAR) {
                return d.getCiudad() + " - " + d.getPais();
            }
        }
        return null;
    }

    public String devuelveCiudadLaboral() {

        for (Direccion d : direcciones) {
            if (d.getTipo().LABORAL == TipoDireccion.LABORAL) {
                return d.getCiudad() + " - " + d.getPais();
            }
        }
        return null;
    }

    public String devuelveBarrioParticular() {

        for (Direccion d : direcciones) {
            if (d.getTipo().PARTICULAR == TipoDireccion.PARTICULAR) {
                return d.getBarrio();
            }
        }
        return null;
    }

    public String devuelveBarrioLaboral() {

        for (Direccion d : direcciones) {
            if (d.getTipo().LABORAL == TipoDireccion.LABORAL) {
                return d.getBarrio();
            }
        }
        return null;
    }

    public Cliente getConyuge() {
        return conyuge;
    }

    public void setConyuge(Cliente conyuge) {
        this.conyuge = conyuge;
    }

    public String devuelveNombreCompleto() {

        return getPrimerNombre() + " " + getSegundoNombre() + " " + getPrimerApellido() + " " + getSegundoApellido();
    }

    @Override
    public String toString() {
        return getPrimerNombre() + " " + getSegundoNombre() + " " + getPrimerApellido() + " " + getSegundoApellido();
    }
}
