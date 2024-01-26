package com.training.management.controllers;


import com.training.management.payload.request.TrainingSessionRequestDto;
import com.training.management.payload.response.TrainingSessionResponseDto;
import com.training.management.service.CompanyService;
import com.training.management.service.TrainerService;
import com.training.management.service.TrainingSessionService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/training-session")
public class TrainingSessionController {

    private final TrainingSessionService trainingSessionService;
    public TrainingSessionController(TrainingSessionService trainingSessionService) {
        this.trainingSessionService = trainingSessionService;
    }
    @PostMapping("")
    public ResponseEntity<Long> createTrainingSession(@RequestBody TrainingSessionRequestDto requestDto){
        return ResponseEntity.ok(trainingSessionService.createTrainingSession(requestDto));
    }

    @GetMapping("")
    public ResponseEntity<List<TrainingSessionResponseDto>> getTrainingSessions(){

        return ResponseEntity.ok(trainingSessionService.getTrainingSessions());
    }

    @GetMapping("/{id}")
    public ResponseEntity<TrainingSessionResponseDto> getTrainingSessionById(@PathVariable Long id){
        return ResponseEntity.ok(trainingSessionService.getTrainingSessionById(id));
    }
}
