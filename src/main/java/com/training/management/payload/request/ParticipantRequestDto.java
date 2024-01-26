package com.training.management.payload.request;


import com.training.management.models.Participant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.time.LocalDate;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ParticipantRequestDto {

    private String name;
    private String surname;
    private LocalDate dateOfBirth;
    private String city;
    private String email;
    private String phoneNumber;

    public  Participant convertToEntity(ParticipantRequestDto participantRequestDto) {
        return Participant.builder()
                .name(participantRequestDto.getName())
                .surname(participantRequestDto.getSurname())
                .dateOfBirth(participantRequestDto.getDateOfBirth())
                .city(participantRequestDto.getCity())
                .email(participantRequestDto.getEmail())
                .phoneNumber(participantRequestDto.getPhoneNumber())
                .build();
    }
}
