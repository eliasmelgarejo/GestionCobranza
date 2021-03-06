/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.generico;

import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 *
 * @author Christian
 */
public class FiltroGenerico {

    private String campo;
    private String descripcion;
    private String tipo;
    private String valorString;
    private Integer valorInteger;
    private Double valorDouble;
    private BigDecimal valorBigDecimal;
    private Long valorLong;
    private Date valorDateInicio;
    private Date valorDateFin;

    public FiltroGenerico(String descripcion, String campo, String tipo) {
        this.descripcion = descripcion;
        this.campo = campo;
        this.tipo = tipo;
    }

    public String getCampo() {
        return campo;
    }

    public void setCampo(String campo) {
        this.campo = campo;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getValorString() {
        return valorString;
    }

    public void setValorString(String valorString) {
        this.valorString = valorString;
    }

    public Integer getValorInteger() {
        return valorInteger;
    }

    public void setValorInteger(Integer valorInteger) {
        this.valorInteger = valorInteger;
    }

    public Double getValorDouble() {
        return valorDouble;
    }

    public void setValorDouble(Double valorDouble) {
        this.valorDouble = valorDouble;
    }

    public BigDecimal getValorBigDecimal() {
        return valorBigDecimal;
    }

    public void setValorBigDecimal(BigDecimal valorBigDecimal) {
        this.valorBigDecimal = valorBigDecimal;
    }

    public Long getValorLong() {
        return valorLong;
    }

    public void setValorLong(Long valorLong) {
        this.valorLong = valorLong;
    }

    public Date getValorDateInicio() {
        return valorDateInicio;
    }

    public void setValorDateInicio(Date valorDateInicio) {
        this.valorDateInicio = valorDateInicio;
    }

    public Date getValorDateFin() {
        return valorDateFin;
    }

    public void setValorDateFin(Date valorDateFin) {
        this.valorDateFin = valorDateFin;
    }

    public String getCadenaFiltro() {
        String R = "";
        switch (tipo) {
            case "java.lang.String":
                R = " AND upper(" + campo + ") like '%" + (valorString != null ? valorString.toUpperCase() : "") + "%' ";
                break;
            case "java.util.Date":
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
                R = " AND " + campo + " between '" + sdf.format(valorDateInicio) + "' AND '" + sdf.format(valorDateFin) + "' ";
                break;
            case "java.lang.Integer":
                R = " AND " + campo + " = " + valorInteger + " ";
                break;
            case "java.lang.Long":
                R = " AND " + campo + " = " + valorLong + " ";
                break;
            case "java.lang.Double":
                R = " AND " + campo + " = " + valorDouble + " ";
                break;
            case "java.math.BigDecimal":
                R = " AND " + campo + " = " + valorBigDecimal + " ";
                break;

        }
        return R;
    }

    public boolean tieneValor() {
        boolean R = false;
        if (valorString != null) {
            R = true;
        }

        if (valorInteger != null) {
            R = true;
        }

        if (valorDouble != null) {
            R = true;
        }

        if (valorLong != null) {
            R = true;
        }

        if (valorBigDecimal != null) {
            R = true;
        }

        if (valorDateInicio != null) {
            R = true;
        }

        if (valorDateFin != null) {
            R = true;
        }
        return R;
    }

}
