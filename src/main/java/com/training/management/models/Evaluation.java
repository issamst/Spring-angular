package com.training.management.models;

import lombok.*;

import javax.persistence.*;

@Entity
@Table(name = "evaluations")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
@EqualsAndHashCode
@Builder
public class Evaluation {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private int pedagogicalQuality;
    private int pace;
    private int courseSupport;
    private int practicalExercises;
    private int masteryOfSubject;

    @ManyToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @ManyToOne
    @JoinColumn(name = "trainer_id")
    private Trainer trainer;

    @ManyToOne
    @JoinColumn(name = "session_id")
    private TrainingSession trainingSession;

}
