package online.z0lk1n.android.niceweather.model;

public class Coord {
    private double lon;
    private double lat;

    public void setLon(double lon) {
        this.lon = lon;
    }

    public void setLat(double lat) {
        this.lat = lat;
    }

    public double getLon() {
        return lon;
    }

    public double getLat() {
        return lat;
    }

    public Coord(double lon, double lat) {
        this.lon = lon;
        this.lat = lat;
    }
}
