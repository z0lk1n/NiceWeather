package online.z0lk1n.android.niceweather;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;

import online.z0lk1n.android.niceweather.fragments.DetailWeatherFragment;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class DetailWeatherActivity extends Activity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        if (savedInstanceState == null) {
            DetailWeatherFragment details = new DetailWeatherFragment();
            details.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
        }
    }
}
