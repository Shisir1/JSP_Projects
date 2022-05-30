package customTag;

import javax.servlet.jsp.tagext.*;
import javax.servlet.jsp.*;
import java.io.*;

public class ColorTag extends SimpleTagSupport {
  private String foregroundColor = "BLACK";
  private String backgroundColor = "WHITE";

	public void setForegroundColor(String foregroundColor) {
		this.foregroundColor = foregroundColor;
		}
	   
	public void setBackgroundColor(String backgroundColor) {
			this.backgroundColor = backgroundColor;
		}
	
		StringWriter sw = new StringWriter();
	   public void doTag()  throws JspException, IOException {
	      if (!foregroundColor.equals("")) {
	         /* Use message from attribute */
	         JspWriter out = getJspContext().getOut();
	         out.println( "Foreground Color = " + foregroundColor 
	        		 + "\nBackground Color = " + backgroundColor );
	      } else {
	         /* use message from the body */
	         getJspBody().invoke(sw);
	         getJspContext().getOut().println(sw.toString());
	      }
	   }
}