package com.classroom.repository;

import org.springframework.data.repository.CrudRepository;

import com.classroom.entity.Classroom;

public interface ClassroomRepository extends CrudRepository<Classroom, String>{

}
