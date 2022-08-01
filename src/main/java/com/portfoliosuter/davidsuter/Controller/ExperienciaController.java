package com.portfoliosuter.davidsuter.Controller;

import com.portfoliosuter.davidsuter.Security.Controller.Mensaje;
import com.portfoliosuter.davidsuter.Dto.dtoExperiencia;
import com.portfoliosuter.davidsuter.Entity.Experiencia;
import com.portfoliosuter.davidsuter.Service.ImpExperienciaService;
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
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 *
 * @author davey
 */

@RestController
@RequestMapping("experiencia")
@CrossOrigin
public class ExperienciaController {
    @Autowired
    ImpExperienciaService impExperienciaService;
    
    @GetMapping("/lista")
    public ResponseEntity<List<Experiencia>> list(){
        List<Experiencia> list = impExperienciaService.getExperiencia();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody dtoExperiencia dtoexp){
        if(StringUtils.isBlank(dtoexp.getPuesto()))
            return new ResponseEntity(new Mensaje("El campo de puesto es obligatorio"), HttpStatus.BAD_REQUEST);
        Experiencia experiencia = new Experiencia(dtoexp.getPuesto(), dtoexp.getEmpresa(),
                dtoexp.getFechaInicio(), dtoexp.getFechaFinalizacion(), dtoexp.getDescripcion());
        impExperienciaService.saveExperiencia(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia agregada con exito"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoExperiencia dtoexp){
        if(!impExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("La experiencia no existe"), HttpStatus.BAD_REQUEST);
        Experiencia experiencia = impExperienciaService.findExperiencia(id); //.get()
        experiencia.setPuesto(dtoexp.getPuesto());
        experiencia.setEmpresa(dtoexp.getEmpresa());
        experiencia.setFechaInicio(dtoexp.getFechaInicio());
        experiencia.setFechaFinalizacion(dtoexp.getFechaFinalizacion());
        experiencia.setDescripcion(dtoexp.getDescripcion());
        impExperienciaService.saveExperiencia(experiencia);
        return new ResponseEntity(new Mensaje("Experiencia actualizada con exito"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!impExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("La experiencia no existe"), HttpStatus.BAD_REQUEST);
        impExperienciaService.deleteExperiencia(id);
        return new ResponseEntity(new Mensaje("Experiencia eliminada con exito"), HttpStatus.OK);
    }
    
            
            
    @GetMapping("/detail/{id}")
    public ResponseEntity<Experiencia> getById(@PathVariable("id") Long id){
        if(!impExperienciaService.existsById(id))
            return new ResponseEntity(new Mensaje("no existe"), HttpStatus.NOT_FOUND);
        Experiencia experiencia = impExperienciaService.findExperiencia(id);//.get()
        return new ResponseEntity(experiencia, HttpStatus.OK);
    }
    /*
    @Autowired 
    IExperienciaService iExperienciaService;
    
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
    }*/
    
}
