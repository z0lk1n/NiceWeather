package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseIntArray;

import online.z0lk1n.android.niceweather.R;

public class Drizzle {
    private final static SparseIntArray drizzleDay = new SparseIntArray();
    private final static SparseIntArray drizzleNight = new SparseIntArray();

    static {
        drizzleDay.put(300, R.string.wi_rain);
        drizzleDay.put(301, R.string.wi_rain);
        drizzleDay.put(302, R.string.wi_rain);
        drizzleDay.put(310, R.string.wi_rain);
        drizzleDay.put(311, R.string.wi_rain);
        drizzleDay.put(312, R.string.wi_rain);
        drizzleDay.put(313, R.string.wi_rain);
        drizzleDay.put(314, R.string.wi_rain);
        drizzleDay.put(321, R.string.wi_rain);

        drizzleNight.put(300, R.string.wi_rain);
        drizzleNight.put(301, R.string.wi_rain);
        drizzleNight.put(302, R.string.wi_rain);
        drizzleNight.put(310, R.string.wi_rain);
        drizzleNight.put(311, R.string.wi_rain);
        drizzleNight.put(312, R.string.wi_rain);
        drizzleNight.put(313, R.string.wi_rain);
        drizzleNight.put(314, R.string.wi_rain);
        drizzleNight.put(321, R.string.wi_rain);
    }

    public static int getDrizzleIconId(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? drizzleDay.get(id) : drizzleNight.get(id);
    }
}
