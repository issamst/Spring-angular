package com.training.management.controllers;


import com.training.management.payload.request.EvaluationRequestDto;
import com.training.management.payload.response.EvaluationResponseDto;
import com.training.management.service.EvaluationService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/evaluation")
public class EvaluationController {

    private final EvaluationService evaluationService;

    public EvaluationController(EvaluationService evaluationService) {
        this.evaluationService = evaluationService;
    }

    @PostMapping("")
    public ResponseEntity<Long> createEvaluation(@RequestBody EvaluationRequestDto requestDto){
        return ResponseEntity.ok(evaluationService.createEvaluation(requestDto));
    }

    @GetMapping("")
    public ResponseEntity<List<EvaluationResponseDto>> getEvaluations(){
        return ResponseEntity.ok(evaluationService.getEvaluations());
    }
}
