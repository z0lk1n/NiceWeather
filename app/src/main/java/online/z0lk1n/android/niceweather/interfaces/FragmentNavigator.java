package online.z0lk1n.android.niceweather.interfaces;

public interface FragmentNavigator {
    void showDetailWeather(String city);

    void showSettings();

    void showCitiesList();

    void setupToolbar(String name, int drawable);
}
