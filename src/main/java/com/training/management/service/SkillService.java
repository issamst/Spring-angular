package com.training.management.service;


import com.training.management.models.Skill;
import com.training.management.payload.request.SkillRequestDto;
import com.training.management.payload.response.SkillResponseDto;
import com.training.management.repository.SkillRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class SkillService {

    private final SkillRepository skillsRepository;

    public SkillService(SkillRepository skillsRepository) {
        this.skillsRepository = skillsRepository;
    }


    public List<Skill> convertToSkillsList(List<String> skillNames) {
        List<Skill> skillsList = new ArrayList<>();
        if (skillNames != null) {
            for (String skillName : skillNames) {
                Skill skill = skillsRepository.findByName(skillName)
                        .orElseGet(() -> {
                            Skill newSkill = new Skill();
                            newSkill.setName(skillName);
                            return skillsRepository.save(newSkill);
                        });
                skillsList.add(skill);
            }
        }
        return skillsList;
    }


    public Long createSkill(SkillRequestDto requestDto) {
        Skill skill = convertToEntity(requestDto);
        skillsRepository.save(skill);
        return skill.getId();
    }

    private Skill convertToEntity(SkillRequestDto requestDto) {
        Skill skill = new Skill();
        skill.setName(requestDto.getName());
        return skillsRepository.save(skill);
    }

    public List<SkillResponseDto> getSkills() {
        List<Skill> skills = skillsRepository.findAll();
        List<SkillResponseDto> skillResponseDtos = new ArrayList<>();
        for (Skill skill : skills) {
            SkillResponseDto skillResponseDto = convertToDto(skill);
            skillResponseDtos.add(skillResponseDto);
        }
        return skillResponseDtos;
    }

    private SkillResponseDto convertToDto(Skill skill) {
        SkillResponseDto skillResponseDto = new SkillResponseDto();
        skillResponseDto.setId(skill.getId());
        skillResponseDto.setName(skill.getName());
        return skillResponseDto;
    }

    public List<SkillResponseDto> convertToDtoList(List<Skill> skillsList) {
        List<SkillResponseDto> skillResponseDtos = new ArrayList<>();
        for (Skill skill : skillsList) {
            SkillResponseDto skillResponseDto = convertToDto(skill);
            skillResponseDtos.add(skillResponseDto);
        }
        return skillResponseDtos;
    }
}
