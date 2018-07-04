package online.z0lk1n.android.niceweather.model;

import com.google.gson.annotations.SerializedName;

public final class Coord {
    @SerializedName("lon")
    private final float lon;
    @SerializedName("lat")
    private final float lat;

    public Coord(float lon, float lat) {
        this.lon = lon;
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public float getLat() {
        return lat;
    }
}
