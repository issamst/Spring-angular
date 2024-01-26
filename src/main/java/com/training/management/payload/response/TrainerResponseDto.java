package com.training.management.payload.response;

import com.training.management.models.Trainer;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainerResponseDto {

    private Long id;
    private String name;
    private String email;
    private String remarks;
    private Long userId;
    private List<SkillResponseDto> skills;

    public static TrainerResponseDto convertToDto(Trainer trainer) {
        return TrainerResponseDto.builder()
                .id(trainer.getId())
                .name(trainer.getName())
                .email(trainer.getEmail())
                .remarks(trainer.getRemarks())
                .userId(trainer.getUser().getId())
                .skills(SkillResponseDto.convertToDtoList(trainer.getSkillsList()))
                .build();

    }

}