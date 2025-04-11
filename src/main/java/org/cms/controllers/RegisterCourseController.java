package org.cms.controllers;

import java.io.IOException;

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

public class RegisterCourseController extends HttpServlet {
	private static final long serialVersionUID = 1L;
    private ServletConfig config;  
    private ServletContext context;
    
    public RegisterCourseController() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	public void init(ServletConfig config) throws ServletException {
		// TODO Auto-generated method stub
		//Logger
		//Capture information and send to HTTPServlet
		this.config = config;
		this.context = getServletContext();
		super.init(config);
		System.out.println("Servlet Loaded");
	}

	
	public ServletConfig getServletConfig() {
		// Returns the config which is returned in init
		return config;
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html");
		// Create ServletContext object
		String email = context.getInitParameter("admin");
		// Create ServletConfig
		config = getServletConfig();
		String drivername = config.getInitParameter("driver");
		String un = config.getInitParameter("username");
		String pwd = config.getInitParameter("password");
		response.getWriter().print("<h2>"+"Driver: "+drivername+"</h2>");
		response.getWriter().print("<h2>"+"User: "+un+"</h2>");
		response.getWriter().print("<h2>"+"Password: "+pwd+"</h2>");
		response.getWriter().print("<h2>"+"MailTo: "+email+"</h2>");
		
		// Create Session
		HttpSession session = request.getSession();
		
		// Receive from Request
		Course c = new Course();
		c.setCid(request.getParameter("id"));
		c.setCname(request.getParameter("sname"));
		c.setC_credits(Integer.parseInt(
				request.getParameter("credits").toString()));
		// perform database operation
		int r = 0;
		try {
			MysqlDBConnection ds = new MysqlDBConnection();
			CourseRepository repository=new CourseRepository(ds);
			CourseServiceImpl service=new CourseServiceImpl();
			r = service.insertCourse(c);
		} catch(Exception e) {
			System.out.println(e);
		}
		if(r==1)
			response.sendRedirect("success.jsp");
		else
			response.sendRedirect("error.jsp");
		
		
		
	}

}
