package online.z0lk1n.android.niceweather.model.WeatherIcon;

import online.z0lk1n.android.niceweather.R;

public final class Clear {
    private final static int DAY_SUNNY = R.string.wi_owm_day_800;
    private final static int NIGHT_CLEAR = R.string.wi_owm_night_800;

    public static int getClearIconId(PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? DAY_SUNNY : NIGHT_CLEAR;
    }
}
