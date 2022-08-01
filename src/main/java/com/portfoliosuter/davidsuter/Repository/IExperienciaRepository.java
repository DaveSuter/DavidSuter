package com.portfoliosuter.davidsuter.Repository;

import com.portfoliosuter.davidsuter.Entity.Experiencia;
import java.util.Optional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davey
 */
@Repository
public interface IExperienciaRepository extends JpaRepository<Experiencia, Long> {
    public Optional<Experiencia> findByPuesto(String puesto);
    public boolean existsByPuesto(String puesto);
}
