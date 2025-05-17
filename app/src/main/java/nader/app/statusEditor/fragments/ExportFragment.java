package nader.app.statusEditor.fragments;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

public class ExportFragment extends Fragment {
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_export, container, false);
		
		view.findViewById(R.id.saveBtn).setOnClickListener(v -> {
			Toast.makeText(getContext(), "Image saved!", Toast.LENGTH_SHORT).show();
			requireActivity().onBackPressed();
		});
		
		return view;
	}
}