package online.z0lk1n.android.niceweather.model;

import java.util.List;

public class OpenWeatherMap {
    private Coord coord;
    private List<Weather> weatherList;
    private String base;
    private Main main;
    private Wind wind;
    private Clouds clouds;
    private Rain rain;
    private int dt;
    private Sys sys;
    private int id;
    private String name;
    private int cod;

    public OpenWeatherMap() {
    }

    public OpenWeatherMap(Coord coord, List<Weather> weatherList, String base, Main main, Wind wind, Clouds clouds, Rain rain, int dt, Sys sys, int id, String name, int cod) {
        this.coord = coord;
        this.weatherList = weatherList;
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

    public List<Weather> getWeatherList() {
        return weatherList;
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

    public int getDt() {
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

    public void setWeatherList(List<Weather> weatherList) {
        this.weatherList = weatherList;
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

    public void setDt(int dt) {
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
