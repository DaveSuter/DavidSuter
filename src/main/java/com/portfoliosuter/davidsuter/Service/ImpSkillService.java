package com.portfoliosuter.davidsuter.Service;

import com.portfoliosuter.davidsuter.Entity.Skill;
import com.portfoliosuter.davidsuter.Interface.ISkillService;
import com.portfoliosuter.davidsuter.Repository.ISkillRepository;
import java.util.List;
import javax.transaction.Transactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;



/**
 *
 * @author davey
 */
@Service
@Transactional
public class ImpSkillService implements ISkillService {
    @Autowired ISkillRepository iSkillRepository;

    @Override
    public List<Skill> getSkill() {
        List<Skill> skill = iSkillRepository.findAll();
        return skill;
    }

    @Override
    public void saveSkill(Skill skill) {
        iSkillRepository.save(skill);
    }

    @Override
    public void deleteSkill(Long id) {
        iSkillRepository.deleteById(id);
    }

    @Override
    public Skill findSkill(Long id) {
        Skill skill = iSkillRepository.findById(id).orElse(null);
        return skill;
    }
    
    public boolean existsById(Long id){
        return iSkillRepository.existsById(id);
    }
}
