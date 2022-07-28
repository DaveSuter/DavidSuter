package com.portfoliosuter.davidsuter.Repository;

import com.portfoliosuter.davidsuter.Entity.Persona;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davey
 */
@Repository
public interface IPersonaRepository extends JpaRepository<Persona, Long> {
    
}
