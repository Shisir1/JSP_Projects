package cookieUtility;


import java.io.*;
import javax.servlet.*;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.*;
import java.net.*;

public class LongLivedCookie extends Cookie {
	  public static final int SECONDS_PER_YEAR = 60*60*24*365;
	  
	  public LongLivedCookie(String name, String value) {
	    super(name, value);
	    setMaxAge(SECONDS_PER_YEAR);
	  }
}