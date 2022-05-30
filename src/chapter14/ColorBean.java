package chapter14;

import java.io.*;

public class ColorBean implements Serializable{
	private String foregroundColor = "YELLOW";
	private String backgroundColor = "White";

	public String getForegroundColor() {
		return(foregroundColor);
	}
	
	public void setForegroundColor(String fgColor) {
		if(!isEmpty(fgColor)) {
			foregroundColor = fgColor;
		}
	}
	
	public String getBackgroundColor() {
		return (backgroundColor);
	}
	
	private boolean isEmpty(String value) {
		return ((value == null) || (value.trim().equals("")));
	}

}
