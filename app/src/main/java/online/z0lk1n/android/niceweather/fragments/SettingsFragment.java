package online.z0lk1n.android.niceweather.fragments;

import android.os.Bundle;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

import online.z0lk1n.android.niceweather.R;

public class SettingsFragment extends PreferenceFragment {
    public static final String KEY_PREF_WIND_SPEED = "pref_windSpeed";
    public static final String KEY_PREF_AIR_HUMIDITY = "pref_airHumidity";
    public static final String KEY_PREF_PRESSURE = "pref_pressure";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }
}
