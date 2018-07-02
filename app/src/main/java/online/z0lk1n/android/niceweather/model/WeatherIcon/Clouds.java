package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseIntArray;

import online.z0lk1n.android.niceweather.R;

public final class Clouds {
    private final static SparseIntArray cloudsDay = new SparseIntArray();
    private final static SparseIntArray cloudsNight = new SparseIntArray();

    static {
        cloudsDay.put(801, R.string.wi_owm_day_801);
        cloudsDay.put(802, R.string.wi_owm_day_802);
        cloudsDay.put(803, R.string.wi_owm_day_803);
        cloudsDay.put(804, R.string.wi_owm_day_804);

        cloudsNight.put(801, R.string.wi_owm_night_801);
        cloudsNight.put(802, R.string.wi_owm_night_802);
        cloudsNight.put(803, R.string.wi_owm_night_803);
        cloudsNight.put(804, R.string.wi_owm_night_804);
    }

    public static int getCloudsIconId(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? cloudsDay.get(id) : cloudsNight.get(id);
    }
}
