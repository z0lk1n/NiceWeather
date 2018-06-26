package online.z0lk1n.android.niceweather.model;

public class Sys {
    private int type;
    private int id;
    private double message;
    private String country;
    private long sunrise;
    private long sunset;

    public void setType(int type) {
        this.type = type;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setMessage(double message) {
        this.message = message;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public void setSunrise(long sunrise) {
        this.sunrise = sunrise;
    }

    public void setSunset(long sunset) {
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

    public Sys(int type, int id, double message, String country, long sunrise, long sunset) {
        this.type = type;
        this.id = id;
        this.message = message;
        this.country = country;
        this.sunrise = sunrise;
        this.sunset = sunset;
    }
}
