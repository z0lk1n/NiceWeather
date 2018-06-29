package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseIntArray;

public class Clouds {
    private final static SparseIntArray cloudsDay = new SparseIntArray();
    private final static SparseIntArray cloudsNight = new SparseIntArray();

    static {
        cloudsDay.put(801, 0);
        cloudsDay.put(802, 0);
        cloudsDay.put(803, 0);
        cloudsDay.put(804, 0);

        cloudsNight.put(801, 0);
        cloudsNight.put(802, 0);
        cloudsNight.put(803, 0);
        cloudsNight.put(804, 0);
    }

    public static int getCloudsIconId(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? cloudsDay.get(id) : cloudsNight.get(id);
    }
}
