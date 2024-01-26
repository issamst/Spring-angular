package com.training.management.payload.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.training.management.models.Participant;
import com.training.management.models.TrainingRegistration;
import com.training.management.models.TrainingSession;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TrainingRegistrationResponseDto {


    private Long id;
    private LocalDate registrationDate;
    private ParticipantResponseDto participant;
    private TrainingSessionResponseDto trainingSession;

    //convertToDto
    public static TrainingRegistrationResponseDto convertToDto(TrainingRegistration trainingRegistration) {
        return TrainingRegistrationResponseDto.builder()
                .id(trainingRegistration.getId())
                .registrationDate(trainingRegistration.getRegistrationDate())
            //    .participant(ParticipantResponseDto.convertToDto(trainingRegistration.getParticipant()))
                .trainingSession(TrainingSessionResponseDto.convertToDto(trainingRegistration.getTrainingSession()))
                .build();
    }
}
