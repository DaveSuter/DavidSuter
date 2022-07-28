package com.portfoliosuter.davidsuter.Interface;

import com.portfoliosuter.davidsuter.Entity.Persona;
import java.util.List;


/**
 *
 * @author davey
 */

public interface IPersonaService {
    
    public List<Persona> getPersona();
    
    public void savePersona(Persona persona);
    
    public void deletePersona(Long id);
    
    public Persona findPersona(Long id);
}
