package online.z0lk1n.android.niceweather;

public interface FragmentNavigator {
    void showDetailWeather();
    void showDetailWeather(String city);
    void showSettings();
    void showCitiesList();
    void backToDetailWeather();
}
