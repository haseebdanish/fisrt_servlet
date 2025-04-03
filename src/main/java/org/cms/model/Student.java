package org.cms.model;

import java.io.Serializable;
import java.util.Objects;

public class Student implements Comparable <Student>, Serializable {
	private String sid;
	private String sname;
	private String address;
	private int admissionyear;
	//getter and setter
	public String getSid() {
		return sid;
	}
	public void setSid(String sid) {
		this.sid = sid;
	}
	public String getSname() {
		return sname;
	}
	public void setSname(String sname) {
		this.sname = sname;
	}
	public String getAddress() {
		return address;
	}
	public void setAddress(String address) {
		this.address = address;
	}
	public int getAdmissionyear() {
		return admissionyear;
	}
	public void setAdmissionyear(int admissionyear) {
		this.admissionyear = admissionyear;
	}
	//hashcode and equals
	@Override
	public int hashCode() {
		return Objects.hash(address, admissionyear, sid, sname);
	}
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Student other = (Student) obj;
		return Objects.equals(address, other.address) && admissionyear == other.admissionyear
				&& Objects.equals(sid, other.sid) && Objects.equals(sname, other.sname);
	}
	//Parameterized constructor
	public Student(String sid, String sname, String address, int admissionyear) {
		this.sid = sid;
		this.sname = sname;
		this.address = address;
		this.admissionyear = admissionyear;
	}
	//Default constructor
	public Student() {
		super();
	}
	//toString()
	@Override
	public String toString() {
		return "Student [sid=" + sid + ", sname=" + sname + ", address=" + address + ", admissionyear=" + admissionyear
				+ "]";
	}
	
	public int compareTo(Student s) {
		return sid.compareTo(s.getSid());
	}
	
}
