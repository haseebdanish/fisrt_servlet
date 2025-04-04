package org.cms.model;

import java.util.Objects;

public class Enrollment {
	private String stuid;
	private String courseid;
	public String getStuid() {
		return stuid;
	}
	public void setStuid(String stuid) {
		this.stuid = stuid;
	}
	public String getCourseid() {
		return courseid;
	}
	public void setCourseid(String courseid) {
		this.courseid = courseid;
	}
	@Override
	public int hashCode() {
		return Objects.hash(courseid, stuid);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Enrollment other = (Enrollment) obj;
		return Objects.equals(courseid, other.courseid) && Objects.equals(stuid, other.stuid);
	}
	public Enrollment(String stuid, String courseid) {
		this.stuid = stuid;
		this.courseid = courseid;
	}
	
	public Enrollment() {
		super();
	}
	@Override
	public String toString() {
		return "Enrollment [stuid=" + stuid + ", courseid=" + courseid + "]";
	}
	
}
