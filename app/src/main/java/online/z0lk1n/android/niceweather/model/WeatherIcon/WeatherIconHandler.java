package online.z0lk1n.android.niceweather.model.WeatherIcon;

import android.content.Context;

import online.z0lk1n.android.niceweather.R;

public class WeatherIconHandler {
    private long dt;
    private long sunrise;
    private long sunset;

    public String getWeatherIcon(Context context, int id, long dt, long sunrise, long sunset) {
        this.dt = dt;
        this.sunrise = sunrise;
        this.sunset = sunset;
        String icon;

        if (id == 800) {
            icon = context.getString(Clear.getClearIconId(getPartOfDay()));
        } else if (id >= 200 && id < 300) {
            icon = context.getString(Thunderstorm.getThunderstormIconId(id, getPartOfDay()));
        } else if (id >= 300 && id < 400) {
            icon = context.getString(Drizzle.getDrizzleIconId(id, getPartOfDay()));
        } else if (id >= 500 && id < 600) {
            icon = context.getString(Rain.getRainIconId(id, getPartOfDay()));
        } else if (id >= 600 && id < 700) {
            icon = context.getString(Snow.getSnowIconId(id, getPartOfDay()));
        } else if (id >= 700 && id < 800) {
            icon = context.getString(Atmosphere.getAtmosphereIconId(id, getPartOfDay()));
        } else if (id >= 801 && id < 900) {
            icon = context.getString(Clouds.getCloudsIconId(id, getPartOfDay()));
        } else {
            icon = context.getString(R.string.wi_na);
        }

        return icon;
    }

    public String getWindDirectionIcon(Context context, double deg) {
        String icon;

        if (deg >= 23 && deg < 68) {
            icon = context.getString(WindDirection.getWindDirectionIconId(1));
        } else if (deg >= 68 && deg < 113) {
            icon = context.getString(WindDirection.getWindDirectionIconId(2));
        } else if (deg >= 113 && deg < 158) {
            icon = context.getString(WindDirection.getWindDirectionIconId(3));
        } else if (deg >= 158 && deg < 203) {
            icon = context.getString(WindDirection.getWindDirectionIconId(4));
        } else if (deg >= 203 && deg < 248) {
            icon = context.getString(WindDirection.getWindDirectionIconId(5));
        } else if (deg >= 248 && deg < 293) {
            icon = context.getString(WindDirection.getWindDirectionIconId(6));
        } else if (deg >= 293 && deg < 338) {
            icon = context.getString(WindDirection.getWindDirectionIconId(7));
        } else {
            icon = context.getString(WindDirection.getWindDirectionIconId(0));
        }

        return icon;
    }

    private PartOfDay getPartOfDay() {
        return (dt >= sunrise && dt < sunset) ? PartOfDay.Daytime : PartOfDay.Nighttime;
    }
}
