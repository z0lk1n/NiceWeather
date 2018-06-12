package online.z0lk1n.android.niceweather.fragments;

import android.app.Fragment;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import online.z0lk1n.android.niceweather.R;
import online.z0lk1n.android.niceweather.util.Parcel;

public class DetailedWeatherFragment extends Fragment {
    public static final String INDEX = "index";
    private Parcel parcel;

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
    }

    public static DetailedWeatherFragment create(int index) {
        DetailedWeatherFragment fragment = new DetailedWeatherFragment();
        Bundle args = new Bundle();
        args.putInt(INDEX, index);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_detailed_weather, container, false);

        TextView cityView = layout.findViewById(R.id.txtView_city);
        ImageView weatherImage = layout.findViewById(R.id.imgView_weather_image);
        TextView temperatureView = layout.findViewById(R.id.txtView_temperature);
        TextView windSpeedView = layout.findViewById(R.id.txtView_wind_speed);
        TextView airHumidityView = layout.findViewById(R.id.txtView_air_humidity);
        TextView pressureView = layout.findViewById(R.id.txtView_pressure);

        TypedArray weatherImages = getResources().obtainTypedArray(R.array.weather_images);

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

    public int getIndex()   {
        return getArguments().getInt(INDEX, 0);
    }
}
