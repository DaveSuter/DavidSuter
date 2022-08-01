package com.portfoliosuter.davidsuter.Controller;

import com.portfoliosuter.davidsuter.Entity.Persona;
import com.portfoliosuter.davidsuter.Interface.IPersonaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
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
@CrossOrigin
public class PersonaController {
    @Autowired IPersonaService iPersonaService;
    
    @GetMapping("/persona/traer")
    public Persona findPersona(){
        return iPersonaService.findPersona((long)1);
    }
    
    @PostMapping("/persona/crear")
    public String createPersona(@RequestBody Persona persona){
       iPersonaService.savePersona(persona);
       return "La persona se creo correctamente";
    }
    
    @DeleteMapping("/persona/borrar/{id}")
    public String deletePersona(@PathVariable Long id){
        iPersonaService.deletePersona(id);
        return "La persona se borro correctamente";
    }
    
    @PutMapping("/persona/editar/{id}")
    public Persona editPersona(@PathVariable Long id, @RequestParam("name") String newName, 
                                @RequestParam("lastName") String newLastName, 
                                @RequestParam("banner") String newBanner, 
                                @RequestParam("avatar") String newAvatar, 
                                @RequestParam("title") String newTitle, 
                                @RequestParam("province") String newProvince,
                                @RequestParam("country") String newCountry, 
                                @RequestParam("about") String newAbout){
        Persona persona = iPersonaService.findPersona(id);
        
        persona.setName(newName);
        persona.setLastName(newLastName);
        persona.setBanner(newBanner);
        persona.setAvatar(newAvatar);
        persona.setTitle(newTitle);
        
        persona.setProvince(newProvince);
        persona.setCountry(newCountry);
        persona.setAbout(newAbout);
        
        iPersonaService.savePersona(persona);
        return persona;
    }
    
}
