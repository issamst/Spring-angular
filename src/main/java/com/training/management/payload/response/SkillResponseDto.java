package com.training.management.payload.response;


import com.training.management.models.Skill;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SkillResponseDto {
    private Long id;
    private String name;
    private String description;

    public static List<SkillResponseDto> convertToDtoList(List<Skill> skillsList) {
        return skillsList.stream()
                .map(SkillResponseDto::convertToDto)
                .collect(Collectors.toList());

    }

    public static SkillResponseDto convertToDto(Skill skill) {
        return SkillResponseDto.builder()
                .id(skill.getId())
                .name(skill.getName())
                .description(skill.getDescription())
                .build();
    }
}
