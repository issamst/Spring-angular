package com.training.management.controllers;


import com.training.management.payload.request.TrainerRequestDto;
import com.training.management.payload.response.TrainerResponseDto;
import com.training.management.service.TrainerService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/trainer")
public class TrainerController {

    private final TrainerService trainerService;

    public TrainerController(TrainerService trainerService) {
        this.trainerService = trainerService;
    }

    @PostMapping("")
    public ResponseEntity<Long> createTrainer(@RequestBody TrainerRequestDto requestDto){
        return ResponseEntity.ok(trainerService.createTrainer(requestDto));
    }

    @GetMapping("")
    public ResponseEntity<List<TrainerResponseDto>> getTrainers(){
        return ResponseEntity.ok(trainerService.getTrainers());
    }


}
