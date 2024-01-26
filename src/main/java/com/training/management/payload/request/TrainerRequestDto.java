package com.training.management.payload.request;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.Column;
import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class TrainerRequestDto {

    private String name;
    private String email;
    private String remarks;
    private Long userId;
    private List<String> skills;



}
