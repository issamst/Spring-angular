package com.training.management.payload.response;


import com.fasterxml.jackson.annotation.JsonInclude;
import com.training.management.models.Evaluation;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
@JsonInclude(JsonInclude.Include.NON_NULL)
public class EvaluationResponseDto {

    private Long id;
    private int pedagogicalQuality;
    private int pace;
    private int courseSupport;
    private int practicalExercises;
    private int masteryOfSubject;
    private Long participantId;
    private Long trainerId;
    private Long trainingSessionId;

    // convertToDto
    public static EvaluationResponseDto convertToDto(Evaluation evaluation) {
        return EvaluationResponseDto.builder()
                .id(evaluation.getId())
                .pedagogicalQuality(evaluation.getPedagogicalQuality())
                .pace(evaluation.getPace())
                .courseSupport(evaluation.getCourseSupport())
                .practicalExercises(evaluation.getPracticalExercises())
                .masteryOfSubject(evaluation.getMasteryOfSubject())
                .participantId(evaluation.getParticipant().getId())
                .trainerId(evaluation.getTrainer().getId())
                .trainingSessionId(evaluation.getTrainingSession().getId())
                .build();
    }
}
