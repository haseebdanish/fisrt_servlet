package org.cms.model;

import java.util.Objects;

public class Course {
	private String cid;
	private String cname;
	private int c_credits;
	public String getCid() {
		return cid;
	}
	public void setCid(String cid) {
		this.cid = cid;
	}
	public String getCname() {
		return cname;
	}
	public void setCname(String cname) {
		this.cname = cname;
	}
	public int getC_credits() {
		return c_credits;
	}
	public void setC_credits(int c_credits) {
		this.c_credits = c_credits;
	}
	@Override
	public int hashCode() {
		return Objects.hash(c_credits, cid, cname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Course other = (Course) obj;
		return c_credits == other.c_credits && Objects.equals(cid, other.cid) && Objects.equals(cname, other.cname);
	}
	public Course(String cid, String cname, int c_credits) {
		this.cid = cid;
		this.cname = cname;
		this.c_credits = c_credits;
	}
	
	public Course() {
		super();
	}
	@Override
	public String toString() {
		return "Course [cid=" + cid + ", cname=" + cname + ", c_credits=" + c_credits + "]";
	}
	
}
