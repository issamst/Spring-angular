package com.training.management.service;


import com.training.management.payload.request.TrainingRegistrationRequestDto;
import com.training.management.payload.response.TrainingRegistrationResponseDto;
import com.training.management.repository.TrainingRegistrationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class TrainingRegistrationService {

    private final TrainingRegistrationRepository trainingRegistrationRepository;
    private final ParticipantService participantService;
    private final TrainingSessionService trainingSessionService;

    public TrainingRegistrationService(TrainingRegistrationRepository trainingRegistrationRepository, ParticipantService participantService, TrainingSessionService trainingSessionService) {
        this.trainingRegistrationRepository = trainingRegistrationRepository;
        this.participantService = participantService;
        this.trainingSessionService = trainingSessionService;
    }


    public Long createTrainingRegistration(TrainingRegistrationRequestDto requestDto) {
        return trainingRegistrationRepository.save(requestDto.convertToEntity(requestDto,
                trainingSessionService.findById(requestDto.getTrainingSessionId()),
                participantService.findById(requestDto.getParticipantId()))).getId();
    }

    public List<TrainingRegistrationResponseDto> getTrainingRegistrations() {
        return trainingRegistrationRepository.findAll().
                stream().
                map(TrainingRegistrationResponseDto::convertToDto).
                collect(Collectors.toList());
    }
}
