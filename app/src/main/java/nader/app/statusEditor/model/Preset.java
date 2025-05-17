package nader.app.statusEditor.model;

public class Preset {
	private String name;
	private String fontPath;
	private int color;
	
	public Preset(String name, String fontPath, int color) {
		this.name = name;
		this.fontPath = fontPath;
		this.color = color;
	}
	
	public String getName() {
		return name;
	}
	
	public String getFontPath() {
		return fontPath;
	}
	
	public int getColor() {
		return color;
	}
}