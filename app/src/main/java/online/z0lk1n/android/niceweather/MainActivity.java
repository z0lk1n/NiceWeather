package online.z0lk1n.android.niceweather;

import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;

import java.util.Objects;

import online.z0lk1n.android.niceweather.ui.CitiesListFragment;
import online.z0lk1n.android.niceweather.ui.DetailWeatherFragment;
import online.z0lk1n.android.niceweather.ui.FragmentNavigator;
import online.z0lk1n.android.niceweather.ui.SettingsFragment;
import online.z0lk1n.android.niceweather.util.Preferences;

public class MainActivity extends AppCompatActivity implements FragmentNavigator {
    Toolbar toolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        toolbar = findViewById(R.id.toolbar);

        if (savedInstanceState == null) {
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.fragment_container, new DetailWeatherFragment(), DetailWeatherFragment.NAME)
                    .commit();
        }
    }

    @Override
    public void showDetailWeather(String city) {
        Preferences preferences = Preferences.getInstance(this);
        FragmentManager fragmentManager = getFragmentManager();

        DetailWeatherFragment detailWeatherFragment = (DetailWeatherFragment) fragmentManager
                .findFragmentByTag(DetailWeatherFragment.NAME);

        if (!city.equals(preferences.getCity())) {
            preferences.setCity(city);
        }

        fragmentManager
                .beginTransaction()
                .show(detailWeatherFragment)
                .commit();

        fragmentManager.popBackStack();
    }

    @Override
    public void showSettings() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new SettingsFragment(), SettingsFragment.NAME)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void showCitiesList() {
        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, new CitiesListFragment(), CitiesListFragment.NAME)
                .addToBackStack(null)
                .commit();
    }

    @Override
    public void setupToolbar(String name, int drawable) {
        setSupportActionBar(toolbar);
        Objects.requireNonNull(getSupportActionBar()).setTitle(name);
        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setHomeAsUpIndicator(drawable);
            actionBar.setElevation(0);
        }
    }
}

/*
TODO 2.Доделать тему приложения
TODO 3.Добавить к свичам текстовое описание
TODO 8.Добавить в список городов контекстное меню с удалением
TODO 9.Поменять префы
 */