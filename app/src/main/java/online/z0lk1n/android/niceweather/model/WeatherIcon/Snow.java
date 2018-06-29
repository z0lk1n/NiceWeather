package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseIntArray;

import online.z0lk1n.android.niceweather.R;

public class Snow {
    private final static SparseIntArray snowDay = new SparseIntArray();
    private final static SparseIntArray snowNight = new SparseIntArray();

    static {
        snowDay.put(600, R.string.wi_snow);
        snowDay.put(601, R.string.wi_snow);
        snowDay.put(602, R.string.wi_snow);
        snowDay.put(611, R.string.wi_snow);
        snowDay.put(612, R.string.wi_snow);
        snowDay.put(615, R.string.wi_snow);
        snowDay.put(616, R.string.wi_snow);
        snowDay.put(620, R.string.wi_snow);
        snowDay.put(621, R.string.wi_snow);
        snowDay.put(622, R.string.wi_snow);

        snowNight.put(600, R.string.wi_snow);
        snowNight.put(601, R.string.wi_snow);
        snowNight.put(602, R.string.wi_snow);
        snowNight.put(611, R.string.wi_snow);
        snowNight.put(612, R.string.wi_snow);
        snowNight.put(615, R.string.wi_snow);
        snowNight.put(616, R.string.wi_snow);
        snowNight.put(620, R.string.wi_snow);
        snowNight.put(621, R.string.wi_snow);
        snowNight.put(622, R.string.wi_snow);
    }

    public static int getSnowIconId(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? snowDay.get(id) : snowNight.get(id);
    }
}
