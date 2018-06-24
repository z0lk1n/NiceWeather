package online.z0lk1n.android.niceweather.ui;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import online.z0lk1n.android.niceweather.R;

public class DetailWeatherFragment extends Fragment {
    public static final String NAME = "DetailWeatherFragment";
    public static final String CITY = "CurrentCity";

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
        ImageView weatherImage = layout.findViewById(R.id.imgView_weather);
        TextView airHumidityView = layout.findViewById(R.id.txtView_air_humidity);
        TextView temperatureView = layout.findViewById(R.id.txtView_temperature);
        TextView temperatureUnitView = layout.findViewById(R.id.txtView_temperature_unit);
        TextView windSpeedView = layout.findViewById(R.id.txtView_wind_speed);
        TextView windSpeedUnitView = layout.findViewById(R.id.txtView_wind_speed_unit);
        TextView pressureView = layout.findViewById(R.id.txtView_pressure);
        TextView pressureUnitView = layout.findViewById(R.id.txtView_pressure_unit);

        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        boolean isTemperature = preferences.getBoolean(SettingsFragment.KEY_PREF_TEMPERATURE, false);
        boolean isWindSpeed = preferences.getBoolean(SettingsFragment.KEY_PREF_WIND_SPEED, false);
        boolean isPressure = preferences.getBoolean(SettingsFragment.KEY_PREF_PRESSURE, false);

        TypedArray weatherImages = getResources().obtainTypedArray(R.array.weather_images);

        cityTxtView.setText(getArguments().getString(CITY));

        weatherImage.setImageResource(weatherImages.getResourceId(0, -1));
        airHumidityView.setText(R.string.test_air_humidity);

        if(isTemperature)   {
            temperatureView.setText(R.string.test_temperature);
            temperatureUnitView.setText(R.string.unit_fahrenheit);
        }else {
            temperatureView.setText(R.string.test_temperature);
            temperatureUnitView.setText(R.string.unit_celsius);
        }

        if(isWindSpeed) {
            windSpeedView.setText(R.string.test_wind_speed);
            windSpeedUnitView.setText(R.string.unit_km_h);
        }else {
            windSpeedView.setText(R.string.test_wind_speed);
            windSpeedUnitView.setText(R.string.unit_m_s);
        }

        if(isPressure){
            pressureView.setText(R.string.test_pressure);
            pressureUnitView.setText(R.string.unit_pascal);
        }else   {
            pressureView.setText(R.string.test_pressure);
            pressureUnitView.setText(R.string.unit_torr);
        }
        return layout;
    }

    public String getCity() {
        return getArguments().getString(CITY);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
    }
}
