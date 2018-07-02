package online.z0lk1n.android.niceweather.model;

import com.google.gson.annotations.SerializedName;

public final class Coord {
    @SerializedName("lon")
    private final double lon;
    @SerializedName("lat")
    private final double lat;

    public Coord(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }
}
