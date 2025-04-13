package org.cms.repository;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import org.cms.datasources.MysqlDBConnection;
import org.cms.model.Course;

public class CourseRepository {
	
	private MysqlDBConnection connection;

	public CourseRepository(MysqlDBConnection connection) {
		super();
		this.connection = connection;
	}

	public MysqlDBConnection getConnection() {
		return connection;
	}

	public void setConnection(MysqlDBConnection connection) {
		this.connection = connection;
	}

	public int insertCourse(Course c) {
		int r = 0;
		try {
			String sql = "insert into course values(?,?,?)";
			PreparedStatement ps = connection.getConnection().prepareStatement(sql);
			ps.setString(1,c.getCid());
			ps.setString(2,c.getCname());
			ps.setInt(3,c.getC_credits());
			r = ps.executeUpdate();
		
		}catch(Exception e){
			System.out.println(e);
		}
		return r;
	}
	
	public int updateCourse(Course c, String id) {
		int r = 0;
		try {
			String sql = "update course set c_credits, cname=? where cid=?";
			PreparedStatement ps = connection.getConnection().prepareStatement(sql);
			ps.setInt(1, c.getC_credits());
			ps.setString(2, c.getCname());
			ps.setString(3, c.getCid());
			r = ps.executeUpdate();
		}catch (Exception e) {}
		return r;
	}
	
	public int deleteCourse(String id) {
		int r = 0;
		try {
			String sql = "delete from course where cid=?";
			PreparedStatement ps = connection.getConnection().prepareStatement(sql);
			ps.setString(1, id);
			r = ps.executeUpdate();
		}catch(Exception e) {}
		return r;
	}
	public List<Course> fetchAllCourse(){
		List<Course> list = new ArrayList<Course>();
		Course c;
		try {
			String sql = "select * from course";
			Statement st = connection.getConnection().createStatement();
			ResultSet set = st.executeQuery(sql);
			while(set.next()) {
				String cid = set.getString(1);
				String cname = set.getString(2);
				int c_credits = set.getInt(3);
				c = new Course(cid,cname,c_credits);
				list.add(c);
			}
			} catch (Exception e){}
		return list;
	}
	public Course fetchOneCourse(String c) {
		return null;
	}
}
