package online.z0lk1n.android.niceweather.fragments;

import online.z0lk1n.android.niceweather.util.Parcel;

public interface FragmentNavigator {
    void startDetailedWeatherFragment(Parcel parcel);
    void startCitiesListFragment();
    void startCitiesListFragment(String city);
    void startParametersFragment(String city);
}
