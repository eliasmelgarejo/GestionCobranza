/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.generico;

import com.ideaspymes.gestioncobranza.configuracion.model.Empresa;
import com.ideaspymes.gestioncobranza.configuracion.model.Sucursal;

/**
 *
 * @author christian.romero
 */
public interface IConSucursal {
    Empresa getEmpresa();
    Sucursal getSucursal();
}
