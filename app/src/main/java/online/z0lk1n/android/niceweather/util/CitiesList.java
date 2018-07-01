package online.z0lk1n.android.niceweather.util;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class CitiesList {
    private List<String> cities;

    public CitiesList() {
        this.cities = new ArrayList<>(Arrays.asList(
                "Nizhnevartovsk", "Moscow", "Saint Petersburg", "Sochi", "Omsk"));
    }

    public List<String> getCities() {
        return cities;
    }

    public void setCity(String city) {
        this.cities.add(0, city);
    }

    public void removeCity(int city) {
        this.cities.remove(city);
    }
}
