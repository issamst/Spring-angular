package com.training.management.service;


import com.training.management.models.ERole;
import com.training.management.models.Participant;
import com.training.management.payload.request.ParticipantRequestDto;
import com.training.management.payload.response.ParticipantResponseDto;
import com.training.management.repository.ParticipantRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import static com.training.management.payload.response.ParticipantResponseDto.convertToDto;

@Service
public class ParticipantService {

    private final ParticipantRepository participantRepository;
    private final UserService userService;

    public ParticipantService(ParticipantRepository participantRepository, UserService userService) {
        this.participantRepository = participantRepository;
        this.userService = userService;
    }


    @Transactional
    public Long createParticipant(ParticipantRequestDto participantRequestDto) {
       Participant participant =  convertToEntity(participantRequestDto);
       return participantRepository.save(participant).getId();
    }

    private Participant convertToEntity(ParticipantRequestDto participantRequestDto) {
        String password = RandomString.make(10);
        return Participant.builder()
                .name(participantRequestDto.getName())
                .surname(participantRequestDto.getSurname())
                .dateOfBirth(participantRequestDto.getDateOfBirth())
                .city(participantRequestDto.getCity())
                .email(participantRequestDto.getEmail())
                .user(userService.createUser(participantRequestDto.getEmail(),
                        participantRequestDto.getEmail(), password, ERole.ROLE_PARTICIPANT))
                .phoneNumber(participantRequestDto.getPhoneNumber())
                .build();
    }

    public List<ParticipantResponseDto> getAllParticipants() {
        List<Participant> participants = participantRepository.findAll();
        return convertToDtoList(participants);
    }

    private List<ParticipantResponseDto> convertToDtoList(List<Participant> participants) {
        if (participants == null) return null;
        List<ParticipantResponseDto> participantResponseDtos = null;
        for (Participant participant : participants) {
            if (participantResponseDtos == null) participantResponseDtos = new ArrayList<>();
            participantResponseDtos.add(convertToDto(participant));
        }
        return participantResponseDtos;
    }

    public ParticipantResponseDto getParticipantById(Long id) {
        Participant participant = participantRepository.findById(id).orElse(null);
        return convertToDto(Objects.requireNonNull(participant));
    }

    public Participant findById(Long participantId) {
        return participantRepository.findById(participantId).orElse(null);
    }
}
