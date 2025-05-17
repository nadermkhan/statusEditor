package nader.app.statusEditor.model;


import androidx.annotation.ColorInt;

public class TextStyle {
	private String fontPath;
	private @ColorInt int color;
	
	public TextStyle(String fontPath, int color) {
		this.fontPath = fontPath;
		this.color = color;
	}
	
	public String getFontPath() {
		return fontPath;
	}
	
	public void setFontPath(String fontPath) {
		this.fontPath = fontPath;
	}
	
	public int getColor() {
		return color;
	}
	
	public void setColor(int color) {
		this.color = color;
	}
}