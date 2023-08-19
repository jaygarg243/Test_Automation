package com.student.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;

import com.student.helper.Helper;
import com.student.models.Student;

public class StudentDAO {

	public int insert(Student student) {
		int output = -1;
		String sql = "insert into students values (?,?,?)";
		PreparedStatement perparedStatement =  Helper.getPreparedStatement(sql);
		try {
		perparedStatement.setInt(1, student.getId());
		perparedStatement.setString(2, student.getName());
		perparedStatement.setString(3, student.getCity());
		output = perparedStatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			Helper.closeConnection();
		}
		return output;
		
	}
	public int update(Student student) {
		int output = -1;
		String sql = "update students set firstname=?, city=? where id=?";
		PreparedStatement perparedStatement =  Helper.getPreparedStatement(sql);
		try {
		perparedStatement.setString(1, student.getName());
		perparedStatement.setString(2, student.getCity());
		perparedStatement.setInt(3, student.getId());
		output = perparedStatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			Helper.closeConnection();
		}
		return output;
		
	}
	public int delete(int id) {
		int output = -1;
		String sql = "delete from students where id=?";
		PreparedStatement perparedStatement =  Helper.getPreparedStatement(sql);
		try {
		perparedStatement.setInt(1, id);
		output = perparedStatement.executeUpdate();
		}
		catch(SQLException e) {
			e.printStackTrace();
		}
		finally {
			Helper.closeConnection();
		}
		return output;
		
	}
	public Student getStudent(int id) {
		ArrayList<Student> students = new ArrayList<Student>();
		
		String sql = "Select * from students where id = ?";
		try {
			PreparedStatement preparedStatement = Helper.getPreparedStatement(sql);
			preparedStatement.setInt(1, id);
			ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				int sId = resultset.getInt(1);
				String sName = resultset.getString(2);
				String sCity = resultset.getString(3);
				Student tempStudent = new Student(sId,sName,sCity);
				students.add(tempStudent);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			
		}
		
		return students!=null && students.size() > 0 ? students.get(0) : null;
	}
	public ArrayList<Student> getStudent() {
		ArrayList<Student> students = new ArrayList<Student>();
		
		String sql = "Select * from students";
		try {
			PreparedStatement preparedStatement = Helper.getPreparedStatement(sql);
			//preparedStatement.setInt(1, id);
			ResultSet resultset = preparedStatement.executeQuery();
			while(resultset.next()) {
				int sId = resultset.getInt(1);
				String sName = resultset.getString(2);
				String sCity = resultset.getString(3);
				Student tempStudent = new Student(sId,sName,sCity);
				students.add(tempStudent);
			}
		}catch(SQLException e){
			e.printStackTrace();
		}
		finally {
			
		}
		
		return students;
	}
}
