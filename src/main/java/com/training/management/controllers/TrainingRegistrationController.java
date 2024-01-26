package com.training.management.controllers;


import com.training.management.payload.request.TrainingRegistrationRequestDto;
import com.training.management.payload.response.TrainingRegistrationResponseDto;
import com.training.management.service.TrainingRegistrationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/training-register")
public class TrainingRegistrationController {

    private final TrainingRegistrationService trainingRegistrationService;

    public TrainingRegistrationController(TrainingRegistrationService trainingRegistrationService) {
        this.trainingRegistrationService = trainingRegistrationService;
    }

    @PostMapping("")
    public ResponseEntity<Long> trainingRegistration(@RequestBody TrainingRegistrationRequestDto requestDto) {
        return ResponseEntity.ok(trainingRegistrationService.createTrainingRegistration(requestDto));
    }

    @GetMapping("")
    public ResponseEntity<List<TrainingRegistrationResponseDto>> getTrainingRegistrations() {
        return ResponseEntity.ok(trainingRegistrationService.getTrainingRegistrations());
    }
}
