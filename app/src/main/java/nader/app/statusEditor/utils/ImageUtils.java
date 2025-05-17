package nader.app.statusEditor.utils;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import java.io.IOException;
import java.io.InputStream;

public class ImageUtils {
	
	/**
	* Decode an image from a given Uri into a Bitmap.
	*/
	public static Bitmap decodeBitmapFromUri(Context context, Uri uri) {
		try (InputStream inputStream = context.getContentResolver().openInputStream(uri)) {
			return BitmapFactory.decodeStream(inputStream);
			} catch (IOException e) {
			e.printStackTrace();
			return null;
		}
	}
}