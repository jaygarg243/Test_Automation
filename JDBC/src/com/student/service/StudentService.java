package com.student.service;
import java.util.ArrayList;
import java.util.Collections;

import com.student.dao.StudentDAO;
import com.student.helper.StudentNameComparator;
import com.student.models.Student;
public class StudentService {
	private StudentDAO studentdao;
	public StudentService() {
		// TODO Auto-generated constructor stub
		this.studentdao = new StudentDAO();
	}
	public int insert(Student student) {
		if (student.getCity().equalsIgnoreCase("AHD")||
			student.getCity().equalsIgnoreCase("MUM")||
			student.getCity().equalsIgnoreCase("DEL"))
		{
			return this.studentdao.insert(student);
		}
		return -1;
	}
	public int update(Student student) {
		return this.studentdao.update(student);
	}
	public int delete(int id) {
		return this.studentdao.delete(id);
	}
	public Student get(int id) {
		return this.studentdao.getStudent(id);
	}
	public ArrayList<Student> get() {
		ArrayList<Student> students = this.studentdao.getStudent();;
		Collections.sort(students,new StudentNameComparator());
		return students;
	}
}
