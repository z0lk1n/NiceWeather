package online.z0lk1n.android.niceweather;

public interface FragmentNavigator {
    void startDetailedWeatherFragment(Parcel parcel);
    void startCitiesListFragment();
    void startParametersFragment(String city);
}
