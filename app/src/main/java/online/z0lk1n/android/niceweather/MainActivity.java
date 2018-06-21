package online.z0lk1n.android.niceweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import online.z0lk1n.android.niceweather.fragments.CitiesListFragment;
import online.z0lk1n.android.niceweather.fragments.DetailWeatherFragment;
import online.z0lk1n.android.niceweather.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity {
    DetailWeatherFragment detailWeatherFragment;
    SettingsFragment settingsFragment;
    CitiesListFragment citiesListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        if (getSupportActionBar() != null) {
            getSupportActionBar().setDisplayHomeAsUpEnabled(true);
            getSupportActionBar().setDisplayShowHomeEnabled(true);
        }

        if (savedInstanceState == null) {
            showDetailWeather();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                showCitiesList();
                return true;
            case R.id.action_settings:
                showSettings();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }


    private void showDetailWeather() {
        detailWeatherFragment = (DetailWeatherFragment) getFragmentManager()
                .findFragmentByTag(DetailWeatherFragment.NAME);

        if (detailWeatherFragment == null) {
            detailWeatherFragment = DetailWeatherFragment.create("CITY");
        }

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, detailWeatherFragment, DetailWeatherFragment.NAME)
                .commit();
    }

    private void showSettings() {
        settingsFragment = (SettingsFragment) getFragmentManager()
                .findFragmentByTag(SettingsFragment.NAME);

        if (settingsFragment == null) {
            settingsFragment = new SettingsFragment();
        }

        if (settingsFragment.isAdded()) {
            return;
        }

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, settingsFragment, SettingsFragment.NAME)
                .addToBackStack(null).commit();
    }

    private void showCitiesList() {
        citiesListFragment = (CitiesListFragment) getFragmentManager()
                .findFragmentByTag(CitiesListFragment.NAME);

        if (citiesListFragment == null) {
            citiesListFragment = new CitiesListFragment();
        }

        if (citiesListFragment.isAdded()) {
            return;
        }

        getFragmentManager()
                .beginTransaction()
                .replace(R.id.fragment_container, citiesListFragment, CitiesListFragment.NAME)
                .addToBackStack(null).commit();
    }
}