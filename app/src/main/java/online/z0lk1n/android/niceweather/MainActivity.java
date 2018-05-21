package online.z0lk1n.android.niceweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements GreetingStrings {
    private static final String TAG = MainActivity.class.getSimpleName();
    public static final String CITY = "city";
    public static final String OPTIONAL = "optional";
    private TextView textView;
    private Spinner spinner;
    private boolean[] checkBoxArr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView greeting = findViewById(R.id.greeting);
        BuilderGreetingPhrase greetingPhrase = new BuilderGreetingPhrase(this);
        greeting.setText(greetingPhrase.getGreetingPhrase());

        textView = findViewById(R.id.temperature);
        Button button = findViewById(R.id.button_show_temperature);
        button.setOnClickListener(onClickListener);
        spinner = findViewById(R.id.spinner_for_part_day);

        final EditText textCity = findViewById(R.id.editText_enter_city);
        final CheckBox checkBoxAirHumidity = findViewById(R.id.checkBox_air_humidity);
        final CheckBox checkBoxWindSpeed = findViewById(R.id.checkBox_wind_speed);
        final CheckBox checkBoxPressure = findViewById(R.id.checkBox_pressure);
        checkBoxArr = new boolean[3];
        final Button buttonSend = findViewById(R.id.button_send_parameters);
        buttonSend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(CITY, textCity.getText().toString());

                if(checkBoxAirHumidity.isChecked()) {
                    checkBoxArr[0] = true;
                }
                if(checkBoxWindSpeed.isChecked()) {
                    checkBoxArr[1] = true;
                }
                if(checkBoxPressure.isChecked()) {
                    checkBoxArr[2] = true;
                }
                intent.putExtra(OPTIONAL, checkBoxArr);

                startActivity(intent);
            }
        });

        String instanceState;
        if (savedInstanceState == null)
            instanceState = getString(R.string.first_start);
        else
            instanceState = getString(R.string.second_start);

        String textState = instanceState + getString(R.string.on_create);
        Toast.makeText(getApplicationContext(), textState, Toast.LENGTH_SHORT).show();
        Log.i(TAG, textState);
    }

    private final View.OnClickListener onClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View view) {
            if(view.getId() == R.id.button_show_temperature)    {
                textView.setText(TemperatureSpec.getTemperature(getApplicationContext(),
                        spinner.getSelectedItemPosition()));
            }
        }
    };

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
