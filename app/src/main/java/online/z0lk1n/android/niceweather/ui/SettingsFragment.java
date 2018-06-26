package online.z0lk1n.android.niceweather.ui;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.Preference;
import android.preference.PreferenceFragment;
import android.preference.SwitchPreference;
import android.support.annotation.Nullable;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;

import online.z0lk1n.android.niceweather.FragmentNavigator;
import online.z0lk1n.android.niceweather.R;
import online.z0lk1n.android.niceweather.util.Preferences;

public class SettingsFragment extends PreferenceFragment implements SharedPreferences.OnSharedPreferenceChangeListener {
    public static final String NAME = "77cc223a-5414-401f-8d3e-810bcb1bcfd7";
    public static final String KEY_PREF_TEMPERATURE = "eed0dedb-f4ca-480d-8f10-7d24c60866c8";
    public static final String KEY_PREF_WIND_SPEED = "87957712-0eb6-4ede-8572-f4d97b787e00";
    public static final String KEY_PREF_PRESSURE = "bce0b14c-9ad9-4595-a2fd-5d90ce17cf97";
    public static final String KEY_PREF_RATE_APP = "d6560152-8716-41ff-bdd1-69d92f17c9b0";
    public static final String KEY_PREF_ABOUT = "47b7aaa5-3dae-4157-8977-855f01ad8886";

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
        setupToolbar();
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
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_settings, menu);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getFragmentManager().popBackStack();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setupToolbar() {
        setHasOptionsMenu(true);
        FragmentNavigator fragmentNavigator = (FragmentNavigator)getActivity();
        fragmentNavigator.setupToolbar(getResources().getString(R.string.settings),
                R.drawable.ic_toolbar_cursor);
    }
}