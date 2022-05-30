package Project12;

//Get the data that you got from the use, in this case ID and password to connect to the database
//This should return the bean
public interface CourseLookUpService {
	public Courses retrieveCourseList(String userID, String password);
}
