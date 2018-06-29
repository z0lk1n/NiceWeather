package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseIntArray;

public class Rain {
    private final static SparseIntArray rainDay = new SparseIntArray();
    private final static SparseIntArray rainNight = new SparseIntArray();

    static {
        rainDay.put(500, 0);
        rainDay.put(501, 0);
        rainDay.put(502, 0);
        rainDay.put(503, 0);
        rainDay.put(504, 0);
        rainDay.put(511, 0);
        rainDay.put(520, 0);
        rainDay.put(521, 0);
        rainDay.put(522, 0);
        rainDay.put(531, 0);

        rainNight.put(500, 0);
        rainNight.put(501, 0);
        rainNight.put(502, 0);
        rainNight.put(503, 0);
        rainNight.put(504, 0);
        rainNight.put(511, 0);
        rainNight.put(520, 0);
        rainNight.put(521, 0);
        rainNight.put(522, 0);
        rainNight.put(531, 0);
    }

    public static int getRainIconId(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? rainDay.get(id) : rainNight.get(id);
    }
}
