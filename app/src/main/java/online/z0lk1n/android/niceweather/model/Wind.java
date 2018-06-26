package online.z0lk1n.android.niceweather.model;

public class Wind {
    private double speed;
    private double deg;

    public double getSpeed() {
        return speed;
    }

    public double getDeg() {
        return deg;
    }

    public void setSpeed(double speed) {
        this.speed = speed;
    }

    public void setDeg(double deg) {
        this.deg = deg;
    }

    public Wind(double speed, double deg) {
        this.speed = speed;
        this.deg = deg;
    }
}
