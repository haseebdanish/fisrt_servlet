package org.cms.services;

import java.util.List;
import org.cms.model.Course;
import org.cms.repository.CourseRepository;
import org.cms.repository.StudentRepository;

public class CourseServiceImpl implements CourseService{
	private CourseRepository repository;
	
	
	public int insertCourse(Course c) {
		return 0;
	}
	public int updateCourse(Course c, String id) {
		return 0;
	}
	public int deleteCourse(String c) {
		return 0;
	}
	public List<Course> fetchAll(){
		return repository.fetchAllCourse();
	}
	public Course fetchOneCourse(String c) {
		return null;
	}

}