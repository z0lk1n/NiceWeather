package online.z0lk1n.android.niceweather.model;

import com.google.gson.annotations.SerializedName;

public final class Main {
    @SerializedName("temp")
    private final double temp;
    @SerializedName("pressure")
    private final int pressure;
    @SerializedName("humidity")
    private final int humidity;
    @SerializedName("temp_min")
    private final double temp_min;
    @SerializedName("temp_max")
    private final double temp_max;

    public Main(double temp, int pressure, int humidity, double temp_min, double temp_max) {
        this.temp = temp;
        this.pressure = pressure;
        this.humidity = humidity;
        this.temp_min = temp_min;
        this.temp_max = temp_max;
    }

    public double getTemp() {
        return temp;
    }

    public int getPressure() {
        return pressure;
    }

    public int getHumidity() {
        return humidity;
    }

    public double getTemp_min() {
        return temp_min;
    }

    public double getTemp_max() {
        return temp_max;
    }
}
