package online.z0lk1n.android.niceweather.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import online.z0lk1n.android.niceweather.R;
import online.z0lk1n.android.niceweather.util.Parcel;

public class DetailedWeatherFragment extends Fragment {
    boolean isExistAnotherFragment;
    private Parcel parcel;

    public void setParcel(Parcel parcel) {
        this.parcel = parcel;
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

//        cityView.setText(parcel.getCityName());
        cityView.setText("TEST");
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

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View anotherFragment = getActivity().findViewById(R.id.fragment_container);
        isExistAnotherFragment = anotherFragment != null && anotherFragment.getVisibility() == View.VISIBLE;
        if (isExistAnotherFragment) {
            showAnotherFragmen();
        }
    }

    private void showAnotherFragmen(Fragment fragment)   {
        if(isExistAnotherFragment)  {
            Fragment fragmentContainer = getFragmentManager().findFragmentById(R.id.fragment_container);

            FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
            fragmentTransaction.replace(R.id.fragment_container, fragment);
            fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
            fragmentTransaction.commit();
        } else {
            Intent intent = new Intent();
            intent.setClass(getActivity(), fragment.getClass());
            startActivity(intent);
        }
    }
}
