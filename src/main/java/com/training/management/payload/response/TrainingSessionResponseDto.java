package com.training.management.payload.response;

import com.training.management.models.TrainingSession;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.time.LocalDate;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class TrainingSessionResponseDto {

    private Long id;
    private String title;
    private int hours;
    private BigDecimal cost;
    private String objectives;
    private String program;
    private TrainerResponseDto trainerResponseDto;
    private CompanyResponseDto companyRes;
    private LocalDate startDate;
    private LocalDate endDate;

    public static TrainingSessionResponseDto convertToDto(TrainingSession trainingSession) {
        return TrainingSessionResponseDto.builder()
                .id(trainingSession.getId())
                .title(trainingSession.getTitle())
                .hours(trainingSession.getHours())
                .cost(trainingSession.getCost())
                .objectives(trainingSession.getObjectives())
                .program(trainingSession.getProgram())
                .trainerResponseDto(TrainerResponseDto.convertToDto(trainingSession.getTrainer()))
                .companyRes(CompanyResponseDto.fromEntity(trainingSession.getCompany()))
                .startDate(trainingSession.getStartDate())
                .endDate(trainingSession.getEndDate())
                .build();
    }
}
