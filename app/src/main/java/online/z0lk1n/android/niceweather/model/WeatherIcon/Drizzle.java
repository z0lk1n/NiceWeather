package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseIntArray;

import online.z0lk1n.android.niceweather.R;

public class Drizzle {
    private final static SparseIntArray drizzleDay = new SparseIntArray();
    private final static SparseIntArray drizzleNight = new SparseIntArray();

    static {
        drizzleDay.put(300, R.string.wi_owm_day_300);
        drizzleDay.put(301, R.string.wi_owm_day_301);
        drizzleDay.put(302, R.string.wi_owm_day_302);
        drizzleDay.put(310, R.string.wi_owm_day_310);
        drizzleDay.put(311, R.string.wi_owm_day_311);
        drizzleDay.put(312, R.string.wi_owm_day_312);
        drizzleDay.put(313, R.string.wi_owm_day_313);
        drizzleDay.put(314, R.string.wi_owm_day_314);
        drizzleDay.put(321, R.string.wi_owm_day_321);

        drizzleNight.put(300, R.string.wi_owm_night_300);
        drizzleNight.put(301, R.string.wi_owm_night_301);
        drizzleNight.put(302, R.string.wi_owm_night_302);
        drizzleNight.put(310, R.string.wi_owm_night_310);
        drizzleNight.put(311, R.string.wi_owm_night_311);
        drizzleNight.put(312, R.string.wi_owm_night_312);
        drizzleNight.put(313, R.string.wi_owm_night_313);
        drizzleNight.put(314, R.string.wi_owm_night_314);
        drizzleNight.put(321, R.string.wi_owm_night_321);
    }

    public static int getDrizzleIconId(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? drizzleDay.get(id) : drizzleNight.get(id);
    }
}
