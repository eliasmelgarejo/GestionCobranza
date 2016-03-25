/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.web.converters;

import com.ideaspymes.gestioncobranza.configuracion.model.Empresa;
import com.ideaspymes.gestioncobranza.generico.ConverterGenerico;
import javax.faces.convert.FacesConverter;


/**
 *
 * @author christian
 */
@FacesConverter(forClass = Empresa.class)
public class EmpresaConverter extends ConverterGenerico<Empresa> {

    @Override
    public String getBeanName() {
        return "empresaBean";
    }
}
