package nader.app.statusEditor.utils;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Typeface;
import androidx.annotation.ColorInt;
import android.content.Context;

public class TextOverlayRenderer {
	
	/**
	* Draws text on a bitmap using the given font and color.
	* Returns a new bitmap with the overlay applied.
	*/
	public static Bitmap drawTextOnBitmap(Context context, Bitmap originalBitmap,
	String text, String fontPath, @ColorInt int color, float textSize) {
		Bitmap mutableBitmap = originalBitmap.copy(Bitmap.Config.ARGB_8888, true);
		Canvas canvas = new Canvas(mutableBitmap);
		
		Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
		paint.setColor(color);
		paint.setTextSize(textSize);
		
		if (fontPath != null) {
			Typeface typeface = Typeface.createFromAsset(context.getAssets(), fontPath);
			paint.setTypeface(typeface);
		}
		
		float x = 20; // padding from left
		float y = canvas.getHeight() - 40; // padding from bottom
		
		canvas.drawText(text, x, y, paint);
		
		return mutableBitmap;
	}
}