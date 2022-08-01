package com.portfoliosuter.davidsuter.Controller;

import com.portfoliosuter.davidsuter.Dto.dtoProyecto;
import com.portfoliosuter.davidsuter.Entity.Proyecto;
import com.portfoliosuter.davidsuter.Security.Controller.Mensaje;
import com.portfoliosuter.davidsuter.Service.ImpProyectoService;
import java.util.List;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author davey
 */

@RestController
@RequestMapping("educacion")
@CrossOrigin
public class ProyectoController {
    @Autowired
    ImpProyectoService impProyectoService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Proyecto>> list(){
        List<Proyecto> list = impProyectoService.getProyecto();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> createPryecto(@RequestBody dtoProyecto dtoproy){
        if(StringUtils.isBlank(dtoproy.getNombre()))
            return new ResponseEntity(new Mensaje("El campo nombre es obligatorio"), HttpStatus.BAD_REQUEST);
        Proyecto proyecto = new Proyecto(dtoproy.getNombre(), dtoproy.getDescripcion());
        impProyectoService.saveProyecto(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto agregado con exito"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoProyecto dtoproy){
        if(!impProyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("El proyecto no existe"), HttpStatus.BAD_REQUEST);
        Proyecto proyecto = impProyectoService.findProyecto(id);
        proyecto.setNombre(dtoproy.getNombre());
        proyecto.setDescripcion(dtoproy.getDescripcion());
        impProyectoService.saveProyecto(proyecto);
        return new ResponseEntity(new Mensaje("Proyecto actualizado con exito"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!impProyectoService.existsById(id))
            return new ResponseEntity(new Mensaje("El proyecto no existe"), HttpStatus.BAD_REQUEST);
        impProyectoService.deleteProyecto(id);
        return new ResponseEntity(new Mensaje("Proyecto eliminado con exito"), HttpStatus.OK);
    }
}
