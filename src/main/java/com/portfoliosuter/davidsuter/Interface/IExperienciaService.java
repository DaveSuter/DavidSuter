package com.portfoliosuter.davidsuter.Interface;

import com.portfoliosuter.davidsuter.Entity.Experiencia;
import java.util.List;

/**
 *
 * @author davey
 */
public interface IExperienciaService {
    
    public List<Experiencia> getExperiencia();
    
    public void saveExperiencia(Experiencia experiencia);
    
    public void deleteExperiencia(Long id);
    
    public Experiencia findExperiencia(Long id);
    
}
