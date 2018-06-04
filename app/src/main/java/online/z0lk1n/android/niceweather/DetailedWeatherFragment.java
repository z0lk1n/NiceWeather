package online.z0lk1n.android.niceweather;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

public class DetailedWeatherFragment extends Fragment {
    public static final String PARCEL = "CurrentCity";
    private TextView cityView;
    private ImageView weatherImage;
    private TextView temperatureView;
    private TextView windSpeedView;
    private TextView airHumidityView;
    private TextView pressureView;
    private TypedArray weatherImages;
    private Parcel parcel;

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_detailed_weather, container, false);
        setRetainInstance(true);

        cityView = layout.findViewById(R.id.txtView_city);
        weatherImage = layout.findViewById(R.id.imgView_weather_image);
        temperatureView = layout.findViewById(R.id.txtView_temperature);
        windSpeedView = layout.findViewById(R.id.txtView_wind_speed);
        airHumidityView = layout.findViewById(R.id.txtView_air_humidity);
        pressureView = layout.findViewById(R.id.txtView_pressure);

        weatherImages = getResources().obtainTypedArray(R.array.weather_images);

        cityView.setText(parcel.getCityName());
        weatherImage.setImageResource(weatherImages.getResourceId(0, -1));
        if (parcel.getTemperature()) {
            temperatureView.setText(R.string.test_temperature);
        }
        if (parcel.getWindSpeed()) {
            windSpeedView.setText(R.string.test_wind_speed);
        }
        if (parcel.getAirHumidity()) {
            airHumidityView.setText(R.string.test_air_humidity);
        }
        if (parcel.getPressure()) {
            pressureView.setText(R.string.pressure);
        }
        return layout;
    }
}
