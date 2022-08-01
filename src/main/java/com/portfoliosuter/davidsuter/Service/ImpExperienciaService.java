package com.portfoliosuter.davidsuter.Service;

import com.portfoliosuter.davidsuter.Entity.Experiencia;
import com.portfoliosuter.davidsuter.Interface.IExperienciaService;
import com.portfoliosuter.davidsuter.Repository.IExperienciaRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author davey
 */
@Service
@Transactional
public class ImpExperienciaService implements IExperienciaService {
    @Autowired 
    IExperienciaRepository iExperienciaRepository;

    @Override
    public List<Experiencia> getExperiencia() {
        List<Experiencia> experiencia = iExperienciaRepository.findAll();
        return experiencia;
    }

    @Override
    public void saveExperiencia(Experiencia experiencia) {
        iExperienciaRepository.save(experiencia);
    }

    @Override
    public void deleteExperiencia(Long id) {
        iExperienciaRepository.deleteById(id);
    }

    @Override
    public Experiencia findExperiencia(Long id) {
        Experiencia experiencia = iExperienciaRepository.findById(id).orElse(null);
        return experiencia;
    }
    
    public boolean existsById(Long id){
        return iExperienciaRepository.existsById(id);
    }
    
    
    
}
