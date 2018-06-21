package online.z0lk1n.android.niceweather.fragments;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.support.annotation.Nullable;

import online.z0lk1n.android.niceweather.R;

public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final String NAME = "SettingsFragment";
    public static final String KEY_PREF_WIND_SPEED = "pref_windSpeed";
    public static final String KEY_PREF_AIR_HUMIDITY = "pref_airHumidity";
    public static final String KEY_PREF_PRESSURE = "pref_pressure";

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
    }

    @Override
    public void onResume() {
        super.onResume();
        getPreferenceScreen().getSharedPreferences()
                .registerOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onPause() {
        super.onPause();
        getPreferenceScreen().getSharedPreferences()
                .unregisterOnSharedPreferenceChangeListener(this);
    }

    @Override
    public void onSharedPreferenceChanged(SharedPreferences sharedPreferences, String key) {
        switch (key) {
            case KEY_PREF_WIND_SPEED:
                Preference windSpeedPref = findPreference(key);
                windSpeedPref.setSummary(sharedPreferences.getString(key, ""));
                break;
            case KEY_PREF_AIR_HUMIDITY:
                Preference airHumidityPref = findPreference(key);
                airHumidityPref.setSummary(sharedPreferences.getString(key, ""));
                break;
            case KEY_PREF_PRESSURE:
                Preference pressurePref = findPreference(key);
                pressurePref.setSummary(sharedPreferences.getString(key, ""));
                break;
            default:
                break;
        }
    }
}
//        citiesListBtn.setOnClickListener(new View.OnClickListener() {
//@Override
//public void onClick(View view) {
//        FragmentNavigator fragmentNavigator = (FragmentNavigator) that;
//        fragmentNavigator.startCitiesListFragment();
//        }
//        });