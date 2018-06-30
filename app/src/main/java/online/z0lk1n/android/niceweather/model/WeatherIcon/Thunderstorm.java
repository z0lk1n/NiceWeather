package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseIntArray;

import online.z0lk1n.android.niceweather.R;

public class Thunderstorm {
    private final static SparseIntArray thunderstormDay = new SparseIntArray();
    private final static SparseIntArray thunderstormNight = new SparseIntArray();

    static {
        thunderstormDay.put(200, R.string.wi_owm_day_200);
        thunderstormDay.put(201, R.string.wi_owm_day_201);
        thunderstormDay.put(202, R.string.wi_owm_day_202);
        thunderstormDay.put(210, R.string.wi_owm_day_210);
        thunderstormDay.put(211, R.string.wi_owm_day_211);
        thunderstormDay.put(212, R.string.wi_owm_day_212);
        thunderstormDay.put(221, R.string.wi_owm_day_221);
        thunderstormDay.put(230, R.string.wi_owm_day_230);
        thunderstormDay.put(231, R.string.wi_owm_day_231);
        thunderstormDay.put(232, R.string.wi_owm_day_232);

        thunderstormNight.put(200, R.string.wi_owm_night_200);
        thunderstormNight.put(201, R.string.wi_owm_night_201);
        thunderstormNight.put(202, R.string.wi_owm_night_202);
        thunderstormNight.put(210, R.string.wi_owm_night_210);
        thunderstormNight.put(211, R.string.wi_owm_night_211);
        thunderstormNight.put(212, R.string.wi_owm_night_212);
        thunderstormNight.put(221, R.string.wi_owm_night_221);
        thunderstormNight.put(230, R.string.wi_owm_night_230);
        thunderstormNight.put(231, R.string.wi_owm_night_231);
        thunderstormNight.put(232, R.string.wi_owm_night_232);
    }

    public static int getThunderstormIconId(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? thunderstormDay.get(id) : thunderstormNight.get(id);
    }
}
