package com.greatlearning.studentmgmt.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.greatlearning.studentmgmt.entity.Student;
import com.greatlearning.studentmgmt.service.StudentService;

@Controller
@RequestMapping("/students")
public class StudentController {
	/*
	 * /students/list - GET /students/showFormForAdd - GET
	 * /students/showFormForUpdate - POST /students/delete - POST /students/save -
	 * POST
	 */

	@Autowired
	StudentService studentService;

	// CONTROLLER CODE TO GET THE LIST OF STUDENTS
	@GetMapping("/list")
	public String getAllStudents(Model model) {
		List<Student> students = studentService.getAll();
		model.addAttribute("students", students);
		return "student/list-of-students";
	}

	// CONTROLLER CODE TO SHOW THE FORM FOR CREATING NEW STUDENT
	@GetMapping("/showStudentFormForAdd")
	public String addStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		model.addAttribute("add", true);
		return "student/student-form";
	}

	// CONTROLLER CODE TO SAVE THE CREATED OR UPDATED STUDENT
	@GetMapping("/showStudentFormForEdit/{id}")
	public String showStudentForEdit(Model model, @PathVariable int id) {
		Student student = studentService.getById(id);
		model.addAttribute("student", student);
		model.addAttribute("edit", true);
		return "student/student-form";
	}

	// CONTROLLER CODE TO DELETE STUDENT
	@GetMapping("/delete/{id}")
	public String delete(Model model, @PathVariable int id) {
		studentService.deleteById(id);
		return "redirect:/students/list?del";
	}

	// CONTROLLER CODE TO SHOW THE FORM FOR UPDATING THE STUDENT
	@PostMapping("/saveStudent")
	public String saveStudent(Model model, @ModelAttribute("student") Student student) {
		if (student.getId() == 0) {
			studentService.create(student);
		} else {
			studentService.update(student);
		}
		return "redirect:/students/list?ed";
	}

	// CONTROLLER CODE FOR ACCESS DENIED PAGE
	@GetMapping("/403")
	public String access(Model model) {
		return "student/403";
	}

	// CONTROLLER CODE FOR LOGOUT PAGE
	@GetMapping("/logout")
	public String logout() {
		return "redirect:/login";
	}
}
