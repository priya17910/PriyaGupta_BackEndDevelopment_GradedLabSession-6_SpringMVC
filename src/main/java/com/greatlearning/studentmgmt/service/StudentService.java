package com.greatlearning.studentmgmt.service;

import java.util.List;

import com.greatlearning.studentmgmt.entity.Student;

// SERVICE LAYER INTERFACE
public interface StudentService {
	List<Student> getAll();

	void create(Student student);

	void update(Student student);

	void deleteById(int studId);

	Student getById(int studId);
}
