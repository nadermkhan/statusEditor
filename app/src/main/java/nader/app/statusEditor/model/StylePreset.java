package nader.app.statusEditor.model;


public class StylePreset {
    private final String fontPath;
    private final int color;

    public StylePreset(String fontPath, int color) {
        this.fontPath = fontPath;
        this.color = color;
    }

    public String getFontPath() {
        return fontPath;
    }

    public int getColor() {
        return color;
    }
}