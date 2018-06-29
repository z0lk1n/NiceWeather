package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseIntArray;

public class Drizzle {
    private final static SparseIntArray drizzleDay = new SparseIntArray();
    private final static SparseIntArray drizzleNight = new SparseIntArray();

    static {
        drizzleDay.put(300, 0);
        drizzleDay.put(301, 0);
        drizzleDay.put(302, 0);
        drizzleDay.put(310, 0);
        drizzleDay.put(311, 0);
        drizzleDay.put(312, 0);
        drizzleDay.put(313, 0);
        drizzleDay.put(314, 0);
        drizzleDay.put(321, 0);

        drizzleNight.put(300, 0);
        drizzleNight.put(301, 0);
        drizzleNight.put(302, 0);
        drizzleNight.put(310, 0);
        drizzleNight.put(311, 0);
        drizzleNight.put(312, 0);
        drizzleNight.put(313, 0);
        drizzleNight.put(314, 0);
        drizzleNight.put(321, 0);
    }

    public static int getDrizzleIconId(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? drizzleDay.get(id) : drizzleNight.get(id);
    }
}
