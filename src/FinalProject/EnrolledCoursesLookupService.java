package FinalProject;

import java.util.ArrayList;

import finalProjectBean.EnrollBean;


public interface EnrolledCoursesLookupService {
	
	public ArrayList<EnrollBean> retrieveStudentCourses(String ssn);

}
