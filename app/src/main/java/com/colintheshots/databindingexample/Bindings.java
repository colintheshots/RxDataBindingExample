package com.colintheshots.databindingexample;

import com.squareup.picasso.Picasso;

import android.databinding.BindingAdapter;
import android.widget.ImageView;
import android.widget.TextView;

/**
 * Various data binding examples.
 *
 * Thanks to Lisa Wray for the font bindings.
 * Created by colin on 11/22/15.
 */
public class Bindings {

    @BindingAdapter({"bind:imageUrl"})
    public static void loadImage(ImageView view, String imageUrl) {
        if (!imageUrl.equals("")) {
            Picasso.with(view.getContext())
                    .load(imageUrl)
                    .into(view);
        }
    }

    @BindingAdapter({"bind:font"})
    public static void setFont(TextView textView, String fontName) {
        FontCache fontCache = FontCache.getInstance();
        fontCache.addFont(fontName, fontName);
        textView.setTypeface(fontCache.get(fontName));
    }
}
