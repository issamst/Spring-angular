package com.training.management.service;


import com.training.management.models.ERole;
import com.training.management.models.Skill;
import com.training.management.models.Trainer;
import com.training.management.models.User;
import com.training.management.payload.request.TrainerRequestDto;
import com.training.management.payload.response.TrainerResponseDto;
import com.training.management.repository.TrainerRepository;
import net.bytebuddy.utility.RandomString;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;
import java.util.Objects;

@Service
public class TrainerService {
    private final TrainerRepository trainerRepository;
    private final UserService userService;
    private final SkillService skillService;

    public TrainerService(TrainerRepository trainerRepository, UserService userService, SkillService skillService) {
        this.trainerRepository = trainerRepository;
        this.userService = userService;
        this.skillService = skillService;
    }


    @Transactional
    public Long createTrainer(TrainerRequestDto requestDto) {

        User user = null;
        if(Objects.nonNull(requestDto.getUserId())){
            user = userService.findById(requestDto.getUserId());
        }

        Trainer trainer = convertToEntity(requestDto, user);
        return trainerRepository.save(trainer).getId();
    }

    private Trainer convertToEntity(TrainerRequestDto requestDto, User user) {
        Trainer trainer = new Trainer();
        trainer.setName(requestDto.getName());
        List<Skill> skillsList = skillService.convertToSkillsList(requestDto.getSkills());
        trainer.setRemarks(requestDto.getRemarks());
        trainer.setEmail(requestDto.getEmail());
        String password = RandomString.make(10);
        if(user == null){
            user = userService.createUser(requestDto.getEmail(),
                    requestDto.getEmail(), password, ERole.ROLE_TRAINER);
        }
        trainer.setSkillsList(skillsList);
        trainer.setUser(user);
        // sent email to user with password
        userService.sentEmailToUser(user.getEmail(), password, user.getEmail());
        return trainer;
    }


    public List<TrainerResponseDto> getTrainers() {
        List<Trainer> trainers = trainerRepository.findAll();
        List<TrainerResponseDto> trainerResponseDtos = convertToDtoList(trainers);
        return trainerResponseDtos;
    }

    private List<TrainerResponseDto> convertToDtoList(List<Trainer> trainers) {
        List<TrainerResponseDto> trainerResponseDtos =  new java.util.ArrayList<>();
        for (Trainer trainer : trainers) {
            TrainerResponseDto trainerResponseDto = convertToDto(trainer);
            trainerResponseDtos.add(trainerResponseDto);
        }
        return trainerResponseDtos;
    }

    private TrainerResponseDto convertToDto(Trainer trainer) {
        TrainerResponseDto trainerResponseDto = new TrainerResponseDto();
        trainerResponseDto.setId(trainer.getId());
        trainerResponseDto.setName(trainer.getName());
        trainerResponseDto.setRemarks(trainer.getRemarks());
        trainerResponseDto.setEmail(trainer.getEmail());
        trainerResponseDto.setUserId(trainer.getUser().getId());
        trainerResponseDto.setSkills(skillService.convertToDtoList(trainer.getSkillsList()));
        return trainerResponseDto;
    }

    public Trainer findById(Long trainerId) {
        return trainerRepository.findById(trainerId).orElseThrow(() -> new RuntimeException("Trainer not found"));
    }
}
