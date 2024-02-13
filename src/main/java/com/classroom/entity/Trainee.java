package com.classroom.entity;

import com.classroom.dto.ClassroomDTO;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
@Entity
public class Trainee {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer traineeId;
	private String traineeName;
	@ManyToOne(cascade = CascadeType.ALL)
	@JoinColumn(name = "classroomid")
	private Classroom classroom;
	
	
	public Integer getTraineeId() {
		return traineeId;
	}
	public void setTraineeId(Integer traineeId) {
		this.traineeId = traineeId;
	}
	public String getTraineeName() {
		return traineeName;
	}
	public void setTraineeName(String traineeName) {
		this.traineeName = traineeName;
	}
	public Classroom getClassroom() {
		return classroom;
	}
	public void setClassroom(Classroom classroom) {
		this.classroom = classroom;
	}
	
	

}
