package online.z0lk1n.android.niceweather;

import android.app.Activity;
import android.os.Bundle;

import static android.content.res.Configuration.ORIENTATION_LANDSCAPE;

public class InfoActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        if (getResources().getConfiguration().orientation == ORIENTATION_LANDSCAPE) {
            finish();
            return;
        }

        if (savedInstanceState == null) {
            InfoFragment details = new InfoFragment();
            details.setArguments(getIntent().getExtras());
            getFragmentManager().beginTransaction().add(android.R.id.content, details).commit();
        }
    }
}
