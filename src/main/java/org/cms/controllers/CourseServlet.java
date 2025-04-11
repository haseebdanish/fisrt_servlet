package org.cms.controllers;

import java.io.IOException;
import java.util.List;

import org.cms.datasources.MysqlDBConnection;
import org.cms.model.Course;
import org.cms.repository.CourseRepository;
import org.cms.services.CourseServiceImpl;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class CourseServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CourseServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see Servlet#getServletConfig()
	 */
	public ServletConfig getServletConfig() {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// Session 
    	HttpSession session = request.getSession();
		try {
    		MysqlDBConnection ds=new MysqlDBConnection();
    		CourseRepository repository=new CourseRepository(ds);
    		CourseServiceImpl service=new CourseServiceImpl();
    		List<Course> fetched=service.fetchAll();
    	    session.setAttribute("xyz", fetched);
    		}catch(Exception e) {
    			System.out.println(e);
    		}
		RequestDispatcher rd = request.getRequestDispatcher("course-list.jsp");
		rd.forward(request, response);
	}

}
