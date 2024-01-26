package com.training.management.controllers;


import com.training.management.payload.request.CompanyRequestDto;
import com.training.management.payload.response.CompanyResponseDto;
import com.training.management.service.CompanyService;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;


@Controller
@RequestMapping("/api/company")
public class CompanyController {

    private final CompanyService companyService;

    public CompanyController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping("")
    public ResponseEntity<Long> createCompany(@RequestBody CompanyRequestDto requestDto){
        return ResponseEntity.ok(companyService.createCompany(requestDto));
    }

    @GetMapping("")
    public ResponseEntity<List<CompanyResponseDto>> getCompanies(){
        return ResponseEntity.ok(companyService.getCompanies());
    }
}
