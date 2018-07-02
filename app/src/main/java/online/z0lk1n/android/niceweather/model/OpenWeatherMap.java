package online.z0lk1n.android.niceweather.model;

import com.google.gson.annotations.SerializedName;

public final class OpenWeatherMap {
    @SerializedName("coord")
    private final Coord coord;
    @SerializedName("weather")
    private final Weather[] weather;
    @SerializedName("base")
    private final String base;
    @SerializedName("main")
    private final Main main;
    @SerializedName("visibility")
    private final int visibility;
    @SerializedName("wind")
    private final Wind wind;
    @SerializedName("clouds")
    private final Clouds clouds;
    @SerializedName("dt")
    private final long dt;
    @SerializedName("sys")
    private final Sys sys;
    @SerializedName("id")
    private final int id;
    @SerializedName("name")
    private final String name;
    @SerializedName("cod")
    private final int cod;

    public OpenWeatherMap(Coord coord,
                          Weather[] weather,
                          String base,
                          Main main,
                          int visibility,
                          Wind wind,
                          Clouds clouds,
                          long dt,
                          Sys sys,
                          int id,
                          String name,
                          int cod) {
        this.coord = coord;
        this.weather = weather;
        this.base = base;
        this.main = main;
        this.visibility = visibility;
        this.wind = wind;
        this.clouds = clouds;
        this.dt = dt;
        this.sys = sys;
        this.id = id;
        this.name = name;
        this.cod = cod;
    }

    public Coord getCoord() {
        return coord;
    }

    public Weather[] getWeather() {
        return weather;
    }

    public String getBase() {
        return base;
    }

    public Main getMain() {
        return main;
    }

    public int getVisibility() {
        return visibility;
    }

    public Wind getWind() {
        return wind;
    }

    public Clouds getClouds() {
        return clouds;
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
}
