package nader.app.statusEditor.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import nader.app.statusEditor.viewmodel.SharedViewModel;

public class TextEditorFragment extends Fragment {
	private EditText inputText;
	
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_text_editor, container, false);
		inputText = view.findViewById(R.id.editText);
		
		view.findViewById(R.id.applyBtn).setOnClickListener(v -> {
			String text = inputText.getText().toString();
			SharedViewModel.getInstance().setText(text);
			requireActivity().onBackPressed();
		});
		
		return view;
	}
}