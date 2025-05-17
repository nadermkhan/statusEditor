package nader.app.statusEditor.fragments;

import android.graphics.Color;
import android.graphics.Typeface;
import android.net.Uri;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.bumptech.glide.Glide;

import nader.app.statusEditor.R;
import nader.app.statusEditor.viewmodel.SharedViewModel;

public class CanvasFragment extends Fragment {

    private SharedViewModel viewModel;
    private ImageView imageView;
    private TextView textView;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_canvas, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        imageView = view.findViewById(R.id.image_view);
        textView = view.findViewById(R.id.canvas_text);

        viewModel.getImageUri().observe(getViewLifecycleOwner(), uri -> {
            if (uri != null) {
                Glide.with(this).load(uri).into(imageView);
            }
        });

        viewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        viewModel.getTextColor().observe(getViewLifecycleOwner(), textView::setTextColor);
        viewModel.getFontPath().observe(getViewLifecycleOwner(), path -> {
            if (path != null) {
                Typeface typeface = Typeface.createFromAsset(requireContext().getAssets(), path);
                textView.setTypeface(typeface);
            }
        });
    }
}