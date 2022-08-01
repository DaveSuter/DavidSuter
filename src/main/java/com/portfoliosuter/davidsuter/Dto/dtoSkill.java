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
public class dtoSkill {
    @NotBlank
    private String habilidad;
    @NotBlank
    private int porcentaje;

    public dtoSkill() {
    }

    public dtoSkill(String habilidad, int porcentaje) {
        this.habilidad = habilidad;
        this.porcentaje = porcentaje;
    }
    
    
}
