package com.training.management.controllers;


import com.training.management.payload.request.ParticipantRequestDto;
import com.training.management.payload.response.ParticipantResponseDto;
import com.training.management.service.ParticipantService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/participant")
public class ParticipantController {

    private final ParticipantService participantService;

    public ParticipantController(ParticipantService participantService) {
        this.participantService = participantService;
    }

    @PostMapping("")
    public Long createParticipant(@RequestBody ParticipantRequestDto participantRequestDto){
        return participantService.createParticipant(participantRequestDto);
    }

    @GetMapping("")
    public ResponseEntity<List<ParticipantResponseDto>> getAllParticipants(){
        return ResponseEntity.ok(participantService.getAllParticipants());
    }

    @GetMapping("/{id}")
    public ResponseEntity<ParticipantResponseDto> getParticipantById(@PathVariable Long id){
        return ResponseEntity.ok(participantService.getParticipantById(id));
    }
}
