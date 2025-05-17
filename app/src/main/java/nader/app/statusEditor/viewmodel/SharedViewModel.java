package nader.app.statusEditor.viewmodel;

import android.app.Application;
import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import java.util.ArrayList;
import java.util.List;

import nader.app.statusEditor.model.StylePreset;

public class SharedViewModel extends ViewModel {

    private final MutableLiveData<Uri> imageUri = new MutableLiveData<>();
    private final MutableLiveData<String> text = new MutableLiveData<>("Your Text Here");
    private final MutableLiveData<Integer> textColor = new MutableLiveData<>(Color.BLACK);
    private final MutableLiveData<String> fontPath = new MutableLiveData<>(null);

    private final List<StylePreset> stylePresets = new ArrayList<>();

    public SharedViewModel() {
        // Initialize with sample style presets
        stylePresets.add(new StylePreset("Classic", Typeface.NORMAL, Color.BLACK, "fonts/classic.ttf"));
        stylePresets.add(new StylePreset("Bold Blue", Typeface.BOLD, Color.BLUE, "fonts/bold.ttf"));
        stylePresets.add(new StylePreset("Italic Red", Typeface.ITALIC, Color.RED, "fonts/italic.ttf"));
        stylePresets.add(new StylePreset("Green BoldItalic", Typeface.BOLD_ITALIC, Color.GREEN, "fonts/bolditalic.ttf"));
    }

    public LiveData<Uri> getImageUri() {
        return imageUri;
    }

    public void setImageUri(Uri uri) {
        imageUri.setValue(uri);
    }

    public LiveData<String> getText() {
        return text;
    }

    public void setText(String value) {
        text.setValue(value);
    }

    public LiveData<Integer> getTextColor() {
        return textColor;
    }

    public LiveData<String> getFontPath() {
        return fontPath;
    }

    public void setTextColor(int color) {
        textColor.setValue(color);
    }

    public void setFont(String font) {
        fontPath.setValue(font);
    }

    public List<StylePreset> getStylePresets() {
        return stylePresets;
    }

    public void setSelectedStyle(StylePreset style) {
        setFont(style.getFontPath());
        setTextColor(style.getColor());
    }
}