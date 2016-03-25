/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.ideaspymes.gestioncobranza.generico;

import com.ideaspymes.gestioncobranza.configuracion.model.Usuario;
import com.ideaspymes.gestioncobranza.configuracion.model.enums.Estado;
import java.util.Date;

/**
 *
 * @author christian.romero
 */
public interface IAuditable {

    Long getId();

    Date getFechaRegitro();
    void setFechaRegitro(Date fecha);

    Date getFechaUltimaModificacion();
    void setFechaUltimaModificacion(Date fecha);

    Usuario getUsuarioUltimaModificacion();
    void setUsuarioUltimaModificacion(Usuario u);
    
    Estado getEstado();
    void setEstado(Estado estado);
}
