package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseArray;

public class Drizzle {
    private final static SparseArray<String> drizzleDay = new SparseArray<>();
    private final static SparseArray<String> drizzleNight = new SparseArray<>();

    static {
        drizzleDay.put(300, "");
        drizzleDay.put(301, "");
        drizzleDay.put(302, "");
        drizzleDay.put(310, "");
        drizzleDay.put(311, "");
        drizzleDay.put(312, "");
        drizzleDay.put(313, "");
        drizzleDay.put(314, "");
        drizzleDay.put(321, "");

        drizzleNight.put(300, "");
        drizzleNight.put(301, "");
        drizzleNight.put(302, "");
        drizzleNight.put(310, "");
        drizzleNight.put(311, "");
        drizzleNight.put(312, "");
        drizzleNight.put(313, "");
        drizzleNight.put(314, "");
        drizzleNight.put(321, "");
    }

    public static String getDrizzleIcon(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? drizzleDay.get(id) : drizzleNight.get(id);
    }
}
