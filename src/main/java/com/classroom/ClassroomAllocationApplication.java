package com.classroom;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.classroom.dto.TraineeDTO;
import com.classroom.service.ClassroomAllocationService;

@SpringBootApplication
public class ClassroomAllocationApplication implements CommandLineRunner {
	 
	
	public static final Log LOGGER = LogFactory.getLog(ClassroomAllocationApplication.class);
	
	@Autowired
	ClassroomAllocationService classroomAllocationService;
	

	public static void main(String[] args) {
		SpringApplication.run(ClassroomAllocationApplication.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
	//	getTrainee();
	//	addTrainee();
	//	allocateTrainee();
		deleteTrainee();
	}
	
	public void getTrainee() {
		try {
			Integer traineeId = 800002;
			TraineeDTO traineeDTO = classroomAllocationService.getTrainee(traineeId);
			LOGGER.info(traineeDTO);
		} catch (Exception e) {
			String message ="Some exception occured. Please check log file for more details!!";
			LOGGER.info( message);
		}
	}
	
	public void addTrainee() {
		try {
			TraineeDTO traineeDTO = new TraineeDTO();
			traineeDTO.setTraineeName("Abdi");
			
			String message= classroomAllocationService.addTrainee(traineeDTO);
			
			LOGGER.info(message);
		}catch(Exception e) {
			LOGGER.error(e.getMessage() + "  <----Exception occurred !!!");
		}
	}
	
	
	public void allocateTrainee() {
		
		try {
			
			Integer traineeId = 800009;
			String classroomId = "SL-6";			
			String message = classroomAllocationService.allocateClassroom(classroomId, traineeId);
			
			LOGGER.info(message);
			
		}catch(Exception e) {
			LOGGER.error(e.getMessage() + "  <----Exception occurred !!!");
		}
		
	}
	
	public void deleteTrainee() {
		try {
			Integer traineeId = 800005;
			String message = classroomAllocationService.deleteTrainee(traineeId);
			LOGGER.info(message);
		}catch(Exception e) {
			LOGGER.error(e.getMessage() + "  <----Exception occurred !!!");
		}
	}
	

}
