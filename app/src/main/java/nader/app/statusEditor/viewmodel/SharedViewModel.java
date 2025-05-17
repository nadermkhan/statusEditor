package nader.app.statusEditor.viewmodel;

import android.app.Application;
import android.graphics.Color;
import android.net.Uri;
import android.graphics.Typeface;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;
import androidx.lifecycle.ViewModelProvider;

import java.util.ArrayList;
import java.util.List;

import nader.app.statusEditor.model.StylePreset;

public class SharedViewModel extends ViewModel {
    private static SharedViewModel instance;

    private final MutableLiveData<Uri> imageUri = new MutableLiveData<>();
    private final MutableLiveData<String> text = new MutableLiveData<>("Your Text Here");
    private final MutableLiveData<Integer> textColor = new MutableLiveData<>(Color.BLACK);
    private final MutableLiveData<String> fontPath = new MutableLiveData<>(null);

    private final List<StylePreset> stylePresets = new ArrayList<>();

    private SharedViewModel() {
        // Populate default style presets
        stylePresets.add(new StylePreset("Classic", Typeface.NORMAL, Color.BLACK));
        stylePresets.add(new StylePreset("Bold", Typeface.BOLD, Color.BLUE));
        stylePresets.add(new StylePreset("Italic Red", Typeface.ITALIC, Color.RED));
        stylePresets.add(new StylePreset("Bold Italic Green", Typeface.BOLD_ITALIC, Color.GREEN));
    }

    public static SharedViewModel getInstance() {
        if (instance == null) {
            instance = new ViewModelProvider.AndroidViewModelFactory(new Application())
                .create(SharedViewModel.class);
        }
        return instance;
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

    public void setTextColor(int color) {
        textColor.setValue(color);
    }

    public LiveData<String> getFontPath() {
        return fontPath;
    }

    public void setFont(String font) {
        fontPath.setValue(font);
    }

    public List<StylePreset> getStylePresets() {
        return stylePresets;
    }
}