package online.z0lk1n.android.niceweather.ui;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONException;
import org.json.JSONObject;

import online.z0lk1n.android.niceweather.FragmentNavigator;
import online.z0lk1n.android.niceweather.R;
import online.z0lk1n.android.niceweather.util.Preferences;
import online.z0lk1n.android.niceweather.util.RequestMaker;

public class DetailWeatherFragment extends Fragment {
    public static final String NAME = "26a77419-a51e-46c9-8b34-9f83698229f2";
    private Typeface weatherFont;
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

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_detail_weather, container, false);


        preferences = Preferences.getInstance(getActivity());
        weatherFont = Typeface.createFromAsset(getActivity().getAssets(),
                "fonts/weather_icons.ttf");

        cityTxtView = layout.findViewById(R.id.txtView_city);
        weatherIconTxtView = layout.findViewById(R.id.txtView_weather_icon);
        airHumidityView = layout.findViewById(R.id.txtView_air_humidity);
        temperatureView = layout.findViewById(R.id.txtView_temperature);
        temperatureUnitView = layout.findViewById(R.id.txtView_temperature_unit);
        windSpeedView = layout.findViewById(R.id.txtView_wind_speed);
        windSpeedUnitView = layout.findViewById(R.id.txtView_wind_speed_unit);
        pressureView = layout.findViewById(R.id.txtView_pressure);
        pressureUnitView = layout.findViewById(R.id.txtView_pressure_unit);

        weatherIconTxtView.setTypeface(weatherFont);

        updateWeatherData(preferences.getCity());
        setupToolbar();

        return layout;
    }

    private void updateWeatherData(final String city) {
        final Handler handler = new Handler();
        new Thread() {
            public void run() {
                final JSONObject json = RequestMaker.getJSON(getActivity(), city);
                if (json == null) {
                    handler.post(new Runnable() {
                        public void run() {
                            Toast.makeText(getActivity(),
                                    getActivity().getString(R.string.place_not_found),
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                } else {
                    handler.post(new Runnable() {
                        public void run() {
                            renderWeather(json);
                        }
                    });
                }
            }
        }.start();
    }

    private void renderWeather(JSONObject json) {

        try {
            JSONObject main = json.getJSONObject("main");
            JSONObject wind = json.getJSONObject("wind");


            cityTxtView.setText(json.getString("name"));

//            weatherIconTxtView.setText();

            if (preferences.isTemperature()) {
                double tmp = (main.getDouble("temp") * 9 / 5) + 32;
                temperatureView.setText(String.format("%.1f", tmp));
                temperatureUnitView.setText(R.string.unit_fahrenheit);
            } else {
                temperatureView.setText(String.format("%.1f", main.getDouble("temp")));
                temperatureUnitView.setText(R.string.unit_celsius);
            }

            if (preferences.isWindSpeed()) {
                double tmp = (wind.getDouble("speed") * 36) / 10;
                windSpeedView.setText(String.format("%.1f", tmp));
                windSpeedUnitView.setText(R.string.unit_km_h);
            } else {
                windSpeedView.setText(wind.getString("speed"));
                windSpeedUnitView.setText(R.string.unit_m_s);
            }

            airHumidityView.setText(main.getString("humidity"));

            if (preferences.isPressure()) {
                pressureView.setText(main.getString("pressure"));
                pressureUnitView.setText(R.string.unit_pascal);
            } else {
                double tmp = main.getDouble("pressure") * 0.75006375541921;
                pressureView.setText(String.format("%.0f", tmp));
                pressureUnitView.setText(R.string.unit_torr);
            }
        } catch (JSONException e) {
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
