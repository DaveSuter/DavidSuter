package com.portfoliosuter.davidsuter.Service;

import com.portfoliosuter.davidsuter.Entity.Proyecto;
import com.portfoliosuter.davidsuter.Interface.IProyectoService;
import com.portfoliosuter.davidsuter.Repository.IProyectoRepository;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author davey
 */
@Service
public class ImpProyectoService implements IProyectoService {
    @Autowired IProyectoRepository iProyectoRepository;

    @Override
    public List<Proyecto> getProyecto() {
        List<Proyecto> proyecto = iProyectoRepository.findAll();
        return proyecto;
    }

    @Override
    public void saveProyecto(Proyecto proyecto) {
        iProyectoRepository.save(proyecto);
    }

    @Override
    public void deleteProyecto(Long id) {
        iProyectoRepository.deleteById(id);
    }

    @Override
    public Proyecto findProyecto(Long id) {
        Proyecto proyecto = iProyectoRepository.findById(id).orElse(null);
        return proyecto;
    }
    
}
