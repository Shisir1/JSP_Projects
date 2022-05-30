package Project12;

import java.util.*;
import java.util.Map.Entry;

//this is the bean class
public class Courses {
	
	private Map<String, List<String>> courseList;
	

	public ArrayList<List<String>> getCourseList() {
		
		ArrayList<List<String>> finalCourseList = new ArrayList<List<String>>();
		
		courseList.forEach((k, v) ->{
			
			ArrayList<String> courseToArray = new ArrayList<String>();
			
			courseToArray.add(k);
			courseToArray.addAll(v);
			
			
			finalCourseList.add(courseToArray);
			System.out.println(finalCourseList.getClass().getName());
		});
		
		System.out.println(finalCourseList);
		
		return finalCourseList;
	}
	
	
	//This is called in the business logic layer which connects to the db and runs the query
	//the result of the query, an array of course strings is passed into this function to set the courses into array courseList 
	public void setCourseList(Map<String, List<String>> clist) {
		
		this.courseList = clist;
		
		System.out.println("courses bean class " + courseList);
		
		System.out.println(courseList.getClass().getName());
	}
}
