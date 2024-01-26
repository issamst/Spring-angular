package com.training.management.payload.response;


import com.training.management.models.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyResponseDto {

    private String name;
    private String address;
    private String phoneNumber;
    private String url;
    private String email;


    public static CompanyResponseDto fromEntity(Company company) {
        return CompanyResponseDto.builder()
                .name(company.getName())
                .address(company.getAddress())
                .phoneNumber(company.getPhoneNumber())
                .url(company.getUrl())
                .email(company.getEmail())
                .build();
    }
}
