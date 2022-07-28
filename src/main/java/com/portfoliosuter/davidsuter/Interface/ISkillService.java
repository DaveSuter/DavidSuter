package com.portfoliosuter.davidsuter.Interface;

import com.portfoliosuter.davidsuter.Entity.Skill;
import java.util.List;

/**
 *
 * @author davey
 */
public interface ISkillService {
    
    public List<Skill> getSkill();
    
    public void saveSkill(Skill skill);
    
    public void deleteSkill(Long id);
    
    public Skill findSkill(Long id);
    
}
