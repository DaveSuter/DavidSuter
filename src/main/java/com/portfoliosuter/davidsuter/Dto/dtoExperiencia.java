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
public class dtoExperiencia {
    @NotBlank
    private String puesto;
    @NotBlank
    private String empresa;
    @NotBlank
    private String fechaInicio;
    @NotBlank
    private String fechaFinalizacion;
    @NotBlank
    private String descripcion;

    public dtoExperiencia() {
    }

    public dtoExperiencia(String puesto, String empresa, String fechaInicio, String fechaFinalizacion, String descripcion) {
        this.puesto = puesto;
        this.empresa = empresa;
        this.fechaInicio = fechaInicio;
        this.fechaFinalizacion = fechaFinalizacion;
        this.descripcion = descripcion;
    }
    
    
}
