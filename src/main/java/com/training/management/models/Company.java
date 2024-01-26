package com.training.management.models;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "companies")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Builder
public class Company {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String address;
    private String phoneNumber;
    private String url;
    private String email;

    @OneToMany(mappedBy = "company")
    private List<TrainingSession> trainingSessions;


}
