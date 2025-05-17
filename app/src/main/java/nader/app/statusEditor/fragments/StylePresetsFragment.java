package nader.app.statusEditor.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import nader.app.statusEditor.R;
import nader.app.statusEditor.adapter.StylePresetAdapter;
import nader.app.statusEditor.model.StylePreset;
import nader.app.statusEditor.viewmodel.SharedViewModel;

public class StylePresetsFragment extends Fragment {

    private SharedViewModel viewModel;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_style_presets, container, false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);

        RecyclerView recyclerView = view.findViewById(R.id.style_presets_recycler_view);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        StylePresetAdapter adapter = new StylePresetAdapter(
                requireContext(),
                viewModel.getStylePresets(),
                style -> {
                    viewModel.setTextColor(style.getColor());
                    viewModel.setFont(style.getFontPath());
                });

        recyclerView.setAdapter(adapter);
    }
}