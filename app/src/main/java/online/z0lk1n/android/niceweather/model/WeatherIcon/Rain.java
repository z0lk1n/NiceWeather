package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseArray;

public class Rain {
    private final static SparseArray<String> rainDay = new SparseArray<>();
    private final static SparseArray<String> rainNight = new SparseArray<>();

    static {
        rainDay.put(500, "");
        rainDay.put(501, "");
        rainDay.put(502, "");
        rainDay.put(503, "");
        rainDay.put(504, "");
        rainDay.put(511, "");
        rainDay.put(520, "");
        rainDay.put(521, "");
        rainDay.put(522, "");
        rainDay.put(531, "");

        rainNight.put(500, "");
        rainNight.put(501, "");
        rainNight.put(502, "");
        rainNight.put(503, "");
        rainNight.put(504, "");
        rainNight.put(511, "");
        rainNight.put(520, "");
        rainNight.put(521, "");
        rainNight.put(522, "");
        rainNight.put(531, "");
    }

    public static String getRainIcon(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? rainDay.get(id) : rainNight.get(id);
    }
}
