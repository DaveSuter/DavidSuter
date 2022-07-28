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
public class Educacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min= 1, max = 50, message = "debe tener entre 1 y 50 caracteres")
    private String titulo;
    
    @NotNull
    @Size(min= 1, max = 50, message = "debe tener entre 1 y 50 caracteres")
    private String institucion;
    
    @NotNull
    @Size(min= 1, max = 50, message = "debe tener entre 1 y 50 caracteres")
    private String nivel;
    
    @NotNull
    @Size(min= 1, max = 10, message = "debe tener entre 1 y 10 caracteres")
    private String fechaInicio;
    
    @NotNull
    @Size(min= 1, max = 10, message = "debe tener entre 1 y 10 caracteres")
    private String fechaFinalizacion; 

}
