package online.z0lk1n.android.niceweather;

import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import online.z0lk1n.android.niceweather.fragments.DetailWeatherFragment;
import online.z0lk1n.android.niceweather.fragments.SettingsFragment;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {
    DetailWeatherFragment detailWeatherFragment;
    SettingsFragment settingsFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.addDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);

        if (savedInstanceState == null) {
            showDetailWeather();
        }
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
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
            case R.id.action_settings:
                showSettings();
                return true;
        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.nav_camera:
                return true;
            case R.id.nav_gallery:
                return true;
        }
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }

    private void showDetailWeather() {
        detailWeatherFragment = (DetailWeatherFragment) getFragmentManager()
                .findFragmentByTag(DetailWeatherFragment.NAME);

        if (detailWeatherFragment == null) {
            detailWeatherFragment = new DetailWeatherFragment();
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
}