package com.app.noswipeviewpager.utils;

import android.content.Context;
import android.util.TypedValue;

public final class AppUtils {

    public static int dpToPx(Context context, float dp) {
        return (int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, dp, context.getResources().getDisplayMetrics());
    }

}
