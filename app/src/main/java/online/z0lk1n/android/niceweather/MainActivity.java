package online.z0lk1n.android.niceweather;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

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
}
