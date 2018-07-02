package online.z0lk1n.android.niceweather.model;

import com.google.gson.annotations.SerializedName;

public final class Clouds {
    @SerializedName("all")
    private final int all;

    public Clouds(int all) {
        this.all = all;
    }

    public int getAll() {
        return all;
    }
}
