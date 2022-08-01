/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.portfoliosuter.davidsuter.Security.Service;

import com.portfoliosuter.davidsuter.Security.Entity.Usuario;
import com.portfoliosuter.davidsuter.Security.Repository.iUsuarioRepository;
import java.util.Optional;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author davey
 */

@Service
@Transactional
public class UsuarioService {
    @Autowired
    iUsuarioRepository iusuarioRepository;
    
    public Optional<Usuario> getByUserName(String userName){
        return iusuarioRepository.findByUserName(userName);
    }
    
    public boolean existsByUserName(String userName){
        return iusuarioRepository.existsByUserName(userName);
    }
    public boolean existByMail(String mail){
        return iusuarioRepository.existByEmail(mail);
    }
    
    public void save(Usuario usuario){
        iusuarioRepository.save(usuario);
    }
}
