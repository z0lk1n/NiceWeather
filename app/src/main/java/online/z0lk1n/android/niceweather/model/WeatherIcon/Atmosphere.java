package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.util.SparseIntArray;

import online.z0lk1n.android.niceweather.R;

public class Atmosphere {
    private final static SparseIntArray atmosphereDay = new SparseIntArray();
    private final static SparseIntArray atmosphereNight = new SparseIntArray();

    static {
        atmosphereDay.put(701, R.string.wi_smoke);
        atmosphereDay.put(711, R.string.wi_smoke);
        atmosphereDay.put(721, R.string.wi_smoke);
        atmosphereDay.put(731, R.string.wi_smoke);
        atmosphereDay.put(741, R.string.wi_smoke);
        atmosphereDay.put(751, R.string.wi_smoke);
        atmosphereDay.put(761, R.string.wi_smoke);
        atmosphereDay.put(762, R.string.wi_smoke);
        atmosphereDay.put(771, R.string.wi_smoke);
        atmosphereDay.put(781, R.string.wi_smoke);

        atmosphereNight.put(701, R.string.wi_smoke);
        atmosphereNight.put(711, R.string.wi_smoke);
        atmosphereNight.put(721, R.string.wi_smoke);
        atmosphereNight.put(731, R.string.wi_smoke);
        atmosphereNight.put(741, R.string.wi_smoke);
        atmosphereNight.put(751, R.string.wi_smoke);
        atmosphereNight.put(761, R.string.wi_smoke);
        atmosphereNight.put(762, R.string.wi_smoke);
        atmosphereNight.put(771, R.string.wi_smoke);
        atmosphereNight.put(781, R.string.wi_smoke);
    }

    public static int getAtmosphereIconId(int id, PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? atmosphereDay.get(id) : atmosphereNight.get(id);
    }
}
