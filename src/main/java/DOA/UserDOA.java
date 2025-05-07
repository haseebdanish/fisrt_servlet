package DOA;

import org.cms.model.User;
import java.sql.*;

public class UserDOA {

	 public boolean registerUser(User user){
	        boolean isRegistered = false;
	        
	        try {
	        	
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PMS", "root", "D@nish00");
	            String query = "INSERT INTO users (username, password, email, role) VALUES (?, ?, ?, ?)";

	            try (PreparedStatement stmt = conn.prepareStatement(query)) {
	                stmt.setString(1, user.getUsername());
	                stmt.setString(2, user.getPassword());
	                stmt.setString(3, user.getEmail());
	                String role = user.getRole() != null ? user.getRole() : "user";
	                stmt.setString(4, role);

	                int rowsInserted = stmt.executeUpdate();
	                isRegistered = rowsInserted > 0;
	            }
	        } catch (ClassNotFoundException e) {
	            e.printStackTrace();  
	        } catch (SQLException e) {
	            e.printStackTrace();
	        }

	        return isRegistered;
	    }
	 
	 public User authenticateUser(String username, String password) {
		    User user = null;

		    try {
	        	Class.forName("com.mysql.cj.jdbc.Driver");
	            Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/PMS", "root", "D@nish00");
		        String query = "SELECT * FROM users WHERE username = ? AND password = ?";
		        try (PreparedStatement stmt = conn.prepareStatement(query)) {
		            stmt.setString(1, username);
		            stmt.setString(2, password);

		            ResultSet rs = stmt.executeQuery();
		            if (rs.next()) {
		                user = new User();
		                user.setUsername(rs.getString("username"));
		                user.setPassword(rs.getString("password"));
		                user.setEmail(rs.getString("email")); // assuming you have this field
		            }
		        }
		    } catch (ClassNotFoundException e) {
	            e.printStackTrace();  
	        } catch (SQLException e) {
		        e.printStackTrace();
		    }

		    return user;
		}

}
