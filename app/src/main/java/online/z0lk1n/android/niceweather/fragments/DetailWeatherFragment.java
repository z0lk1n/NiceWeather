package online.z0lk1n.android.niceweather.fragments;

import android.app.Fragment;
import android.content.SharedPreferences;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import online.z0lk1n.android.niceweather.R;

public class DetailWeatherFragment extends Fragment {
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

        TextView cityView = layout.findViewById(R.id.txtView_city);
        ImageView weatherImage = layout.findViewById(R.id.imgView_weather_image);
        TextView temperatureView = layout.findViewById(R.id.txtView_temperature);
        TextView windSpeedView = layout.findViewById(R.id.txtView_wind_speed);
        TextView airHumidityView = layout.findViewById(R.id.txtView_air_humidity);
        TextView pressureView = layout.findViewById(R.id.txtView_pressure);


        SharedPreferences preferences = PreferenceManager.getDefaultSharedPreferences(getActivity());
        boolean isWindSpeed = preferences.getBoolean(SettingsFragment.KEY_PREF_WIND_SPEED, false);
        boolean isAirHumidity = preferences.getBoolean(SettingsFragment.KEY_PREF_AIR_HUMIDITY, false);
        boolean isPressure = preferences.getBoolean(SettingsFragment.KEY_PREF_PRESSURE, false);

        TypedArray weatherImages = getResources().obtainTypedArray(R.array.weather_images);

        cityView.setText(getArguments().getString(CITY));
        weatherImage.setImageResource(weatherImages.getResourceId(0, -1));
        temperatureView.setText(R.string.test_temperature);
        windSpeedView.setText(R.string.test_wind_speed);
        airHumidityView.setText(R.string.test_air_humidity);
        pressureView.setText(R.string.pressure);
        return layout;
    }

    public String getCity() {
        return getArguments().getString(CITY);
    }
}
