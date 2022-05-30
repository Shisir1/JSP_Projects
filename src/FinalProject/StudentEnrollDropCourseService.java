package FinalProject;


import java.util.ArrayList;

import finalProjectBean.ClassesBean;

public interface StudentEnrollDropCourseService {
	
	public ArrayList<ClassesBean> allClassesAvailable();
	
	public int dropClassQuery(String courseID, String ssn);
	
	public int addClassQuery(String courseID, String grade, String ssn);
}
