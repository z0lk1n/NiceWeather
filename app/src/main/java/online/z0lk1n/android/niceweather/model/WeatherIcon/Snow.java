package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseIntArray;

import online.z0lk1n.android.niceweather.R;

public class Snow {
    private final static SparseIntArray snowDay = new SparseIntArray();
    private final static SparseIntArray snowNight = new SparseIntArray();

    static {
        snowDay.put(600, R.string.wi_owm_day_600);
        snowDay.put(601, R.string.wi_owm_day_601);
        snowDay.put(602, R.string.wi_owm_day_602);
        snowDay.put(611, R.string.wi_owm_day_611);
        snowDay.put(612, R.string.wi_owm_day_612);
        snowDay.put(615, R.string.wi_owm_day_615);
        snowDay.put(616, R.string.wi_owm_day_616);
        snowDay.put(620, R.string.wi_owm_day_620);
        snowDay.put(621, R.string.wi_owm_day_621);
        snowDay.put(622, R.string.wi_owm_day_622);

        snowNight.put(600, R.string.wi_owm_night_600);
        snowNight.put(601, R.string.wi_owm_night_601);
        snowNight.put(602, R.string.wi_owm_night_602);
        snowNight.put(611, R.string.wi_owm_night_611);
        snowNight.put(612, R.string.wi_owm_night_612);
        snowNight.put(615, R.string.wi_owm_night_615);
        snowNight.put(616, R.string.wi_owm_night_616);
        snowNight.put(620, R.string.wi_owm_night_620);
        snowNight.put(621, R.string.wi_owm_night_621);
        snowNight.put(622, R.string.wi_owm_night_622);
    }

    public static int getSnowIconId(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? snowDay.get(id) : snowNight.get(id);
    }
}
