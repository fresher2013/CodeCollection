
package com.miemie.utils;

import android.content.Context;

import java.util.Formatter;
import java.util.Locale;

public class Utils {

    public static int dpToPx(Context context, float dp) {
        float density = context.getResources().getDisplayMetrics().density;
        return Math.round(dp * density);
    }

    public static int spToPx(Context context,int spValue) {
        final float fontScale = context.getResources().getDisplayMetrics().scaledDensity;
        return (int) (spValue * fontScale);
    }

    /**
     * format time in ms into string
     * 
     * @param timeMs
     * @return
     */

    public static String stringForTime(int timeMs) {
        int totalSeconds = timeMs / 1000;

        int seconds = totalSeconds % 60;
        int minutes = (totalSeconds / 60) % 60;
        int hours = totalSeconds / 3600;

        final StringBuilder formatBuilder = new StringBuilder();
        final Formatter formatter = new Formatter(formatBuilder, Locale.getDefault());
        try {
            if (hours > 0) {
                return formatter.format("%d:%02d:%02d", hours, minutes, seconds).toString();
            } else {
                return formatter.format("%02d:%02d", minutes, seconds).toString();
            }
        } finally {
            formatter.close();
        }
    }
}
