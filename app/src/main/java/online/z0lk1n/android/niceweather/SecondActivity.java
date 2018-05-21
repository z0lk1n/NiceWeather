package online.z0lk1n.android.niceweather;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class SecondActivity extends AppCompatActivity {
    public static final String CITY = "city";
    public static final String OPTIONAL = "optional";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        TextView textViewCity = findViewById(R.id.textView_city);
        TextView textViewTemperature = findViewById(R.id.textView_temperature);

        TextView textViewLabelAirHumidity = findViewById(R.id.textView_label_air_humidity);
        TextView textViewAirHumidity = findViewById(R.id.textView_air_humidity);

        TextView textViewLabelWindSpeed = findViewById(R.id.textView_label_wind_speed);
        TextView textViewWindSpeed = findViewById(R.id.textView_wind_speed);

        TextView textViewLabelPressure = findViewById(R.id.textView_label_pressure);
        TextView textViewPressure = findViewById(R.id.textView_pressure);

        String textCity = getIntent().getExtras().getString(CITY);
        boolean[] checkBoxArr = getIntent().getExtras().getBooleanArray(OPTIONAL);

        if(!textCity.isEmpty()) {
            textViewCity.setText(textCity);
            textViewTemperature.setText(R.string.test_temperature);
        }

        if(checkBoxArr[0])   {
            textViewLabelAirHumidity.setText(R.string.air_humidity);
            textViewAirHumidity.setText(R.string.test_air_humidity);
        }
        if(checkBoxArr[1])   {
            textViewLabelWindSpeed.setText(R.string.wind_speed);
            textViewWindSpeed.setText(R.string.test_wind_speed);
        }
        if(checkBoxArr[2])   {
            textViewLabelPressure.setText(R.string.pressure);
            textViewPressure.setText(R.string.test_pressure);
        }
    }
}
