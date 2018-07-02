package online.z0lk1n.android.niceweather.model;

import com.google.gson.annotations.SerializedName;

public final class Wind {
    @SerializedName("speed")
    private final double speed;
    @SerializedName("deg")
    private final double deg;

    public Wind(double speed, double deg) {
        this.speed = speed;
        this.deg = deg;
    }

    public double getSpeed() {
        return speed;
    }

    public double getDeg() {
        return deg;
    }
}
