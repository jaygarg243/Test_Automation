package com.student.controller;

import java.util.ArrayList;

import com.student.service.StudentService;
import com.student.models.Student;

public class StudentController {
	
	private StudentService studentservice;
	public StudentController() {
		// TODO Auto-generated constructor stub
		this.studentservice = new StudentService();
	}
	public int insert(Student student) {
		return this.studentservice.insert(student);
	}
	public int update(Student student) {
		return this.studentservice.update(student);
	}
	public int delete(int id) {
		return this.studentservice.delete(id);
	}
	public Student get(int id) {
		return this.studentservice.get(id);
	}
	public ArrayList<Student> get() {
		return this.studentservice.get();
	}
}
