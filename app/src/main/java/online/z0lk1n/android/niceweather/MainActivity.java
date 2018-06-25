package online.z0lk1n.android.niceweather;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import online.z0lk1n.android.niceweather.ui.CitiesListFragment;
import online.z0lk1n.android.niceweather.ui.DetailWeatherFragment;
import online.z0lk1n.android.niceweather.ui.SettingsFragment;
import online.z0lk1n.android.niceweather.util.Preferences;

public class MainActivity extends AppCompatActivity implements FragmentNavigator,
        MenuItem.OnActionExpandListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        ActionBar actionBar = getSupportActionBar();
        if (actionBar != null) {
            actionBar.setDisplayHomeAsUpEnabled(true);
            actionBar.setDisplayShowHomeEnabled(true);
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
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void showDetailWeather() {
        DetailWeatherFragment detailWeatherFragment = (DetailWeatherFragment) getFragmentManager()
                .findFragmentByTag(DetailWeatherFragment.NAME);

        if (detailWeatherFragment == null) {
            detailWeatherFragment = new DetailWeatherFragment();
        }

        getFragmentManager()
                .beginTransaction()
                .add(R.id.fragment_container, detailWeatherFragment, DetailWeatherFragment.NAME)
                .commit();
    }

    @Override
    public void showDetailWeather(String city) {
        Preferences preferences = Preferences.getInstance(this);

        DetailWeatherFragment detailWeatherFragment =
                (DetailWeatherFragment) getFragmentManager()
                        .findFragmentByTag(DetailWeatherFragment.NAME);

        if (detailWeatherFragment == null || !city.equals(preferences.getCity())) {
            preferences.setCity(city);
            detailWeatherFragment = new DetailWeatherFragment();

            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, detailWeatherFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        }
    }

    @Override
    public void showSettings() {
        SettingsFragment settingsFragment = (SettingsFragment) getFragmentManager()
                .findFragmentByTag(SettingsFragment.NAME);

        if (settingsFragment != null && settingsFragment.isAdded()) {
            getFragmentManager()
                    .beginTransaction()
                    .show(settingsFragment)
                    .commit();
        } else {
            settingsFragment = new SettingsFragment();
            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, settingsFragment, SettingsFragment.NAME)
                    .addToBackStack(null).commit();
        }
    }

    @Override
    public void showCitiesList() {
        CitiesListFragment citiesListFragment = (CitiesListFragment) getFragmentManager()
                .findFragmentByTag(CitiesListFragment.NAME);

        if (citiesListFragment != null && citiesListFragment.isAdded()) {
            getFragmentManager()
                    .beginTransaction()
                    .show(citiesListFragment)
                    .commit();
        } else {
            citiesListFragment = new CitiesListFragment();

            getFragmentManager()
                    .beginTransaction()
                    .replace(R.id.fragment_container, citiesListFragment, CitiesListFragment.NAME)
                    .addToBackStack(null).commit();
        }
    }

    @Override
    public void backToDetailWeather() {
//        DetailWeatherFragment detailWeatherFragment = (DetailWeatherFragment) getFragmentManager()
//                .findFragmentByTag(DetailWeatherFragment.NAME);
//
//        if (detailWeatherFragment != null && detailWeatherFragment.isAdded()) {
//            getFragmentManager()
//                    .beginTransaction()
//                    .show(detailWeatherFragment)
//                    .commit();
//        } else {
//            detailWeatherFragment = new DetailWeatherFragment();
//            getFragmentManager()
//                    .beginTransaction()
//                    .replace(R.id.fragment_container, detailWeatherFragment, SettingsFragment.NAME)
//                    .commit();
//        }
        getFragmentManager().popBackStack();
    }

    @Override
    public boolean onMenuItemActionExpand(MenuItem item) {
        return false;
    }

    @Override
    public boolean onMenuItemActionCollapse(MenuItem item) {
        return false;
    }
}

/*
TODO 1.Сделать корректный переход назад с доп. фрагментов
TODO 2.Доделать тему приложения
TODO 3.Добавить к свичам текстовое описание
TODO 4.Добавить фрагмент с правами на иконки
TODO 5.Добавить фрагмент о разработчике
TODO 6.Добавить открытие гуглплея для оценки приложения
TODO 7.Добавить в список городов кнопку добавления
TODO 8.Добавить в список городов контекстное меню с удалением
 */