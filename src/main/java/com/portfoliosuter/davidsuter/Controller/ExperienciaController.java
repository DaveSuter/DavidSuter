package com.portfoliosuter.davidsuter.Controller;

import com.portfoliosuter.davidsuter.Entity.Experiencia;
import com.portfoliosuter.davidsuter.Interface.IExperienciaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author davey
 */

@RestController
public class ExperienciaController {
    @Autowired IExperienciaService iExperienciaService;
    
    @GetMapping("/experiencia/traer")
    public Experiencia getExperiencia(){
        return iExperienciaService.findExperiencia((long)1);
    }
    
    @PostMapping("/experiencia/crear")
    public String createExperiencia(@RequestBody Experiencia experiencia){
        iExperienciaService.saveExperiencia(experiencia);
        return "La experiencia se guardo correctamente";
    } 
    
    @DeleteMapping("/experiencia/borrar/{id}")
    public String deleteExperiencia(@PathVariable Long id){
        iExperienciaService.deleteExperiencia(id);
        return "La experiencia se elimino correctamente";
    }
    
    @PutMapping("/experiencia/editar/{id}")
    public Experiencia editExperiencia(@PathVariable Long id, @RequestParam("puesto") String newPuesto, 
            @RequestParam("empresa") String newEmpresa, 
            @RequestParam("fechaInicio") String newFechaInicio, 
            @RequestParam("fechaFinalizacion") String newFechaFinalizacion, 
            @RequestParam("descripcon") String newDescripcion){
        Experiencia experiencia = iExperienciaService.findExperiencia(id);
        
        experiencia.setPuesto(newPuesto);
        experiencia.setEmpresa(newEmpresa);
        experiencia.setFechaInicio(newFechaInicio);
        experiencia.setFechaFinalizacion(newFechaFinalizacion);
        experiencia.setDescripcion(newDescripcion);
        iExperienciaService.saveExperiencia(experiencia);
        return experiencia;
    }
    
}
