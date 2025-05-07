package DOA;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.cms.model.Application;

public class ApplicationDOA {
	
	public List<Application> getUserApplications(String username) {
        List<Application> applicationList = new ArrayList<>();
        
        // Database connection
        try {
        	Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PMS", "root", "D@nish00");
            String query = "SELECT * FROM applications WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);
            ResultSet rs = stmt.executeQuery();
            
            while (rs.next()) {
                Application application = new Application();
                application.setJobTitle(rs.getString("job_title"));
                application.setStatus(rs.getString("status"));
                application.setCompanyName(rs.getString("company_name"));
                application.setDateApplied(rs.getString("applied_date"));
                application.setUsername(rs.getString("username"));
                // Set other fields
                applicationList.add(application);
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace(); 
        }  catch (SQLException e) {
            e.printStackTrace();
        }
        
        return applicationList;
    }
}
