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
public class Proyecto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min= 1, max = 50, message = "debe tener entre 1 y 50 caracteres")
    private String nombre;
    
    @NotNull
    @Size(min= 1, max = 500, message = "debe tener entre 1 y 500 caracteres")
    private String descripcion;

    public Proyecto() {
    }

    public Proyecto(String nombre, String descripcion) {
        this.nombre = nombre;
        this.descripcion = descripcion;
    }
    
    
}
