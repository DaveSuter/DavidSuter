package com.portfoliosuter.davidsuter.Controller;

import com.portfoliosuter.davidsuter.Entity.Educacion;
import com.portfoliosuter.davidsuter.Interface.IEducacionService;
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
public class EducacionController {
    @Autowired IEducacionService iEducacionService;
    
    @GetMapping("/educacion/traer")
    public Educacion getEducacion(@RequestBody Educacion educacion){
        return iEducacionService.findEducacion((long)1);
    }
    
    @PostMapping("/educacion/crear")
    public String createEducacion(@RequestBody Educacion educacion){
        iEducacionService.saveEducacion(educacion);
        return "La educacion se guardo correctamente";
    }
    
    @DeleteMapping("/educacion/borrar/{id}")
    public String deleteEducacion(@PathVariable Long id){
        iEducacionService.deleteEducacion(id);
        return "La educacion se elimino correctamente";
    }
    
    @PutMapping("/educacion/editar/{id}")
    public Educacion editEducacion(@PathVariable Long id, @RequestParam("titulo") String newTitulo, 
            @RequestParam("institucion") String newInstitucion, 
            @RequestParam("nivel") String newNivel, 
            @RequestParam("fechaInicio") String newFechaInicio, 
            @RequestParam("fechaFinalizacion") String newFechaFinalizacion){
        Educacion educacion = iEducacionService.findEducacion(id);
        
        educacion.setTitulo(newTitulo);
        educacion.setInstitucion(newInstitucion);
        educacion.setNivel(newNivel);
        educacion.setFechaInicio(newFechaInicio);
        educacion.setFechaFinalizacion(newFechaFinalizacion);
        iEducacionService.saveEducacion(educacion);
        return educacion;
    }
}
