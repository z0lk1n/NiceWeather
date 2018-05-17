package online.z0lk1n.android.niceweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GreetingStrings {
    private String TAG;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TAG = getString(R.string.tag);
        TextView greeting = findViewById(R.id.greeting);
        BuilderGreetingPhrase greetingPhrase = new BuilderGreetingPhrase(this);
        greeting.setText(greetingPhrase.getGreetingPhrase());

        String instanceState;
        if (savedInstanceState == null)
            instanceState = getString(R.string.first_start);
        else
            instanceState = getString(R.string.second_start);

        String textState = instanceState + getString(R.string.on_create);
        Toast.makeText(getApplicationContext(), textState, Toast.LENGTH_SHORT).show();
        Log.i(TAG, textState);
    }

    @Override
    public String getWho() {
        return getResources().getString(R.string.who);
    }

    @Override
    public String getMorning() {
        return getResources().getString(R.string.morning);
    }

    @Override
    public String getAfternoon() {
        return getResources().getString(R.string.afternoon);
    }

    @Override
    public String getEvening() {
        return getResources().getString(R.string.evening);
    }

    @Override
    public String getNight() {
        return getResources().getString(R.string.night);
    }

    @Override
    protected void onStart() {
        super.onStart();
        String textState = getString(R.string.on_start);
        Toast.makeText(getApplicationContext(), textState, Toast.LENGTH_SHORT).show();
        Log.i(TAG, textState);
    }

    @Override
    protected void onStop() {
        super.onStop();
        String textState = getString(R.string.on_stop);
        Toast.makeText(getApplicationContext(), textState, Toast.LENGTH_SHORT).show();
        Log.i(TAG, textState);
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        String textState = getString(R.string.on_destroy);
        Toast.makeText(getApplicationContext(), textState, Toast.LENGTH_SHORT).show();
        Log.i(TAG, textState);
    }

    @Override
    protected void onPause() {
        super.onPause();
        String textState = getString(R.string.on_pause);
        Toast.makeText(getApplicationContext(), textState, Toast.LENGTH_SHORT).show();
        Log.i(TAG, textState);
    }

    @Override
    protected void onResume() {
        super.onResume();
        String textState = getString(R.string.on_resume);
        Toast.makeText(getApplicationContext(), textState, Toast.LENGTH_SHORT).show();
        Log.i(TAG, textState);
    }

    @Override
    protected void onRestoreInstanceState(Bundle saveInstanceState) {
        super.onRestoreInstanceState(saveInstanceState);
        String textState = getString(R.string.second_start) + getString(R.string.on_restore_state);
        Toast.makeText(getApplicationContext(), textState, Toast.LENGTH_SHORT).show();
        Log.i(TAG, textState);
    }

    @Override
    protected void onSaveInstanceState(Bundle saveInstanceState) {
        super.onSaveInstanceState(saveInstanceState);
        String textState = getString(R.string.on_save_state);
        Toast.makeText(getApplicationContext(), textState, Toast.LENGTH_SHORT).show();
        Log.i(TAG, textState);
    }
}
