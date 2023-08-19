package com.student;

import java.util.ArrayList;
import java.util.Scanner;

import com.student.controller.StudentController;
import com.student.dao.StudentDAO;
import com.student.models.Student;

//import com.mysql.cj.xdevapi.Statement;

public class StudentMain {

	public static void main(String[] args){
		// TODO Auto-generated method stub
		//Scanner sc = new Scanner(System.in);
		//int id = Integer.parseInt(sc.nextLine());
		//String name = sc.nextLine();
		//String city = sc.nextLine();
		//Student student = new Student(id,name,city);
		//StudentDAO studentdao = new StudentDAO();
		StudentController controller = new StudentController();
		//int output = controller.insert(student);
		//System.out.println(output);
		//int id = 5;
		ArrayList<Student> retriveStudents = controller.get();
		for(Student studentA: retriveStudents) {
			System.out.println(studentA);
		}

}
}