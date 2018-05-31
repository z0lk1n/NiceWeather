package online.z0lk1n.android.niceweather;

import java.io.Serializable;

public class Parcel implements Serializable {
    private String cityName;
    private Boolean temperature;
    private Boolean windSpeed;
    private Boolean airHumidity;
    private Boolean pressure;

    Parcel(String cityName, Boolean temperature, Boolean windSpeed, Boolean airHumidity, Boolean pressure) {
        this.cityName = cityName;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.airHumidity = airHumidity;
        this.pressure = pressure;
    }

    public String getCityName() {
        return cityName;
    }

    public Boolean getTemperature() {
        return temperature;
    }

    public Boolean getWindSpeed() {
        return windSpeed;
    }

    public Boolean getAirHumidity() {
        return airHumidity;
    }

    public Boolean getPressure() {
        return pressure;
    }
}
