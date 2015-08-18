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

    private int childCount;
    private String font;
    private ViewGroup containerViewGroup;
    private Context context;

    public static UniFont with(Context context) {
        return new UniFont(context);
    }

    private UniFont(Context context) {
        this.context = context;
    }

    public UniFont initialize(ViewGroup view) {
        this.containerViewGroup = view;
        return this;
    }

    public UniFont setFont(String font) {
        this.font = font;
        return this;
    }

    public void apply() {

        childCount = containerViewGroup.getChildCount();
        for (int i=0; i < childCount; i++){
            View v = containerViewGroup.getChildAt(i);
            if (v instanceof TextView) {
                ((TextView) v).setTypeface(TypeFaceCache.get(context, font));
            }
        }
    }


}
