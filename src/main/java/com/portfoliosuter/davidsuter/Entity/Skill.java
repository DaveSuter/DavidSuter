package com.portfoliosuter.davidsuter.Entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import lombok.Getter;
import lombok.Setter;

/**
 *
 * @author davey
 */

@Getter @Setter
@Entity
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min= 1, max = 50, message = "debe tener entre 1 y 50 caracteres")
    private String habilidad;
    
    @NotNull
    @Size(min= 1, max = 3, message = "debe tener entre 1 y 3 caracteres")
    private int porcentaje;
    
}
