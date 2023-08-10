package com.example.myapplication.imagecache;

import android.graphics.Bitmap;
import android.widget.ImageView;
import android.widget.Toast;

public class ImageUtils {

    public static void loadImage(String imageUrl, ImageView imageView) {
        Bitmap cachedBitmap = ImageCache.getInstance().getBitmapFromMemoryCache(imageUrl);
        if (cachedBitmap != null) {
            imageView.setImageBitmap(cachedBitmap);
        } else {
            Bitmap loadedBitmap = loadImageFromDiskOrNetwork(imageUrl);
            if (loadedBitmap != null) {
                imageView.setImageBitmap(loadedBitmap);
                ImageCache.getInstance().addBitmapToMemoryCache(imageUrl, loadedBitmap);
            }
        }
    }

    private static Bitmap loadImageFromDiskOrNetwork(String imageUrl) {
        return null;
    }
}