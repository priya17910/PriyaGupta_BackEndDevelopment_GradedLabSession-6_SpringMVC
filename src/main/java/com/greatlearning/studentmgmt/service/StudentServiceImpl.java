package com.greatlearning.studentmgmt.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.greatlearning.studentmgmt.entity.Student;
import com.greatlearning.studentmgmt.repository.StudentRepository;

@Service
public class StudentServiceImpl implements StudentService {
	@Autowired
	StudentRepository repository;

	// SERVICE CODE TO FIND ALL THE LIST OF STUDENTS
	@Override
	public List<Student> getAll() {
		return repository.findAll();
	}

	// SERVICE CODE TO CREATE THE STUDENT
	@Override
	public void create(Student student) {
		repository.save(student);
	}

	// SERVICE CODE TO UPDATE THE STUDENT
	@Override
	public void update(Student student) {
		repository.save(student);
	}

	// SERVICE CODE TO DELETE THE STUDENT BY ID
	@Override
	public void deleteById(int studId) {
		repository.deleteById(studId);
	}

	// SERVICE CODE TO FIND THE STUDENT BY ID
	@Override
	public Student getById(int studId) {
		return repository.findById(studId).orElse(null);
	}

}
