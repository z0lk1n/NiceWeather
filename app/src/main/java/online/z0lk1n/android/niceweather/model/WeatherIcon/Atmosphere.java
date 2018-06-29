package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseArray;

public class Atmosphere {
    private final static SparseArray<String> atmosphereDay = new SparseArray<>();
    private final static SparseArray<String> atmosphereNight = new SparseArray<>();

    static {
        atmosphereDay.put(701, "");
        atmosphereDay.put(711, "");
        atmosphereDay.put(721, "");
        atmosphereDay.put(731, "");
        atmosphereDay.put(741, "");
        atmosphereDay.put(751, "");
        atmosphereDay.put(761, "");
        atmosphereDay.put(762, "");
        atmosphereDay.put(771, "");
        atmosphereDay.put(781, "");

        atmosphereNight.put(701, "");
        atmosphereNight.put(711, "");
        atmosphereNight.put(721, "");
        atmosphereNight.put(731, "");
        atmosphereNight.put(741, "");
        atmosphereNight.put(751, "");
        atmosphereNight.put(761, "");
        atmosphereNight.put(762, "");
        atmosphereNight.put(771, "");
        atmosphereNight.put(781, "");
    }

    public static String getAtmosphereIcon(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? atmosphereDay.get(id) : atmosphereNight.get(id);
    }
}
