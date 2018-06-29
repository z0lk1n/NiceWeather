package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseIntArray;

import online.z0lk1n.android.niceweather.R;

public class Rain {
    private final static SparseIntArray rainDay = new SparseIntArray();
    private final static SparseIntArray rainNight = new SparseIntArray();

    static {
        rainDay.put(500, R.string.wi_rain);
        rainDay.put(501, R.string.wi_rain);
        rainDay.put(502, R.string.wi_rain);
        rainDay.put(503, R.string.wi_rain);
        rainDay.put(504, R.string.wi_rain);
        rainDay.put(511, R.string.wi_rain);
        rainDay.put(520, R.string.wi_rain);
        rainDay.put(521, R.string.wi_rain);
        rainDay.put(522, R.string.wi_rain);
        rainDay.put(531, R.string.wi_rain);

        rainNight.put(500, R.string.wi_rain);
        rainNight.put(501, R.string.wi_rain);
        rainNight.put(502, R.string.wi_rain);
        rainNight.put(503, R.string.wi_rain);
        rainNight.put(504, R.string.wi_rain);
        rainNight.put(511, R.string.wi_rain);
        rainNight.put(520, R.string.wi_rain);
        rainNight.put(521, R.string.wi_rain);
        rainNight.put(522, R.string.wi_rain);
        rainNight.put(531, R.string.wi_rain);
    }

    public static int getRainIconId(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? rainDay.get(id) : rainNight.get(id);
    }
}
