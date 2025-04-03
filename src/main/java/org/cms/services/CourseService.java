package org.cms.services;

import java.util.List;
import org.cms.model.Course;

interface CourseService {
	public int insertCourse(Course s); // prototype of insert
	public int updateCourse(Course s, String id); // prototype of update
	public int deleteCourse(String id); // prototype of delete
	public List<Course> fetchAll(); // prototype of select
	public Course fetchOneCourse(String id); 
}
