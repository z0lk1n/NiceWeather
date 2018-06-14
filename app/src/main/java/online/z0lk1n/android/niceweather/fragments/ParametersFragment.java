package online.z0lk1n.android.niceweather.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import online.z0lk1n.android.niceweather.FragmentNavigator;
import online.z0lk1n.android.niceweather.R;

public class ParametersFragment extends Fragment {
    private TextView cityTxt;
    private CheckBox temperatureChkBox;
    private CheckBox windSpeedChkBox;
    private CheckBox airHumidityChkBox;
    private CheckBox pressureChkBox;
    private String city;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_parameters, container, false);

        cityTxt = fragmentView.findViewById(R.id.edTxt_city);
        temperatureChkBox = fragmentView.findViewById(R.id.chkBox_temperature);
        windSpeedChkBox = fragmentView.findViewById(R.id.chkBox_wind_speed);
        airHumidityChkBox = fragmentView.findViewById(R.id.chkBox_air_humidity);
        pressureChkBox = fragmentView.findViewById(R.id.chkBox_pressure);
        final Button showWeatherBtn = fragmentView.findViewById(R.id.btn_show_weather);
        final ImageButton citiesListBtn = fragmentView.findViewById(R.id.imgBtn_cities_list);
        ImageButton addCityBtn = fragmentView.findViewById(R.id.imgBtn_add_city);

        cityTxt.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                showWeatherBtn.setEnabled(!editable.toString().trim().isEmpty());
            }
        });

        final Activity that = getActivity();

        showWeatherBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

        citiesListBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                FragmentNavigator fragmentNavigator = (FragmentNavigator) that;
                fragmentNavigator.startCitiesListFragment();
            }
        });

        addCityBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(!cityTxt.getText().toString().trim().isEmpty())    {
                    FragmentNavigator fragmentNavigator = (FragmentNavigator) that;
                    fragmentNavigator.startCitiesListFragment(cityTxt.getText().toString().trim());
                }
            }
        });

        return fragmentView;
    }


    public void setCity(String city) {
        this.city = city;
    }

    @Override
    public void onStart() {
        super.onStart();
        cityTxt.setText(city);
    }
}