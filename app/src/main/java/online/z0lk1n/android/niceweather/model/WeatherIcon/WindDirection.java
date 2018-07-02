package online.z0lk1n.android.niceweather.model.WeatherIcon;

import online.z0lk1n.android.niceweather.R;

public final class WindDirection {
    private final static int[] windDirection = new int[8];

    static {
        windDirection[0] = R.string.wi_direction_up;
        windDirection[1] = R.string.wi_direction_up_right;
        windDirection[2] = R.string.wi_direction_right;
        windDirection[3] = R.string.wi_direction_down_right;
        windDirection[4] = R.string.wi_direction_down;
        windDirection[5] = R.string.wi_direction_down_left;
        windDirection[6] = R.string.wi_direction_left;
        windDirection[7] = R.string.wi_direction_up_left;
    }

    public static int getWindDirectionIconId(int value) {
        return windDirection[value];
    }
}