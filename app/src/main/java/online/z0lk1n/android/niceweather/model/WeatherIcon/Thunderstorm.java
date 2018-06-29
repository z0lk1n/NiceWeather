package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseIntArray;

import online.z0lk1n.android.niceweather.R;

public class Thunderstorm {
    private final static SparseIntArray thunderstormDay = new SparseIntArray();
    private final static SparseIntArray thunderstormNight = new SparseIntArray();

    static {
        thunderstormDay.put(200, R.string.wi_day_sunny);
        thunderstormDay.put(201, 0);
        thunderstormDay.put(202, 0);
        thunderstormDay.put(210, 0);
        thunderstormDay.put(211, 0);
        thunderstormDay.put(212, 0);
        thunderstormDay.put(221, 0);
        thunderstormDay.put(230, 0);
        thunderstormDay.put(231, 0);
        thunderstormDay.put(232, 0);

        thunderstormNight.put(200, 0);
        thunderstormNight.put(201, 0);
        thunderstormNight.put(202, 0);
        thunderstormNight.put(210, 0);
        thunderstormNight.put(211, 0);
        thunderstormNight.put(212, 0);
        thunderstormNight.put(221, 0);
        thunderstormNight.put(230, 0);
        thunderstormNight.put(231, 0);
        thunderstormNight.put(232, 0);
    }

    public static int getThunderstormIconId(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? thunderstormDay.get(id) : thunderstormNight.get(id);
    }
}
