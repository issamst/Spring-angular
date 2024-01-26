package com.training.management.payload.request;


import com.training.management.models.Company;
import com.training.management.models.Trainer;
import com.training.management.models.TrainingSession;
import com.training.management.service.CompanyService;
import com.training.management.service.TrainerService;
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
public class TrainingSessionRequestDto {

    private String title;
    private int hours;
    private BigDecimal cost;
    private String objectives;
    private String program;
    private Long trainerId;
    private Long companyId;
    private LocalDate startDate;
    private LocalDate endDate;

    public TrainingSession toEntity(TrainingSessionRequestDto requestDto, Company company, Trainer trainer) {
        return TrainingSession.builder()
                .title(requestDto.getTitle())
                .hours(requestDto.getHours())
                .cost(requestDto.getCost())
                .objectives(requestDto.getObjectives())
                .program(requestDto.getProgram())
                .trainer(trainer)
                .company(company)
                .startDate(requestDto.getStartDate())
                .endDate(requestDto.getEndDate())
                .build();
    }
}
