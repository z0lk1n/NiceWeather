package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseIntArray;

import online.z0lk1n.android.niceweather.R;

public class Clouds {
    private final static SparseIntArray cloudsDay = new SparseIntArray();
    private final static SparseIntArray cloudsNight = new SparseIntArray();

    static {
        cloudsDay.put(801, R.string.wi_cloud);
        cloudsDay.put(802, R.string.wi_cloud);
        cloudsDay.put(803, R.string.wi_cloud);
        cloudsDay.put(804, R.string.wi_cloud);

        cloudsNight.put(801, R.string.wi_cloud);
        cloudsNight.put(802, R.string.wi_cloud);
        cloudsNight.put(803, R.string.wi_cloud);
        cloudsNight.put(804, R.string.wi_cloud);
    }

    public static int getCloudsIconId(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? cloudsDay.get(id) : cloudsNight.get(id);
    }
}
