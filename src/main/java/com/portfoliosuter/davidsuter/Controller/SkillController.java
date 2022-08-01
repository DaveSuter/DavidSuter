package com.portfoliosuter.davidsuter.Controller;

import com.portfoliosuter.davidsuter.Dto.dtoSkill;
import com.portfoliosuter.davidsuter.Entity.Skill;
import com.portfoliosuter.davidsuter.Security.Controller.Mensaje;
import com.portfoliosuter.davidsuter.Service.ImpSkillService;
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
 * @author davey
 */

@RestController
@RequestMapping("skill")
@CrossOrigin
public class SkillController {
    @Autowired
    ImpSkillService impSkillService;
    
    @GetMapping("/list")
    public ResponseEntity<List<Skill>> list(){
        List<Skill> list = impSkillService.getSkill();
        return new ResponseEntity(list, HttpStatus.OK);
    }
    
    @PostMapping("/create")
    public ResponseEntity<?> createSkill(@RequestBody dtoSkill dtoskl){
        if(StringUtils.isBlank(dtoskl.getHabilidad()))
            return new ResponseEntity(new Mensaje("El campo habilidad es obligatorio"), HttpStatus.BAD_REQUEST);
        Skill skill = new Skill(dtoskl.getHabilidad(), dtoskl.getPorcentaje());
        impSkillService.saveSkill(skill);
        return new ResponseEntity(new Mensaje("Educacion agregada con exito"), HttpStatus.OK);
    }
    
    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@PathVariable("id") Long id, @RequestBody dtoSkill dtoskl){
        if(!impSkillService.existsById(id))
            return new ResponseEntity(new Mensaje("La habilidad no existe"), HttpStatus.BAD_REQUEST);
        Skill skill = impSkillService.findSkill(id);
        skill.setHabilidad(dtoskl.getHabilidad());
        skill.setPorcentaje(dtoskl.getPorcentaje());
        impSkillService.saveSkill(skill);
        return new ResponseEntity(new Mensaje("Habilidad actualizada con exito"), HttpStatus.OK);
    }
    
    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") Long id){
        if(!impSkillService.existsById(id))
            return new ResponseEntity(new Mensaje("La habilidad no existe"), HttpStatus.BAD_REQUEST);
        impSkillService.deleteSkill(id);
        return new ResponseEntity(new Mensaje("Habilidad eliminada con exito"), HttpStatus.OK);
    }
}
