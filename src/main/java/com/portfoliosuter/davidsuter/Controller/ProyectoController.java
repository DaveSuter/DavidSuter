package com.portfoliosuter.davidsuter.Controller;

import com.portfoliosuter.davidsuter.Entity.Proyecto;
import com.portfoliosuter.davidsuter.Interface.IProyectoService;
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
public class ProyectoController {
    @Autowired IProyectoService iProyectoService;
    
    @GetMapping("/proyecto/traer")
    public Proyecto getProyecto(){
        return iProyectoService.findProyecto((long)1);
    }
    
    @PostMapping("/proyecyo/crear")
    public String createPryecto(@RequestBody Proyecto proyecto){
        iProyectoService.saveProyecto(proyecto);
        return "El proyecto se creo con exito";
    }
    
    @DeleteMapping("/proyecto/borrar/{id}")
    public String deleteProyecto(@PathVariable Long id){
        iProyectoService.deleteProyecto(id);
        return "El proyecto ha sido eliminado";
    }
    
    @PutMapping("/proyecto/editar/{id}")
    public Proyecto editProyecto(@PathVariable Long id, 
            @RequestParam("nombre") String newNombre, 
            @RequestParam("descripcion") String newDescripcion){
        Proyecto proyecto = iProyectoService.findProyecto(id);
        
        proyecto.setNombre(newNombre);
        proyecto.setDescripcion(newDescripcion);
        iProyectoService.saveProyecto(proyecto);
        return proyecto;
    }
    
}
