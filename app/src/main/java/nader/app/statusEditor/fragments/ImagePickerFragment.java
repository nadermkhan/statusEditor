package nader.app.statusEditor.fragments;

import android.app.Activity;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import nader.app.statusEditor.R;
// Replace these with your actual package paths
import nader.app.statusEditor.activity.HostActivity;
import nader.app.statusEditor.fragments.CanvasFragment;
import nader.app.statusEditor.viewmodel.SharedViewModel;

public class ImagePickerFragment extends Fragment {
	private static final int PICK_IMAGE = 1;
	private ImageView preview;
	
	@Nullable
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
	Bundle savedInstanceState) {
		View view = inflater.inflate(R.layout.fragment_image_picker, container, false);
		preview = view.findViewById(R.id.imagePreview);
		
		view.findViewById(R.id.pickImageBtn).setOnClickListener(v -> {
			Intent intent = new Intent(Intent.ACTION_PICK, MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
			startActivityForResult(intent, PICK_IMAGE);
		});
		
		view.findViewById(R.id.nextBtn).setOnClickListener(v -> {
			((HostActivity) requireActivity()).openFragment(new CanvasFragment());
		});
		
		return view;
	}
	
	@Override
	public void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == PICK_IMAGE && resultCode == Activity.RESULT_OK && data != null) {
			Uri imageUri = data.getData();
			preview.setImageURI(imageUri);
			SharedViewModel.getInstance().setImageUri(imageUri);
		}
	}
}