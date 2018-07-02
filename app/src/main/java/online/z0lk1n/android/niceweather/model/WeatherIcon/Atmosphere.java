package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseIntArray;

import online.z0lk1n.android.niceweather.R;

public final class Atmosphere {
    private final static SparseIntArray atmosphereDay = new SparseIntArray();
    private final static SparseIntArray atmosphereNight = new SparseIntArray();

    static {
        atmosphereDay.put(701, R.string.wi_owm_day_701);
        atmosphereDay.put(711, R.string.wi_owm_day_711);
        atmosphereDay.put(721, R.string.wi_owm_day_721);
        atmosphereDay.put(731, R.string.wi_owm_day_731);
        atmosphereDay.put(741, R.string.wi_owm_day_741);
        atmosphereDay.put(751, R.string.wi_owm_day_761);
        atmosphereDay.put(761, R.string.wi_owm_day_761);
        atmosphereDay.put(762, R.string.wi_owm_day_762);
        atmosphereDay.put(771, R.string.wi_owm_day_771);
        atmosphereDay.put(781, R.string.wi_owm_day_781);

        atmosphereNight.put(701, R.string.wi_owm_night_701);
        atmosphereNight.put(711, R.string.wi_owm_night_711);
        atmosphereNight.put(721, R.string.wi_owm_night_721);
        atmosphereNight.put(731, R.string.wi_owm_night_731);
        atmosphereNight.put(741, R.string.wi_owm_night_741);
        atmosphereNight.put(751, R.string.wi_owm_night_761);
        atmosphereNight.put(761, R.string.wi_owm_night_761);
        atmosphereNight.put(762, R.string.wi_owm_night_762);
        atmosphereNight.put(771, R.string.wi_owm_night_771);
        atmosphereNight.put(781, R.string.wi_owm_night_781);
    }

    public static int getAtmosphereIconId(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? atmosphereDay.get(id) : atmosphereNight.get(id);
    }
}
