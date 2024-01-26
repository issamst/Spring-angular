package com.training.management.payload.request;


import com.training.management.models.Participant;
import com.training.management.models.TrainingRegistration;
import com.training.management.models.TrainingSession;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.time.LocalDateTime;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainingRegistrationRequestDto {

    private LocalDate registrationDate;
    private Long participantId;
    private Long trainingSessionId;

    public  TrainingRegistration convertToEntity(TrainingRegistrationRequestDto requestDto, TrainingSession trainingSession, Participant participant) {
        return TrainingRegistration.builder()
                .registrationDate(requestDto.getRegistrationDate())
                .trainingSession(trainingSession)
                .participant(participant)
                .build();
    }




}
