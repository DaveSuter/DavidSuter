package com.portfoliosuter.davidsuter.Repository;

import com.portfoliosuter.davidsuter.Entity.Skill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 *
 * @author davey
 */
@Repository
public interface ISkillRepository  extends JpaRepository<Skill, Long> {
    
}
