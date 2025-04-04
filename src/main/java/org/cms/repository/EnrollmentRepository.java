package org.cms.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.cms.datasources.MysqlDBConnection;
import org.cms.model.Course;
import org.cms.model.Enrollment;

public class EnrollmentRepository {
	
	private MysqlDBConnection connection;

	public EnrollmentRepository(MysqlDBConnection connection) {
		super();
		this.connection = connection;
	}

	public MysqlDBConnection getConnection() {
		return connection;
	}

	public void setConnection(MysqlDBConnection connection) {
		this.connection = connection;
	}

	public int insertEnrollment(Enrollment en) {
		int r = 0;
		try {
			String sql = "insert into enrollment values(?,?)";
			PreparedStatement ps = connection.getConnection().prepareStatement(sql);
			ps.setString(1,en.getStuid());
			ps.setString(2,en.getCourseid());
			r = ps.executeUpdate();
		
		}catch(Exception e){
			return r;
		}
		return 0;
	}
	
	public int updateEnrollment(Enrollment en, String id,String cid) {
		int r = 0;
		try {
			String sql = "update enrollment set stuid where courseid=?";
			PreparedStatement ps = connection.getConnection().prepareStatement(sql);
			ps.setString(1, en.getStuid());
			ps.setString(2, en.getCourseid());
			r = ps.executeUpdate();
		}catch (Exception e) {}
		return r;
	}
	
	public int deleteEnrollment(String id) {
		int r = 0;
		try {
			String sql = "delete from enrollment where courseid=?";
			PreparedStatement ps = connection.getConnection().prepareStatement(sql);
			ps.setString(1, id);
			r = ps.executeUpdate();
		}catch(Exception e) {}
		return r;
	}
	public List<Enrollment> fetchAllEnrollment(){
		List<Enrollment> list = new ArrayList<Enrollment>();
		Enrollment en;
		try {
			String sql = "select * from enrollment";
			Statement st = connection.getConnection().createStatement();
			ResultSet set = st.executeQuery(sql);
			while(set.next()) {
				String stuid = set.getString(1);
				String courseid = set.getString(2);
				en = new Enrollment(stuid,courseid);
				list.add(en);
			}
			} catch (Exception e){}
		return list;
	}
	public Enrollment fetchOneEnrollment(String id) {
		return null;
	}
}
