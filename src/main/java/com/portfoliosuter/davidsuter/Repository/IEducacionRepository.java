package com.portfoliosuter.davidsuter.Repository;

import com.portfoliosuter.davidsuter.Entity.Educacion;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davey
 */
@Repository
public interface IEducacionRepository  extends JpaRepository<Educacion, Long> {
    
}
