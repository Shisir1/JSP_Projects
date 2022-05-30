package colorUtils;



import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.net.*;

public class randomColor {

	public static String getRandomColor() {
		if(Math.random() < 0.5) {
			return("BLUE");
		}else {
			return ("RED");
		}
	}

}
