package online.z0lk1n.android.niceweather;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

import online.z0lk1n.android.niceweather.fragments.CitiesListFragment;
import online.z0lk1n.android.niceweather.fragments.DetailedWeatherFragment;
import online.z0lk1n.android.niceweather.fragments.FragmentNavigator;
import online.z0lk1n.android.niceweather.fragments.ParametersFragment;
import online.z0lk1n.android.niceweather.util.Parcel;

public class MainActivity extends AppCompatActivity implements FragmentNavigator {

    private ParametersFragment parametersFragment;
    private DetailedWeatherFragment detailedWeatherActivity;
    private CitiesListFragment citiesListFragment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parametersFragment = new ParametersFragment();
        detailedWeatherActivity = new DetailedWeatherFragment();
        citiesListFragment = new CitiesListFragment();
        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, parametersFragment);
        fragmentTransaction.commit();

        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.detailed_weather:
//                                Parcel parcel = new Parcel();
//                                startDetailedWeatherFragment(parcel);
                                break;
                            case R.id.cities_list:
                                startCitiesListFragment();
                                break;
                            case R.id.settings:
                                break;
                        }
                        return true;
                    }
                });
    }

    @Override
    public void startDetailedWeatherFragment(Parcel parcel) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.remove(parametersFragment);
        fragmentTransaction.add(R.id.fragment_container, detailedWeatherActivity);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();
        detailedWeatherActivity.setParcel(parcel);
    }

    @Override
    public void startCitiesListFragment() {
        if(citiesListFragment.isAdded())   {
            return;
        }
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.remove(parametersFragment);
        fragmentTransaction.add(R.id.fragment_container, citiesListFragment);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();
    }

    @Override
    public void startCitiesListFragment(String city) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.remove(parametersFragment);
        fragmentTransaction.add(R.id.fragment_container, citiesListFragment);
        fragmentTransaction.addToBackStack("");
        fragmentTransaction.commit();
        citiesListFragment.setCity(city);
    }

    @Override
    public void startParametersFragment(String city) {
        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.remove(citiesListFragment);
        fragmentTransaction.replace(R.id.fragment_container, parametersFragment);
        fragmentTransaction.commit();
        parametersFragment.setCity(city);
    }
}
