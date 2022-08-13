package com.example.licenta2022.helpers;

import android.content.Context;
import android.util.DisplayMetrics;

public class ViewUtils {
    private static ViewUtils instance = null;

    public static synchronized ViewUtils getInstance() {
        if (instance == null)
            instance = new ViewUtils();

        return instance;
    }

    public ViewUtils() {
    }

    public int convertDpToPixel(float dp, Context context) {
        return (int) (dp * context.getResources().getDisplayMetrics().densityDpi / DisplayMetrics.DENSITY_DEFAULT);
    }
}
