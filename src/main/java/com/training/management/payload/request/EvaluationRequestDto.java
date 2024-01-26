package com.training.management.payload.request;


import com.training.management.models.Evaluation;
import com.training.management.models.Participant;
import com.training.management.models.Trainer;
import com.training.management.models.TrainingSession;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class EvaluationRequestDto {

    private int pedagogicalQuality;
    private int pace;
    private int courseSupport;
    private int practicalExercises;
    private int masteryOfSubject;
    private Long participantId;
    private Long trainerId;
    private Long trainingSessionId;

    //convertToEntity
    public Evaluation convertToEntity(EvaluationRequestDto evaluationRequestDto, Participant participant,
                                      Trainer trainer, TrainingSession trainingSession) {
        return Evaluation.builder()
                .pedagogicalQuality(evaluationRequestDto.getPedagogicalQuality())
                .pace(evaluationRequestDto.getPace())
                .courseSupport(evaluationRequestDto.getCourseSupport())
                .practicalExercises(evaluationRequestDto.getPracticalExercises())
                .masteryOfSubject(evaluationRequestDto.getMasteryOfSubject())
                .participant(participant)
                .trainer(trainer)
                .trainingSession(trainingSession)
                .build();
    }
}
