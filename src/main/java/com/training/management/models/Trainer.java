package com.training.management.models;

import lombok.*;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name = "trainers")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Builder
public class Trainer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private String name;
    @Column(nullable = false)
    private String email;
    private String remarks;
    @OneToMany(mappedBy = "trainer")
    private List<TrainingSession> trainingSessions;

    @ManyToMany
    @JoinTable(
            name = "trainer_skills",
            joinColumns = @JoinColumn(name = "trainer_id"),
            inverseJoinColumns = @JoinColumn(name = "skills_id")
    )
    private List<Skill> skillsList;

    @OneToOne
    private User user;

}
