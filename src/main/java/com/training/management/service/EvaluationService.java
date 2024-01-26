package com.training.management.service;


import com.training.management.payload.request.EvaluationRequestDto;
import com.training.management.payload.response.EvaluationResponseDto;
import com.training.management.repository.EvaluationRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EvaluationService {


    private final TrainingSessionService trainingSessionService;
    private final ParticipantService participantService;
    private final EvaluationRepository evaluationRepository;
    private final TrainerService trainerService;

    public EvaluationService(TrainingSessionService trainingSessionService, ParticipantService participantService, EvaluationRepository evaluationRepository, TrainerService trainerService) {
        this.trainingSessionService = trainingSessionService;
        this.participantService = participantService;
        this.evaluationRepository = evaluationRepository;
        this.trainerService = trainerService;
    }

    public Long createEvaluation(EvaluationRequestDto requestDto) {
        return evaluationRepository.save(requestDto.convertToEntity(requestDto,
                participantService.findById(requestDto.getParticipantId()),
                trainerService.findById(requestDto.getTrainerId()),
                trainingSessionService.findById(requestDto.getTrainingSessionId()))).getId();
    }

    public List<EvaluationResponseDto> getEvaluations() {
        return evaluationRepository.findAll().stream().map(EvaluationResponseDto::convertToDto).collect(Collectors.toList());
    }
}
