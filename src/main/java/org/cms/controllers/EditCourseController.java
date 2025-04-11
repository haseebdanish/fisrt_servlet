package org.cms.controllers;

import java.io.IOException;

import org.cms.datasources.MysqlDBConnection;
import org.cms.model.Course;
import org.cms.repository.CourseRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MysqlDBConnection ds;
	private CourseRepository courseRepo;

    @Override
    public void init() throws ServletException {
    	try {
    	ds=new MysqlDBConnection();
        courseRepo = new CourseRepository(ds);
    	}catch(Exception e) {}
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String cid = request.getParameter("id");

        Course course = courseRepo.fetchOneCourse(cid); // Get student from DB

        if (course != null) {
            request.setAttribute("course", course);
            request.getRequestDispatcher("edit-course.jsp").forward(request, response);
        } else {
            response.getWriter().println("Course not found");
        }
    }
}
