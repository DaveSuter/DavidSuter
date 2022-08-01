package com.portfoliosuter.davidsuter.Controller;

import com.portfoliosuter.davidsuter.Dto.dtoEducacion;
import com.portfoliosuter.davidsuter.Entity.Educacion;
import com.portfoliosuter.davidsuter.Security.Controller.Mensaje;
import com.portfoliosuter.davidsuter.Service.ImpEducacionService;
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
public class EducacionController {
    @Autowired
    ImpEducacionService impEducacionService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Educacion>> list(){
        List<Educacion> list = impEducacionService.getEducacion();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> createEducacion(@RequestBody dtoEducacion dtoedu){
        if(StringUtils.isBlank(dtoedu.getTitulo()))
            return new ResponseEntity(new Mensaje("El campo titulo es obligatorio"), HttpStatus.BAD_REQUEST);
        Educacion educacion = new Educacion(dtoedu.getTitulo(), dtoedu.getInstitucion(), 
                dtoedu.getNivel(), dtoedu.getFechaInicio(), dtoedu.getFechaFinalizacion());
        impEducacionService.saveEducacion(educacion);
        return new ResponseEntity(new Mensaje("Educacion agregada con exito"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoEducacion dtoedu){
        if(!impEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("La educacion no existe"), HttpStatus.BAD_REQUEST);
        Educacion educacion = impEducacionService.findEducacion(id);
        educacion.setTitulo(dtoedu.getTitulo());
        educacion.setInstitucion(dtoedu.getInstitucion());
        educacion.setNivel(dtoedu.getNivel());
        educacion.setFechaInicio(dtoedu.getFechaInicio());
        educacion.setFechaFinalizacion(dtoedu.getFechaFinalizacion());
        impEducacionService.saveEducacion(educacion);
        return new ResponseEntity(new Mensaje("Educacion actualizada con exito"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!impEducacionService.existsById(id))
            return new ResponseEntity(new Mensaje("La educacion no existe"), HttpStatus.BAD_REQUEST);
        impEducacionService.deleteEducacion(id);
        return new ResponseEntity(new Mensaje("Educacion eliminada con exito"), HttpStatus.OK);
    }
}
