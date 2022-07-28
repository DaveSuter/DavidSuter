package com.portfoliosuter.davidsuter.Controller;

import com.portfoliosuter.davidsuter.Entity.Skill;
import com.portfoliosuter.davidsuter.Interface.ISkillService;
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
public class SkillController {
    @Autowired ISkillService iSkillService;
    
    @GetMapping("/skill/traer")
    public Skill getSkill(){
        return iSkillService.findSkill((long)1);
    }
    
    @PostMapping("/skill/crear")
    public String createSkill(@RequestBody Skill skill){
        iSkillService.saveSkill(skill);
        return "El skill se creo correctamente";
    }
    
    @DeleteMapping("/skill/borrar/{id}")
    public String deleteSkill(@PathVariable Long id){
        iSkillService.deleteSkill(id);
        return "El skill ha sido borrado correctamente";
    }
    
    @PutMapping("/skill/editar/{id}")
    public Skill editSkill(@PathVariable Long id, 
            @RequestParam("habilidad") String newHabilidad, 
            @RequestParam("porcentaje") int newPorcentaje){
        Skill skill = iSkillService.findSkill(id);
        
        skill.setHabilidad(newHabilidad);
        skill.setPorcentaje(newPorcentaje);
        iSkillService.saveSkill(skill);
        return skill;
    }
    
}
