package online.z0lk1n.android.niceweather;

import java.io.Serializable;

public class Parcel implements Serializable {
        private int imageIndex;
        private String cityName;
        private String temperature;
        private String windSpeed;
        private String airHumidity;
        private String pressure;

    public Parcel(int imageIndex, String cityName, String temperature, String windSpeed, String airHumidity, String pressure) {
        this.imageIndex = imageIndex;
        this.cityName = cityName;
        this.temperature = temperature;
        this.windSpeed = windSpeed;
        this.airHumidity = airHumidity;
        this.pressure = pressure;
    }

    public int getImageIndex() {
        return imageIndex;
    }

    public String getCityName() {
        return cityName;
    }

    public String getTemperature() {
        return temperature;
    }

    public String getWindSpeed() {
        return windSpeed;
    }

    public String getAirHumidity() {
        return airHumidity;
    }

    public String getPressure() {
        return pressure;
    }
}
