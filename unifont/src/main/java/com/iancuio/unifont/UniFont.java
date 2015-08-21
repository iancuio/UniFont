package com.iancuio.unifont;

import android.content.Context;
import android.graphics.Typeface;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.Hashtable;

/**
 * Created by Soulstorm on 7/29/2015.
 */
public class UniFont {

    private String font;
    private Context context;

    public static UniFont with(Context context) {
        return new UniFont(context);
    }

    private UniFont(Context context) {
        this.context = context;
    }

    public UniFont setFont(String font) {
        this.font = font;
        return this;
    }

    public void apply(ViewGroup view) {
        for (int i = 0; i < view.getChildCount(); i++) {
            View child = view.getChildAt(i);
            if (child instanceof ViewGroup) {
                apply((ViewGroup) child);
            } else if (child != null) {
                if (child instanceof TextView) {
                    ((TextView) child).setTypeface(TypeFaceCache.get(context, font));
                }
            }
        }
    }
}
