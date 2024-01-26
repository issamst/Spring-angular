package com.training.management.models;


import lombok.*;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "skills")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
public class Skill {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, unique = true)
    private String name;
    private String description;

    @ManyToMany(mappedBy = "skillsList")
    private List<Trainer> trainers;
}