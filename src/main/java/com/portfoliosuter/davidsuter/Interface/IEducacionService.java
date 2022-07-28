package com.portfoliosuter.davidsuter.Interface;

import com.portfoliosuter.davidsuter.Entity.Educacion;
import java.util.List;

/**
 *
 * @author davey
 */
public interface IEducacionService {
    
    public List<Educacion> getEducacion();
    
    public void saveEducacion(Educacion educacion);
    
    public void deleteEducacion(Long id);
    
    public Educacion findEducacion(Long id);
    
}
