package com.portfoliosuter.davidsuter.Interface;

import com.portfoliosuter.davidsuter.Entity.Proyecto;
import java.util.List;

/**
 *
 * @author davey
 */
public interface IProyectoService {
    
    public List<Proyecto> getProyecto();
    
    public void saveProyecto(Proyecto proyecto);
    
    public void deleteProyecto(Long id);
    
    public Proyecto findProyecto(Long id);
    
}
