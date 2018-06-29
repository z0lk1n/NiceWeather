package online.z0lk1n.android.niceweather.ui;

import android.app.Fragment;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import online.z0lk1n.android.niceweather.FragmentNavigator;
import online.z0lk1n.android.niceweather.R;
import online.z0lk1n.android.niceweather.model.OpenWeatherMap;
import online.z0lk1n.android.niceweather.model.WeatherIcon.WeatherIconHandler;
import online.z0lk1n.android.niceweather.util.HttpRequester;
import online.z0lk1n.android.niceweather.util.Preferences;

public class DetailWeatherFragment extends Fragment {
    public static final String NAME = "26a77419-a51e-46c9-8b34-9f83698229f2";
    private TextView cityTxtView;
    private TextView weatherIconTxtView;
    private TextView airHumidityView;
    private TextView temperatureView;
    private TextView temperatureUnitView;
    private TextView windSpeedView;
    private TextView windSpeedUnitView;
    private TextView pressureView;
    private TextView pressureUnitView;
    private Preferences preferences;
    private WeatherIconHandler weatherIconHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_detail_weather, container, false);


        preferences = Preferences.getInstance(getActivity());
        weatherIconHandler = new WeatherIconHandler();

        cityTxtView = layout.findViewById(R.id.txtView_city);
        weatherIconTxtView = layout.findViewById(R.id.txtView_weather_icon);
        airHumidityView = layout.findViewById(R.id.txtView_air_humidity);
        temperatureView = layout.findViewById(R.id.txtView_temperature);
        temperatureUnitView = layout.findViewById(R.id.txtView_temperature_unit);
        windSpeedView = layout.findViewById(R.id.txtView_wind_speed);
        windSpeedUnitView = layout.findViewById(R.id.txtView_wind_speed_unit);
        pressureView = layout.findViewById(R.id.txtView_pressure);
        pressureUnitView = layout.findViewById(R.id.txtView_pressure_unit);

        updateWeatherData(preferences.getCity());
        setupToolbar();

        return layout;
    }

    private void updateWeatherData(String city) {
        HttpRequester requester = new HttpRequester(new HttpRequester.OnResponseCompleted() {
            @Override
            public void onCompleted(OpenWeatherMap owm) {
                renderWeather(owm);
            }
        });
        requester.run(getActivity(), city);
    }

    private void renderWeather(OpenWeatherMap owm) {
        try {
            cityTxtView.setText(owm.getName());

            weatherIconTxtView.setText(weatherIconHandler.getWeatherIcon(getActivity(),
                    owm.getWeatherList().get(0).getId(),
                    owm.getDt(),
                    owm.getSys().getSunrise(),
                    owm.getSys().getSunset()));

            if (preferences.isTemperature()) {
                double tmp = (owm.getMain().getTemp() * 9 / 5) + 32;
                temperatureView.setText(String.format("%.1f", tmp));
                temperatureUnitView.setText(R.string.unit_fahrenheit);
            } else {
                temperatureView.setText(String.format("%.1f", owm.getMain().getTemp()));
                temperatureUnitView.setText(R.string.unit_celsius);
            }

            if (preferences.isWindSpeed()) {
                double tmp = (owm.getWind().getSpeed() * 36) / 10;
                windSpeedView.setText(String.format("%.1f", tmp));
                windSpeedUnitView.setText(R.string.unit_km_h);
            } else {
                windSpeedView.setText(String.format("%.1f", owm.getWind().getSpeed()));
                windSpeedUnitView.setText(R.string.unit_m_s);
            }

            airHumidityView.setText(String.valueOf(owm.getMain().getHumidity()));

            if (preferences.isPressure()) {
                pressureView.setText(String.format("%.0f", owm.getMain().getPressure()));
                pressureUnitView.setText(R.string.unit_pascal);
            } else {
                double tmp = owm.getMain().getPressure() * 0.75006375541921;
                pressureView.setText(String.format("%.0f", tmp));
                pressureUnitView.setText(R.string.unit_torr);
            }

        } catch (Exception e) {
            Log.e(getActivity().getPackageName(), "One or more fields not found in the JSON data");
        }
    }

    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_main, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        FragmentNavigator fragmentNavigator;
        switch (item.getItemId()) {
            case android.R.id.home:
                fragmentNavigator = (FragmentNavigator) getActivity();
                fragmentNavigator.showCitiesList();
                return true;
            case R.id.action_settings:
                fragmentNavigator = (FragmentNavigator) getActivity();
                fragmentNavigator.showSettings();
                return true;
            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    public void setupToolbar() {
        setHasOptionsMenu(true);
        FragmentNavigator fragmentNavigator = (FragmentNavigator) getActivity();
        fragmentNavigator.setupToolbar(getResources().getString(R.string.app_name),
                R.drawable.ic_toolbar_cities_list);
    }
}
