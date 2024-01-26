package com.training.management.payload.response;


import com.training.management.models.Participant;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;
import java.util.List;
import java.util.stream.Collectors;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ParticipantResponseDto {

        private Long id;
        private String name;
        private String surname;
        private LocalDate dateOfBirth;
        private String city;
        private String email;
        private String phoneNumber;

        public static List<ParticipantResponseDto> convertToDtoList(List<Participant> participantsList) {
            return participantsList.stream()
                    .map(ParticipantResponseDto::convertToDto)
                    .collect(Collectors.toList());

        }
        public static ParticipantResponseDto convertToDto(Participant participant) {
            return ParticipantResponseDto.builder()
                    .id(participant.getId())
                    .name(participant.getName())
                    .surname(participant.getSurname())
                    .dateOfBirth(participant.getDateOfBirth())
                    .city(participant.getCity())
                    .email(participant.getEmail())
                    .phoneNumber(participant.getPhoneNumber())
                    .build();
        }

}
