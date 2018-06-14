package online.z0lk1n.android.niceweather;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = findViewById(R.id.bottom_navigation);
        bottomNavigationView.setOnNavigationItemSelectedListener(
                new BottomNavigationView.OnNavigationItemSelectedListener() {
                    @Override
                    public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                        switch (item.getItemId()) {
                            case R.id.detailed_weather:
                                break;
                            case R.id.cities_list:
                                break;
                            case R.id.settings:
                                break;
                        }
                        return true;
                    }
                });
    }


//    @Override
//    public void startCitiesListFragment() {
//        if(citiesListFragment.isAdded())   {
//            return;
//        }
//        FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
//        fragmentTransaction.remove(parametersFragment);
//        fragmentTransaction.add(R.id.detail_weather, citiesListFragment);
//        fragmentTransaction.addToBackStack("");
//        fragmentTransaction.commit();
//    }
}
