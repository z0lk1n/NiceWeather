package online.z0lk1n.android.niceweather.model.WeatherIcon;

import online.z0lk1n.android.niceweather.R;

public class Clear {
    private static final int DAY_SUNNY = R.string.wi_day_sunny;
    private static final int NIGHT_CLEAR = R.string.wi_night_clear;

    public static int getClearIconId(PartOfDay partOfDay) {
        return (partOfDay == PartOfDay.Daytime) ? DAY_SUNNY : NIGHT_CLEAR;
    }
}
