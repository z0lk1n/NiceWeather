package online.z0lk1n.android.niceweather.util;

import android.content.Context;
import android.content.SharedPreferences;

import online.z0lk1n.android.niceweather.ui.SettingsFragment;

public class Preferences {
    private SharedPreferences sharedPref;
    private SharedPreferences.Editor editor;

    public Preferences(Context context) {
        sharedPref = context.getSharedPreferences(context.getPackageName(), Context.MODE_PRIVATE);
        editor = sharedPref.edit();
    }

    public String getCity() {
        return sharedPref.getString(Const.PREF_KEY_CITY, Const.PREF_DEFAULT_CITY);
    }

    public void setCity(String city) {
        editor.putString(Const.PREF_KEY_CITY, city).apply();
    }

    public boolean isTemperature() {
        return sharedPref.getBoolean(SettingsFragment.KEY_PREF_TEMPERATURE, false);
    }

    public void setTemperature(boolean temp) {
        editor.putBoolean(SettingsFragment.KEY_PREF_TEMPERATURE, temp).apply();
    }

    public boolean isWindSpeed() {
        return sharedPref.getBoolean(SettingsFragment.KEY_PREF_WIND_SPEED, false);
    }

    public void setWindSpeed(boolean wind) {
        editor.putBoolean(SettingsFragment.KEY_PREF_WIND_SPEED, wind).apply();
    }

    public boolean isPressure() {
        return sharedPref.getBoolean(SettingsFragment.KEY_PREF_PRESSURE, false);
    }

    public void setPressure(boolean pressure) {
        editor.putBoolean(SettingsFragment.KEY_PREF_PRESSURE, pressure).apply();
    }
}
