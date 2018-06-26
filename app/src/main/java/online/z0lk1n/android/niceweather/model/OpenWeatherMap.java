package online.z0lk1n.android.niceweather.model;

public class OpenWeatherMap {
    private Coord coord;
    private Weather weather;
    private String base;
    private Main main;
    private Wind wind;
    private Clouds clouds;
    private Rain rain;
    private long dt;
    private Sys sys;
    private int id;
    private String name;
    private int cod;

    public OpenWeatherMap(Coord coord, Weather weather, String base, Main main, Wind wind, Clouds clouds, Rain rain, long dt, Sys sys, int id, String name, int cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.wind = wind;
        this.clouds = clouds;
        this.rain = rain;
        this.dt = dt;
        this.sys = sys;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public Coord getCoord() {
        return coord;
    }

    public Weather getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {
        return main;
    }

    public Wind getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
    }

    public Rain getRain() {
        return rain;
    }

    public long getDt() {
        return dt;
    }

    public Sys getSys() {
        return sys;
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public int getCod() {
        return cod;
    }

    public void setCoord(Coord coord) {
        this.coord = coord;
    }

    public void setWeather(Weather weather) {
        this.weather = weather;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public void setMain(Main main) {
        this.main = main;
    }

    public void setWind(Wind wind) {
        this.wind = wind;
    }

    public void setClouds(Clouds clouds) {
        this.clouds = clouds;
    }

    public void setRain(Rain rain) {
        this.rain = rain;
    }

    public void setDt(long dt) {
        this.dt = dt;
    }

    public void setSys(Sys sys) {
        this.sys = sys;
    }

    public void setId(int id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setCod(int cod) {
        this.cod = cod;
    }
}
