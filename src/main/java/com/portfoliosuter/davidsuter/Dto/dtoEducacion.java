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
public class dtoEducacion {
    @NotBlank
    private String titulo;
    @NotBlank
    private String institucion;
    @NotBlank
    private String nivel;
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String fechaFinalizacion;

    public dtoEducacion() {
    }

    public dtoEducacion(String titulo, String institucion, String nivel, String fechaInicio, String fechaFinalizacion) {
        this.titulo = titulo;
        this.institucion = institucion;
        this.nivel = nivel;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
    }
    
    
}
