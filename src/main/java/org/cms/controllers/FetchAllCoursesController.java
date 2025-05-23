package org.cms.controllers;

import java.io.IOException;
import java.util.List;

import org.cms.datasources.MysqlDBConnection;
import org.cms.model.Course;
import org.cms.repository.CourseRepository;
import org.cms.services.CourseServiceImpl;

import jakarta.servlet.ServletConfig;
import jakarta.servlet.ServletContext;
import jakarta.servlet.ServletException;
import jakarta.servlet.http.HttpServlet;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import jakarta.servlet.http.HttpSession;

public class FetchAllCoursesController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private ServletContext context;
	private ServletConfig config;
	
	public FetchAllCoursesController() {
        super();
    }
	
	public void init(ServletConfig config) {
		this.config = config;
		this.context = getServletContext();
		System.out.println("Servlet Loaded");
	}
	
	
	public ServletConfig getServletConfig() {
		return config;
	}
	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException,IOException{
		// config object for receiving details of the user for authentication and authorization
		
		//context represents app
		
		//Session
		HttpSession session = request.getSession();
		
		//Request and response
		response.getWriter().println("<h2>"+request.getRequestURI()+"</h2>");
		
		// Getting All students from DB
		try {
			MysqlDBConnection ds = new MysqlDBConnection();
			CourseRepository repository=new CourseRepository(ds);
			CourseServiceImpl service=new CourseServiceImpl();
			List<Course> fetched = service.fetchAll();
			session.setAttribute("xyz", fetched);
		} catch(Exception e) {
			System.out.println(e);
		}
		
		//jsp for projecting fetched students
		request.getRequestDispatcher("show.jsp").forward(request, response);
	}
}

