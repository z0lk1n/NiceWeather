package online.z0lk1n.android.niceweather.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import android.support.annotation.Nullable;
import android.view.MenuItem;

import online.z0lk1n.android.niceweather.R;
import online.z0lk1n.android.niceweather.util.Preferences;

public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final String NAME = "SettingsFragment";
    public static final String KEY_PREF_TEMPERATURE = "pref_temperature";
    public static final String KEY_PREF_WIND_SPEED = "pref_windSpeed";
    public static final String KEY_PREF_PRESSURE = "pref_pressure";
    public static final String KEY_PREF_RATE_APP = "pref_rateApp";
    public static final String KEY_PREF_ABOUT = "pref_about";

    private Preferences preferences;
    private SwitchPreference prefTemperature;
    private SwitchPreference prefWindSpeed;
    private SwitchPreference prefPressure;
    private Preference prefRateApp;
    private Preference prefAbout;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        addPreferencesFromResource(R.xml.preferences);
        setHasOptionsMenu(true);
        prefTemperature = (SwitchPreference) findPreference(KEY_PREF_TEMPERATURE);
        prefWindSpeed = (SwitchPreference) findPreference(KEY_PREF_WIND_SPEED);
        prefPressure = (SwitchPreference) findPreference(KEY_PREF_PRESSURE);
        prefRateApp = findPreference(KEY_PREF_RATE_APP);
        prefAbout = findPreference(KEY_PREF_ABOUT);
        preferences = Preferences.getInstance(getActivity());
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
            case KEY_PREF_TEMPERATURE:
                preferences.setTemperature(prefTemperature.isChecked());
                break;
            case KEY_PREF_WIND_SPEED:
                preferences.setWindSpeed(prefWindSpeed.isChecked());
                break;
            case KEY_PREF_PRESSURE:
                preferences.setPressure(prefPressure.isChecked());
                break;
            case KEY_PREF_RATE_APP:

                break;
            case KEY_PREF_ABOUT:

                break;
            default:
                break;
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}