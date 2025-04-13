package org.cms.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

import org.cms.datasources.*;
import org.cms.model.Student;

// Datasource
// JDBC calls
// This violates SOLID (Single, open-close, Lyskoiv, Injection)principle

public class StudentRepository {
	//get the datasource object
	//Injecting/wire an object
	private MysqlDBConnection connection;

	public StudentRepository(MysqlDBConnection connection) {
		super();
		this.connection = connection;
	}

	public MysqlDBConnection getConnection() {
		return connection;
	}

	public void setConnection(MysqlDBConnection connection) {
		this.connection = connection;
	}

	public int insertStudent(Student s) {
		int r = 0;
		try {
			String sql = "insert into student values(?,?,?,?)";
			PreparedStatement ps = connection.getConnection().prepareStatement(sql);
			ps.setString(1,s.getSid());
			ps.setString(2,s.getSname());
			ps.setString(3,s.getAddress());
			ps.setInt(4,s.getAdmissionyear());
			r = ps.executeUpdate();
		
		}catch(Exception e){
			System.out.println(e);
		}
		return r;
	}
	
	public int updateStudent(Student s, String id) {
		int r = 0;
		try {
			String sql = "update student set sname=?,address=?, admissionyear=? where sid=?";
			PreparedStatement ps = connection.getConnection().prepareStatement(sql);
			ps.setString(1, s.getSname());
			ps.setString(2, s.getAddress());
			ps.setInt(3, s.getAdmissionyear());
			ps.setString(4, id);
			r = ps.executeUpdate();
		}catch (Exception e) {}
		return r;
	}
	
	public int deleteStudent(String id) {
		int r = 0;
		try {
			String sql = "delete from student where sid=?";
			PreparedStatement ps = connection.getConnection().prepareStatement(sql);
			ps.setString(1, id);
			r = ps.executeUpdate();
		}catch(Exception e) {}
		return r;
	}
	public List<Student> fetchAllStudents(){
		List<Student> list = new ArrayList<Student>();
		Student s;
		try {
			String sql = "select * from student";
			Statement st = connection.getConnection().createStatement();
			ResultSet set = st.executeQuery(sql);
			while(set.next()) {
				String id = set.getString(1);
				String name = set.getString(2);
				String address = set.getString(3);
				int year = set.getInt(4);
				s = new Student(id,name,address,year);
				list.add(s);
			}
			} catch (Exception e){}
		return list;
	}
	public Student fetchOneStudent(String id) {
		Student s=new Student();
		try {
			String sql="select * from student where sid=?";	
			PreparedStatement ps=connection.getConnection().prepareStatement(sql);
			ps.setString(1,id);
			ResultSet r=ps.executeQuery();
			while(r.next()) {
			s.setSid(r.getString(1));
			s.setSname(r.getString(2));
			s.setAddress(r.getString(3));
			s.setAdmissionyear(r.getInt(0));
			}
			System.out.print(s);
		}catch(Exception e) {
			System.out.println(e);
		}
		return s;
	}
}
