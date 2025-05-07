package DOA;

import java.util.*;

import org.cms.model.Interview;

import java.sql.*;

public class InterviewDOA {

	public List<Interview> getUserInterviews(String username) {
        List<Interview> interviewList = new ArrayList<>();
        
        // Database connection
        try {
        	
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PMS", "root", "D@nish00");
            String query = "SELECT * FROM";
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Interview interview = new Interview();
                interview.setCompanyName(rs.getString("company_name"));
                interview.setInterviewDate(rs.getString("interview_date"));
                interview.setLocation(rs.getString("location"));
                // Set other fields
                interviewList.add(interview);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();  
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return interviewList;
    }
}
