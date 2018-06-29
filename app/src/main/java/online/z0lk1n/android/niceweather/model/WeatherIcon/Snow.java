package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseArray;

public class Snow {
    private final static SparseArray<String> snowDay = new SparseArray<>();
    private final static SparseArray<String> snowNight = new SparseArray<>();

    static {
        snowDay.put(600, "");
        snowDay.put(601, "");
        snowDay.put(602, "");
        snowDay.put(611, "");
        snowDay.put(612, "");
        snowDay.put(615, "");
        snowDay.put(616, "");
        snowDay.put(620, "");
        snowDay.put(621, "");
        snowDay.put(622, "");

        snowNight.put(600, "");
        snowNight.put(601, "");
        snowNight.put(602, "");
        snowNight.put(611, "");
        snowNight.put(612, "");
        snowNight.put(615, "");
        snowNight.put(616, "");
        snowNight.put(620, "");
        snowNight.put(621, "");
        snowNight.put(622, "");
    }

    public static String getSnowIcon(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? snowDay.get(id) : snowNight.get(id);
    }
}
