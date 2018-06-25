package online.z0lk1n.android.niceweather.ui;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.os.Handler;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import org.json.JSONObject;

import online.z0lk1n.android.niceweather.R;
import online.z0lk1n.android.niceweather.util.Preferences;
import online.z0lk1n.android.niceweather.util.RequestMaker;

public class DetailWeatherFragment extends Fragment {
    public static final String NAME = "DetailWeatherFragment";
    TextView cityTxtView;
    ImageView weatherImage;
    TextView airHumidityView;
    TextView temperatureView;
    TextView temperatureUnitView;
    TextView windSpeedView;
    TextView windSpeedUnitView;
    TextView pressureView;
    TextView pressureUnitView;
    private Preferences preferences;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_detail_weather, container, false);

        cityTxtView = layout.findViewById(R.id.txtView_city);
        weatherImage = layout.findViewById(R.id.imgView_weather);
        airHumidityView = layout.findViewById(R.id.txtView_air_humidity);
        temperatureView = layout.findViewById(R.id.txtView_temperature);
        temperatureUnitView = layout.findViewById(R.id.txtView_temperature_unit);
        windSpeedView = layout.findViewById(R.id.txtView_wind_speed);
        windSpeedUnitView = layout.findViewById(R.id.txtView_wind_speed_unit);
        pressureView = layout.findViewById(R.id.txtView_pressure);
        pressureUnitView = layout.findViewById(R.id.txtView_pressure_unit);

        preferences = Preferences.getInstance(getActivity());

        TypedArray weatherImages = getResources().obtainTypedArray(R.array.weather_images);
        weatherImage.setImageResource(weatherImages.getResourceId(0, -1));

        updateWeatherData(preferences.getCity());
        return layout;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        return super.onOptionsItemSelected(item);
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
        } catch (Exception e) {
            Log.e("SimpleWeather", "One or more fields not found in the JSON data");
        }
    }
}
