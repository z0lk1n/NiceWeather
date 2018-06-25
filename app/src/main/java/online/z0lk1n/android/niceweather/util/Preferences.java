package online.z0lk1n.android.niceweather.util;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;

import online.z0lk1n.android.niceweather.ui.SettingsFragment;

public class Preferences {
    private static Preferences instance = new Preferences();
    private static SharedPreferences sharedPref;
    private static SharedPreferences.Editor editor;

    private static final String KEY_PREF_CITY = "pref_city";
    private static final String KEY_PREF_DEFAULT_CITY = "Moscow";

    private Preferences() {
    }

    @SuppressLint("CommitPrefEdits")
    public static Preferences getInstance(Context context) {
        if (sharedPref == null) {
            sharedPref = context.getSharedPreferences(context.getPackageName(),
                    Context.MODE_PRIVATE);
            editor = sharedPref.edit();
        }
        return instance;
    }

    public String getCity() {
        return sharedPref.getString(KEY_PREF_CITY, KEY_PREF_DEFAULT_CITY);
    }

    public void setCity(String city) {
        editor.putString(KEY_PREF_CITY, city).apply();
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
