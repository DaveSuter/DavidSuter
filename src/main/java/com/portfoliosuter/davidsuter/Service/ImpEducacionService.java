package com.portfoliosuter.davidsuter.Service;

import com.portfoliosuter.davidsuter.Entity.Educacion;
import com.portfoliosuter.davidsuter.Interface.IEducacionService;
import com.portfoliosuter.davidsuter.Repository.IEducacionRepository;
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
public class ImpEducacionService implements IEducacionService {
    @Autowired 
    IEducacionRepository iEducacionRepository;

    @Override
    public List<Educacion> getEducacion() {
        List<Educacion> educacion = iEducacionRepository.findAll();
        return educacion;
    }

    @Override
    public void saveEducacion(Educacion educacion) {
        iEducacionRepository.save(educacion);
    }

    @Override
    public void deleteEducacion(Long id) {
        iEducacionRepository.deleteById(id);
    }

    @Override
    public Educacion findEducacion(Long id) {
        Educacion educacion = iEducacionRepository.findById(id).orElse(null);
        return educacion;
    }
    
    public boolean existsById(Long id){
        return iEducacionRepository.existsById(id);
    }
}
