package online.z0lk1n.android.niceweather.model;

import com.google.gson.annotations.SerializedName;

public final class Weather {
    @SerializedName("id")
    private final int id;
    @SerializedName("main")
    private final String main;
    @SerializedName("description")
    private final String description;
    @SerializedName("icon")
    private final String icon;

    public Weather(int id, String main, String description, String icon) {
        this.id = id;
        this.main = main;
        this.description = description;
        this.icon = icon;
    }

    public int getId() {
        return id;
    }

    public String getMain() {
        return main;
    }

    public String getDescription() {
        return description;
    }

    public String getIcon() {
        return icon;
    }
}
