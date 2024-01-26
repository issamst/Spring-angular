package com.training.management.service;


import com.training.management.models.TrainingSession;
import com.training.management.payload.request.TrainingSessionRequestDto;
import com.training.management.payload.response.TrainingSessionResponseDto;
import com.training.management.repository.TrainingSessionRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Service
public class TrainingSessionService {

    private final TrainingSessionRepository trainingSessionRepository;
    private final CompanyService companyService;
    private final TrainerService trainerService;


    public TrainingSessionService(TrainingSessionRepository trainingSessionRepository, CompanyService companyService, TrainerService trainerService) {
        this.trainingSessionRepository = trainingSessionRepository;
        this.companyService = companyService;
        this.trainerService = trainerService;
    }

    public Long createTrainingSession(TrainingSessionRequestDto requestDto) {
        return trainingSessionRepository.save(requestDto.toEntity(requestDto,
                companyService.findById(requestDto.getCompanyId()),
                trainerService.findById(requestDto.getTrainerId()))).getId();
    }

    public List<TrainingSessionResponseDto> getTrainingSessions() {
        return trainingSessionRepository.findAll()
                .stream()
                .map(TrainingSessionResponseDto::convertToDto)
                .collect(Collectors.toList());
    }

    public TrainingSessionResponseDto getTrainingSessionById(Long id) {
        return TrainingSessionResponseDto.convertToDto(Objects
                .requireNonNull(trainingSessionRepository.findById(id).orElse(null)));
    }

    public TrainingSession findById(Long trainingSessionId) {
        return trainingSessionRepository.findById(trainingSessionId).orElse(null);
    }
}
