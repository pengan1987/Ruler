package com.abcmeasure.andyzhou.ruler;

import android.databinding.BindingAdapter;
import android.view.View;
import android.view.ViewGroup;

public class RulerGridViewModel {
    public String rulerNumber;
    public float dpi;

    public RulerGridViewModel(String rulerNumber, float dpi) {
        this.rulerNumber = rulerNumber;
        this.dpi = dpi;
    }

    @BindingAdapter("dynamic_width")
    public static void setLayoutWidth(View view, float width) {
        ViewGroup.LayoutParams layoutParams = view.getLayoutParams();
        layoutParams.width = (int) width;
        view.setLayoutParams(layoutParams);
    }
}
