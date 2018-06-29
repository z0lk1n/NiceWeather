package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseIntArray;

import online.z0lk1n.android.niceweather.R;

public class Thunderstorm {
    private final static SparseIntArray thunderstormDay = new SparseIntArray();
    private final static SparseIntArray thunderstormNight = new SparseIntArray();

    static {
        thunderstormDay.put(200, R.string.wi_thunderstorm);
        thunderstormDay.put(201, R.string.wi_thunderstorm);
        thunderstormDay.put(202, R.string.wi_thunderstorm);
        thunderstormDay.put(210, R.string.wi_thunderstorm);
        thunderstormDay.put(211, R.string.wi_thunderstorm);
        thunderstormDay.put(212, R.string.wi_thunderstorm);
        thunderstormDay.put(221, R.string.wi_thunderstorm);
        thunderstormDay.put(230, R.string.wi_thunderstorm);
        thunderstormDay.put(231, R.string.wi_thunderstorm);
        thunderstormDay.put(232, R.string.wi_thunderstorm);

        thunderstormNight.put(200, R.string.wi_thunderstorm);
        thunderstormNight.put(201, R.string.wi_thunderstorm);
        thunderstormNight.put(202, R.string.wi_thunderstorm);
        thunderstormNight.put(210, R.string.wi_thunderstorm);
        thunderstormNight.put(211, R.string.wi_thunderstorm);
        thunderstormNight.put(212, R.string.wi_thunderstorm);
        thunderstormNight.put(221, R.string.wi_thunderstorm);
        thunderstormNight.put(230, R.string.wi_thunderstorm);
        thunderstormNight.put(231, R.string.wi_thunderstorm);
        thunderstormNight.put(232, R.string.wi_thunderstorm);
    }

    public static int getThunderstormIconId(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? thunderstormDay.get(id) : thunderstormNight.get(id);
    }
}
