package online.z0lk1n.android.niceweather.model;

import com.google.gson.annotations.SerializedName;

public final class Sys {
    @SerializedName("type")
    private final int type;
    @SerializedName("id")
    private final int id;
    @SerializedName("message")
    private final double message;
    @SerializedName("country")
    private final String country;
    @SerializedName("sunrise")
    private final long sunrise;
    @SerializedName("sunset")
    private final long sunset;

    public Sys(int type, int id, double message, String country, long sunrise, long sunset) {
        this.type = type;
        this.id = id;
        this.message = message;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }

    public int getType() {
        return type;
    }

    public int getId() {
        return id;
    }

    public double getMessage() {
        return message;
    }

    public String getCountry() {
        return country;
    }

    public long getSunrise() {
        return sunrise;
    }

    public long getSunset() {
        return sunset;
    }
}
