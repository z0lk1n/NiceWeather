package online.z0lk1n.android.niceweather.fragments;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import online.z0lk1n.android.niceweather.R;

import static android.content.Context.SENSOR_SERVICE;

public class DetailWeatherFragment extends Fragment {
    public static final String NAME = "DetailWeatherFragment";
    public static final String CITY = "CurrentCity";

    private SensorManager sensorManager;
    private Sensor sensorTemperature;
    private Sensor sensorHumidity;
    private TextView temperatureView;
    private TextView airHumidityView;

    public static DetailWeatherFragment create(String city) {
        DetailWeatherFragment fragment = new DetailWeatherFragment();
        Bundle args = new Bundle();
        args.putString(CITY, city);
        fragment.setArguments(args);
        return fragment;
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_detail_weather, container, false);

        TextView cityTxtView = layout.findViewById(R.id.txtView_city);

        temperatureView = layout.findViewById(R.id.txtView_temperature);
        TextView temperatureUnitView = layout.findViewById(R.id.txtView_temperature_unit);
        ImageView weatherImage = layout.findViewById(R.id.imgView_weather);

        TextView windSpeedView = layout.findViewById(R.id.txtView_wind_speed);
        TextView windSpeedUnitView = layout.findViewById(R.id.txtView_wind_speed_unit);

        airHumidityView = layout.findViewById(R.id.txtView_air_humidity);

        TextView pressureView = layout.findViewById(R.id.txtView_pressure);
        TextView pressureUnitView = layout.findViewById(R.id.txtView_pressure_unit);

        // TODO temp data for homework
        LinearLayout airHumidityLinLay = layout.findViewById(R.id.linLay_air_humidity);

        sensorManager = (SensorManager) getActivity().getSystemService(SENSOR_SERVICE);

        sensorTemperature = sensorManager.getDefaultSensor(Sensor.TYPE_AMBIENT_TEMPERATURE);
        sensorHumidity = sensorManager.getDefaultSensor(Sensor.TYPE_RELATIVE_HUMIDITY);

//        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
//        boolean isWindSpeed = preferences.getBoolean(SettingsFragment.KEY_PREF_WIND_SPEED, false);
//        boolean isAirHumidity = preferences.getBoolean(SettingsFragment.KEY_PREF_AIR_HUMIDITY, false);
//        boolean isPressure = preferences.getBoolean(SettingsFragment.KEY_PREF_PRESSURE, false);

        TypedArray weatherImages = getResources().obtainTypedArray(R.array.weather_images);
//
        cityTxtView.setText(getArguments().getString(CITY));
        weatherImage.setImageResource(weatherImages.getResourceId(0, -1));
//        temperatureView.setText(R.string.test_temperature);
        temperatureUnitView.setText(R.string.unit_celsius);
        windSpeedView.setText(R.string.test_wind_speed);
        windSpeedUnitView.setText(R.string.unit_m_s);
//        airHumidityView.setText(R.string.test_air_humidity);
        pressureView.setText(R.string.test_pressure);
        pressureUnitView.setText(R.string.unit_torr);
        return layout;
    }

    public String getCity() {
        return getArguments().getString(CITY);
    }

    SensorEventListener listenerTemperature = new SensorEventListener() {
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }
        @Override
        public void onSensorChanged(SensorEvent event) {
            showTemperatureSensors(event);
        }
    };

    SensorEventListener listenerHumidity = new SensorEventListener() {
        @Override
        public void onAccuracyChanged(Sensor sensor, int accuracy) {
        }

        @Override
        public void onSensorChanged(SensorEvent event) {
            showHumiditySensors(event);
        }
    };

    private void showTemperatureSensors(SensorEvent event){
        temperatureView.setText(String.valueOf(event.values[0]));
    }

    private void showHumiditySensors(SensorEvent event){
        airHumidityView.setText(String.valueOf(event.values[0]));
    }

    @Override
    public void onPause() {
        super.onPause();
        sensorManager.unregisterListener(listenerTemperature, sensorTemperature);
        sensorManager.unregisterListener(listenerHumidity, sensorHumidity);
    }

    @Override
    public void onResume() {
        super.onResume();
        sensorManager.registerListener(listenerTemperature, sensorTemperature,
                SensorManager.SENSOR_DELAY_NORMAL);
        sensorManager.registerListener(listenerHumidity, sensorHumidity,
                SensorManager.SENSOR_DELAY_NORMAL);
    }
}
