package DOA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.sql.PreparedStatement;
import java.sql.Statement;

import org.cms.model.Job;

public class JobDOA {
	
	public static List<Job> getAvailableJobs() {
		
        List<Job> jobList = new ArrayList<>();
        
        // Database connection
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PMS", "root", "D@nish00");
            String query = "SELECT * FROM job";  // Adjust query as necessary
            Statement stmt = conn.createStatement();
            ResultSet rs = stmt.executeQuery(query);
            
            while (rs.next()) {
                Job job = new Job();
                job.setTitle(rs.getString("title"));
                job.setCompanyName(rs.getString("company_name"));
                job.setJobDescription(rs.getString("description"));
                job.setLocation(rs.getString("location"));
                // Set other fields
                jobList.add(job);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); 
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
        return jobList;
    }
}

