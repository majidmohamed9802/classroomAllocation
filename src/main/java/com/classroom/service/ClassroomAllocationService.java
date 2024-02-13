package com.classroom.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classroom.dto.TraineeDTO;
import com.classroom.entity.Trainee;
import com.classroom.exception.ClassroomException;
import com.classroom.repository.ClassroomRepository;
import com.classroom.repository.TraineeRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class ClassroomAllocationService {

	@Autowired
	ClassroomRepository classroomRepo;
	
	@Autowired
	TraineeRepository traineeRepo;
	
	
	
	public TraineeDTO getTrainee(Integer traineeId) throws ClassroomException {
		
		Optional<Trainee> optional = traineeRepo.findById(traineeId);		
		Trainee trainee = optional.orElseThrow(()-> new ClassroomException("trainee doesnt exist"));
		
		TraineeDTO traineeDTO = new TraineeDTO();
		traineeDTO.setClassroom(null);
		traineeDTO.setTraineeId(trainee.getTraineeId());
		traineeDTO.setTraineeName(trainee.getTraineeName());
		
		
		
		return traineeDTO;
	}
	
}