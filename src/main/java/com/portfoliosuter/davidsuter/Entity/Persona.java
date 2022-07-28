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
public class Persona {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    
    @NotNull
    @Size(min= 1, max = 50, message = "debe tener entre 1 y 50 caracteres")
    private String name;
    
    @NotNull
    @Size(min= 1, max = 50, message = "debe tener entre 1 y 50 caracteres")
    private String lastName;
    
    @Size(min= 1, max = 150, message = "debe tener entre 1 y 150 caracteres")
    private String banner;
    
    @Size(min= 1, max = 150, message = "debe tener entre 1 y 150 caracteres")
    private String avatar;
    
    @NotNull
    @Size(min= 1, max = 50, message = "debe tener entre 1 y 50 caracteres")
    private String title;
    
    @NotNull
    @Size(min= 1, max = 50, message = "debe tener entre 1 y 50 caracteres")
    private String province;
    
    @NotNull
    @Size(min= 1, max = 50, message = "debe tener entre 1 y 50 caracteres")
    private String country;
    
    @NotNull
    @Size(min= 1, max = 500, message = "debe tener entre 1 y 500 caracteres")
    private String about;

    
    
    
}
