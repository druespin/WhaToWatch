package com.example.multiapptest.util;

import android.widget.ImageView;

import com.squareup.picasso.Picasso;

public class ImageLoader {

    public static void loadImage(String url, ImageView image) {
        String IMAGE_BASE_URL = "https://image.tmdb.org/t/p/w500";

        Picasso.get()
                .load(IMAGE_BASE_URL + url)
                .resize(100, 100)
                .centerCrop()
                .into(image);
    }
}
