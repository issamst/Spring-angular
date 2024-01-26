package com.training.management.controllers;


import com.training.management.payload.request.SkillRequestDto;
import com.training.management.payload.response.CompanyResponseDto;
import com.training.management.payload.response.SkillResponseDto;
import com.training.management.service.SkillService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/api/skill")
public class SkillController {

    private final SkillService skillService;

    public SkillController(SkillService skillService) {
        this.skillService = skillService;
    }

    @PostMapping("")
    public Long createSkill(@RequestBody SkillRequestDto requestDto){
        return skillService.createSkill(requestDto);
    }

    @GetMapping("")
    public ResponseEntity<List<SkillResponseDto>> getSkills(){
        return ResponseEntity.ok(skillService.getSkills());
    }
}
