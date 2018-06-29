package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseArray;

public class Clouds {
    private final static SparseArray<String> cloudsDay = new SparseArray<>();
    private final static SparseArray<String> cloudsNight = new SparseArray<>();

    static {
        cloudsDay.put(801, "");
        cloudsDay.put(802, "");
        cloudsDay.put(803, "");
        cloudsDay.put(804, "");

        cloudsNight.put(801, "");
        cloudsNight.put(802, "");
        cloudsNight.put(803, "");
        cloudsNight.put(804, "");
    }

    public static String getCloudsIcon(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? cloudsDay.get(id) : cloudsNight.get(id);
    }
}
