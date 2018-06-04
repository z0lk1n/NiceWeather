package online.z0lk1n.android.niceweather;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

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

        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
        fragmentTransaction.add(R.id.fragment_container, parametersFragment);
        fragmentTransaction.commit();
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
