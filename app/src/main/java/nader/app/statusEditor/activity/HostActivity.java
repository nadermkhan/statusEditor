package nader.app.statusEditor.activity;

import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

// Replace this with your actual package name where ImagePickerFragment is defined
import nader.app.statusEditor.fragments.ImagePickerFragment;
public class HostActivity extends AppCompatActivity {
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_host);
		
		if (savedInstanceState == null) {
			getSupportFragmentManager()
			.beginTransaction()
			.replace(R.id.fragment_container, new ImagePickerFragment())
			.commit();
		}
	}
	
	public void openFragment(Fragment fragment) {
		getSupportFragmentManager()
		.beginTransaction()
		.replace(R.id.fragment_container, fragment)
		.addToBackStack(null)
		.commit();
	}
}