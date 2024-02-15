package com.classroom.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.classroom.dto.TraineeDTO;
import com.classroom.entity.Classroom;
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
	
	
	public String addTrainee(TraineeDTO traineeDTO) throws ClassroomException {
	
		
		Trainee trainee = new Trainee();
		trainee.setTraineeName(traineeDTO.getTraineeName());
		trainee.setClassroom(null);
		
		traineeRepo.save(trainee);
		
		
		return "Trainee:  "+ trainee.getTraineeName()+ "  has been added.";
	}
	
	
	public String allocateClassroom(String classroomId, Integer traineeId) throws ClassroomException {
		
		Optional<Classroom> optionalC = classroomRepo.findById(classroomId);
		Optional<Trainee> optionalT = traineeRepo.findById(traineeId);
		
		Classroom classroom = optionalC.orElseThrow(()-> new ClassroomException("classroom doesnt exist"));
		Trainee trainee = optionalT.orElseThrow(()-> new ClassroomException("Trainee doesnt exist"));
		
		classroom.setAvailableCapacity(classroom.getAvailableCapacity()-1);
		
		trainee.setClassroom(classroom);
		
		
		return "Trainee "+ trainee.getTraineeName()+" has been added to classroom: "+ classroom.getClassroomId();
	}
	
	
	
	
	
}
