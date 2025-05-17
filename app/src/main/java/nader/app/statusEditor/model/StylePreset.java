package nader.app.statusEditor.model;

public class StylePreset {
    private final String name;
    private final int typefaceStyle;
    private final int color;
    private final String fontPath;

    public StylePreset(String name, int typefaceStyle, int color, String fontPath) {
        this.name = name;
        this.typefaceStyle = typefaceStyle;
        this.color = color;
        this.fontPath = fontPath;
    }

    public String getName() {
        return name;
    }

    public int getTypefaceStyle() {
        return typefaceStyle;
    }

    public int getColor() {
        return color;
    }

    public String getFontPath() {
        return fontPath;
    }
}