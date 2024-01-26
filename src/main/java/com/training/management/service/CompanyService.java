package com.training.management.service;


import com.training.management.models.Company;
import com.training.management.payload.request.CompanyRequestDto;
import com.training.management.payload.response.CompanyResponseDto;
import com.training.management.repository.CompanyRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Slf4j
public class CompanyService {

    private final CompanyRepository companyRepository;

    public CompanyService(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    public Long createCompany(CompanyRequestDto requestDto) {
        checkIfCompanyExists(requestDto);
        return companyRepository.save(requestDto.toEntity()).getId();

    }

    private void checkIfCompanyExists(CompanyRequestDto requestDto) {
        if (companyRepository.findByName(requestDto.getName()).isPresent()) {
            throw new RuntimeException("Company already exists");
        }
    }

    public List<CompanyResponseDto> getCompanies() {
        return companyRepository.findAll()
                .stream()
                .map(CompanyResponseDto::fromEntity)
                .collect(Collectors.toList());
    }

    public Company findById(Long companyId) {
        return companyRepository.findById(companyId).orElseThrow(() -> new RuntimeException("Company not found"));
    }
}
