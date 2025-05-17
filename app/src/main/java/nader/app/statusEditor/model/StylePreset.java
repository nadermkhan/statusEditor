package nader.app.statusEditor.model;

public class StylePreset {
    private final String name;
    private final int typefaceStyle;
    private final int color;

    public StylePreset(String name, int typefaceStyle, int color) {
        this.name = name;
        this.typefaceStyle = typefaceStyle;
        this.color = color;
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
}