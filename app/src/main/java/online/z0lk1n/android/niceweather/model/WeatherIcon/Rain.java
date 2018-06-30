package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseIntArray;

import online.z0lk1n.android.niceweather.R;

public class Rain {
    private final static SparseIntArray rainDay = new SparseIntArray();
    private final static SparseIntArray rainNight = new SparseIntArray();

    static {
        rainDay.put(500, R.string.wi_owm_day_500);
        rainDay.put(501, R.string.wi_owm_day_501);
        rainDay.put(502, R.string.wi_owm_day_502);
        rainDay.put(503, R.string.wi_owm_day_503);
        rainDay.put(504, R.string.wi_owm_day_504);
        rainDay.put(511, R.string.wi_owm_day_511);
        rainDay.put(520, R.string.wi_owm_day_520);
        rainDay.put(521, R.string.wi_owm_day_521);
        rainDay.put(522, R.string.wi_owm_day_522);
        rainDay.put(531, R.string.wi_owm_day_531);

        rainNight.put(500, R.string.wi_owm_night_500);
        rainNight.put(501, R.string.wi_owm_night_501);
        rainNight.put(502, R.string.wi_owm_night_502);
        rainNight.put(503, R.string.wi_owm_night_503);
        rainNight.put(504, R.string.wi_owm_night_504);
        rainNight.put(511, R.string.wi_owm_night_511);
        rainNight.put(520, R.string.wi_owm_night_520);
        rainNight.put(521, R.string.wi_owm_night_521);
        rainNight.put(522, R.string.wi_owm_night_522);
        rainNight.put(531, R.string.wi_owm_night_531);
    }

    public static int getRainIconId(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? rainDay.get(id) : rainNight.get(id);
    }
}
