package finalProjectBean;

import java.util.*;

//This is the bean class to show student's enrolled classes
public class EnrollBean {
	final private String courseID, title, grade;
	
	
	public EnrollBean(String courseID, String title, String grade)
	{
		this.courseID = courseID;
		this.title = title;
		this.grade = grade;
	}
	
	public String getCourseID() {
		return courseID;
	}

	public String getTitle() {
		return title;
	}

	public String getGrade() {
		return grade;
	}

	
}