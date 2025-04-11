package org.cms.controllers;

import java.io.IOException;

import org.cms.datasources.MysqlDBConnection;
import org.cms.model.Student;
import org.cms.repository.StudentRepository;

import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class EditStudentController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
	private MysqlDBConnection ds;
	private StudentRepository studentRepo;

    @Override
    public void init() throws ServletException {
    	try {
    	ds=new MysqlDBConnection();
        studentRepo = new StudentRepository(ds);
    	}catch(Exception e) {}
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        String sid = request.getParameter("id");

        Student student = studentRepo.fetchOneStudent(sid); // Get student from DB

        if (student != null) {
            request.setAttribute("student", student);
            request.getRequestDispatcher("edit-student.jsp").forward(request, response);
        } else {
            response.getWriter().println("Student not found");
        }
    }
}
