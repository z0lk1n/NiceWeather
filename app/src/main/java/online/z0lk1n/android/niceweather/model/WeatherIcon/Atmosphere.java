package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseIntArray;

public class Atmosphere {
    private final static SparseIntArray atmosphereDay = new SparseIntArray();
    private final static SparseIntArray atmosphereNight = new SparseIntArray();

    static {
        atmosphereDay.put(701, 0);
        atmosphereDay.put(711, 0);
        atmosphereDay.put(721, 0);
        atmosphereDay.put(731, 0);
        atmosphereDay.put(741, 0);
        atmosphereDay.put(751, 0);
        atmosphereDay.put(761, 0);
        atmosphereDay.put(762, 0);
        atmosphereDay.put(771, 0);
        atmosphereDay.put(781, 0);

        atmosphereNight.put(701, 0);
        atmosphereNight.put(711, 0);
        atmosphereNight.put(721, 0);
        atmosphereNight.put(731, 0);
        atmosphereNight.put(741, 0);
        atmosphereNight.put(751, 0);
        atmosphereNight.put(761, 0);
        atmosphereNight.put(762, 0);
        atmosphereNight.put(771, 0);
        atmosphereNight.put(781, 0);
    }

    public static int getAtmosphereIconId(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? atmosphereDay.get(id) : atmosphereNight.get(id);
    }
}
