package online.z0lk1n.android.niceweather;

import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity implements FragmentNavigator {
    private ParametersFragment parametersFragment;
    private DetailedWeatherFragment detailedWeatherActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        parametersFragment = new ParametersFragment();
        detailedWeatherActivity = new DetailedWeatherFragment();

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
}
