package nader.app.statusEditor.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import nader.app.statusEditor.activity.HostActivity;
import nader.app.statusEditor.fragments.*;
import nader.app.statusEditor.viewmodel.SharedViewModel;

public class CanvasFragment extends Fragment {
	private ImageView imageView;
	private TextView textOverlay;
	
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_canvas, container, false);
		imageView = view.findViewById(R.id.canvasImage);
		textOverlay = view.findViewById(R.id.textOverlay);
		
		SharedViewModel.getInstance().getImageUri().observe(getViewLifecycleOwner(), uri -> {
			if (uri != null) {
				imageView.setImageURI(uri);
			}
		});
		
		view.findViewById(R.id.editTextBtn).setOnClickListener(v ->
		((HostActivity) requireActivity()).openFragment(new TextEditorFragment())
		);
		
		view.findViewById(R.id.styleBtn).setOnClickListener(v ->
		((HostActivity) requireActivity()).openFragment(new StylePresetsFragment())
		);
		
		view.findViewById(R.id.exportBtn).setOnClickListener(v ->
		((HostActivity) requireActivity()).openFragment(new ExportFragment())
		);
		
		SharedViewModel.getInstance().getText().observe(getViewLifecycleOwner(), text -> {
			textOverlay.setText(text);
		});
		
		return view;
	}
}