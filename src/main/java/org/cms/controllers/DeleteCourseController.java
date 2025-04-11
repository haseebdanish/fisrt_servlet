package org.cms.controllers;

import java.io.IOException;

import org.cms.datasources.MysqlDBConnection;
import org.cms.repository.CourseRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class DeleteCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	private MysqlDBConnection ds;
	private CourseRepository studentRepo;

    @Override
    public void init() throws ServletException {
    	try {
    	ds=new MysqlDBConnection();
        studentRepo = new CourseRepository(ds);
    	}catch(Exception e) {}
    }

	    @Override
	    protected void doGet(HttpServletRequest request, HttpServletResponse response)
	        throws ServletException, IOException {

	       String id = request.getParameter("sid");
	        studentRepo.deleteCourse(id);
	        response.sendRedirect("student-list.jsp");
	    }
	}
