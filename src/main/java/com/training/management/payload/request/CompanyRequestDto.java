package com.training.management.payload.request;


import com.training.management.models.Company;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class CompanyRequestDto {
    private String name;
    private String address;
    private String phoneNumber;
    private String url;
    private String email;

    public Company toEntity() {
        return Company.builder()
                .name(name)
                .address(address)
                .phoneNumber(phoneNumber)
                .url(url)
                .email(email)
                .build();
    }


}
