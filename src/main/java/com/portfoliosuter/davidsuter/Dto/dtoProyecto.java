/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliosuter.davidsuter.Dto;

import javax.validation.constraints.NotBlank;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author davey
 */

@Getter @Setter
public class dtoProyecto {
    @NotBlank
    private String nombre;
    @NotBlank
    private String descripcion;

    public dtoProyecto() {
    }

    public dtoProyecto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    
}
