package org.cms.services;

import java.util.List;
import org.cms.model.Enrollment;


interface EnrollmentService {
	public int insertEnrollment(Enrollment s); // prototype of insert
	public int updateEnrollment(Enrollment s, String id, String cid); // prototype of update
	public int deleteEnrollment(String id); // prototype of delete
	public List<Enrollment> fetchAll(); // prototype of select
	public Enrollment fetchOneEnrollment(String id); 
}
