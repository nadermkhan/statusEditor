package nader.app.statusEditor.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import nader.app.statusEditor.R;
import nader.app.statusEditor.adapter.StylePresetAdapter;
import nader.app.statusEditor.viewmodel.SharedViewModel;

public class StylePresetsFragment extends Fragment {

    private SharedViewModel viewModel;
    private RecyclerView recyclerView;
    private StylePresetAdapter adapter;

    public StylePresetsFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_style_presets, container, false);

        recyclerView = view.findViewById(R.id.recyclerView);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));

        viewModel = new ViewModelProvider(requireActivity()).get(SharedViewModel.class);
        adapter = new StylePresetAdapter(viewModel.getStylePresets(), style -> {
            viewModel.setSelectedStyle(style);
            requireActivity().getSupportFragmentManager().popBackStack();
        });

        recyclerView.setAdapter(adapter);

        return view;
    }
}