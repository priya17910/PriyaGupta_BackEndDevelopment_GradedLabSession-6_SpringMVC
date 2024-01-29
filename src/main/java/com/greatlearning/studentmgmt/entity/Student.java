package com.greatlearning.studentmgmt.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Data;

@Entity
@Table(name = "students")
@Data
public class Student {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "id")
	int id;
	@Column(name = "firstname")
	String firstname;
	@Column(name = "lastname")
	String lastname;
	@Column(name = "course")
	String course;
	@Column(name = "country")
	String country;
}
