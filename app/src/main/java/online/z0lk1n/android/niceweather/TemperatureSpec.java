package online.z0lk1n.android.niceweather;

import android.content.Context;

public class TemperatureSpec {
    static String getTemperature(Context context, int position) {
        String[] strings = context.getResources().getStringArray(R.array.temperature);
        String temperature = strings[position];
        return temperature;
    }
}
