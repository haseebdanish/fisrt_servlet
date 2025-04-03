package org.cms.services;

import java.util.List;
import org.cms.model.Student;
//@Service - stereotype annotation
//@Component
//Repository
//@Bean

interface StudentService {
	public int insertStudent(Student s);
	public int updateStudent(Student s, String id); // prototype of update
	public int deleteStudent(String s); // prototype of delete
	public List<Student> fetchAll(); // prototype of select
	public Student fetchOneStudent(String s); 
	
}
