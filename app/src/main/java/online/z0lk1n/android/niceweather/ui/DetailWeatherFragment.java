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
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DateFormat;
import java.util.Date;

import online.z0lk1n.android.niceweather.R;
import online.z0lk1n.android.niceweather.model.OpenWeatherMap;
import online.z0lk1n.android.niceweather.model.WeatherIcon.WeatherIconHandler;
import online.z0lk1n.android.niceweather.network.WeatherDataReceiver;
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
    private TextView lastUpdateTxtView;
    private TextView windDirectionView;
    private TextView windDirectionIconView;
    private TextView weatherDescriptionView;
    private Button refreshBtn;
    private Preferences preferences;
    private WeatherIconHandler weatherIconHandler;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_detail_weather, container, false);
        initialize(layout);
        setupToolbar();
        updateWeatherData(preferences.getCity());
        return layout;
    }

    private void initialize(View view) {
        preferences = Preferences.getInstance(getActivity());
        weatherIconHandler = new WeatherIconHandler();
        cityTxtView = view.findViewById(R.id.txtView_city);
        weatherIconTxtView = view.findViewById(R.id.txtView_weather_icon);
        airHumidityView = view.findViewById(R.id.txtView_air_humidity);
        temperatureView = view.findViewById(R.id.txtView_temperature);
        temperatureUnitView = view.findViewById(R.id.txtView_temperature_unit);
        windSpeedView = view.findViewById(R.id.txtView_wind_speed);
        windSpeedUnitView = view.findViewById(R.id.txtView_wind_speed_unit);
        pressureView = view.findViewById(R.id.txtView_pressure);
        pressureUnitView = view.findViewById(R.id.txtView_pressure_unit);
        lastUpdateTxtView = view.findViewById(R.id.txtView_last_update);
        windDirectionView = view.findViewById(R.id.txtView_wind_direction);
        windDirectionIconView = view.findViewById(R.id.txtView_wind_direction_icon);
        weatherDescriptionView = view.findViewById(R.id.txtView_weather_description);
        refreshBtn = view.findViewById(R.id.btn_refresh);

        refreshBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                updateWeatherData(cityTxtView.getText().toString());
            }
        });
    }

    private void updateWeatherData(String city) {
        WeatherDataReceiver requester = new WeatherDataReceiver(new WeatherDataReceiver.OnResponseCompleted() {
            @Override
            public void onCompleted(OpenWeatherMap owm) {
                renderWeather(owm);
            }

            @Override
            public void onFailure(String error) {
                Toast.makeText(getActivity(), error, Toast.LENGTH_LONG).show();
            }
        });
        requester.requestRetrofit(getActivity(), city);
    }

    private void renderWeather(OpenWeatherMap owm) {
        try {

            StringBuilder sb = new StringBuilder();
            DateFormat df = DateFormat.getDateTimeInstance();
            sb.append(getResources().getString(R.string.last_update))
                    .append(" ").append(df.format(new Date(owm.getDt() * 1000)));
            lastUpdateTxtView.setText(sb.toString());

            cityTxtView.setText(owm.getName());

            weatherIconTxtView.setText(weatherIconHandler.getWeatherIcon(getActivity(),
                    owm.getWeather()[0].getId(),
                    owm.getDt(),
                    owm.getSys().getSunrise(),
                    owm.getSys().getSunset()));

            weatherDescriptionView.setText(owm.getWeather()[0].getDescription());

            if (preferences.isTemperature()) {
                double tmp = convertCelsiusToFahrenheit(owm.getMain().getTemp());
                temperatureView.setText(String.format("%.1f", tmp));
                temperatureUnitView.setText(R.string.unit_fahrenheit);
            } else {
                temperatureView.setText(String.format("%.1f", owm.getMain().getTemp()));
                temperatureUnitView.setText(R.string.unit_celsius);
            }

            if (preferences.isWindSpeed()) {
                double tmp = convertMsToKmh(owm.getWind().getSpeed());
                windSpeedView.setText(String.format("%.1f", tmp));
                windSpeedUnitView.setText(R.string.unit_km_h);
            } else {
                windSpeedView.setText(String.format("%.1f", owm.getWind().getSpeed()));
                windSpeedUnitView.setText(R.string.unit_m_s);
            }

            windDirectionView.setText(getDescriptionWindDirection(owm.getWind().getDeg()));

            windDirectionIconView.setText(weatherIconHandler.getWindDirectionIcon(getActivity(),
                    owm.getWind().getDeg()));

            airHumidityView.setText(String.valueOf(owm.getMain().getHumidity()));

            if (preferences.isPressure()) {
                pressureView.setText(String.valueOf(owm.getMain().getPressure()));
                pressureUnitView.setText(R.string.unit_pascal);
            } else {
                double tmp = convertPascalToTorr(owm.getMain().getPressure());
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

    private double convertCelsiusToFahrenheit(double value) {
        return (value * 9 / 5) + 32;
    }

    private double convertMsToKmh(double value) {
        return (value * 36) / 10;
    }

    private double convertPascalToTorr(double value) {
        return value * 0.75006375541921;
    }

    private String getDescriptionWindDirection(double deg) {
        String description;

        if (deg >= 23 && deg < 68) {
            description = "NE";
        } else if (deg >= 68 && deg < 113) {
            description = "E";
        } else if (deg >= 113 && deg < 158) {
            description = "SE";
        } else if (deg >= 158 && deg < 203) {
            description = "S";
        } else if (deg >= 203 && deg < 248) {
            description = "SW";
        } else if (deg >= 248 && deg < 293) {
            description = "W";
        } else if (deg >= 293 && deg < 338) {
            description = "NW";
        } else {
            description = "N";
        }
        return description;
    }
}
