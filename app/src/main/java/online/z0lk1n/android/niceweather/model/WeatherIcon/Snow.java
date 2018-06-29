package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseIntArray;

public class Snow {
    private final static SparseIntArray snowDay = new SparseIntArray();
    private final static SparseIntArray snowNight = new SparseIntArray();

    static {
        snowDay.put(600, 0);
        snowDay.put(601, 0);
        snowDay.put(602, 0);
        snowDay.put(611, 0);
        snowDay.put(612, 0);
        snowDay.put(615, 0);
        snowDay.put(616, 0);
        snowDay.put(620, 0);
        snowDay.put(621, 0);
        snowDay.put(622, 0);

        snowNight.put(600, 0);
        snowNight.put(601, 0);
        snowNight.put(602, 0);
        snowNight.put(611, 0);
        snowNight.put(612, 0);
        snowNight.put(615, 0);
        snowNight.put(616, 0);
        snowNight.put(620, 0);
        snowNight.put(621, 0);
        snowNight.put(622, 0);
    }

    public static int getSnowIconId(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? snowDay.get(id) : snowNight.get(id);
    }
}
