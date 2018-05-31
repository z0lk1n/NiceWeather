package online.z0lk1n.android.niceweather;

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
import android.widget.TextView;

public class ParametersFragment extends Fragment {
    public static final String PARCEL = "CurrentCity";
    private TextView cityTxt;
    private CheckBox temperatureChkBox;
    private CheckBox windSpeedChkBox;
    private CheckBox airHumidityChkBox;
    private CheckBox pressureChkBox;
    private Parcel currentCity;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_detailed_weather, container, false);

        cityTxt = fragmentView.findViewById(R.id.edTxt_city);
        temperatureChkBox = fragmentView.findViewById(R.id.chkBox_temperature);
        windSpeedChkBox = fragmentView.findViewById(R.id.chkBox_wind_speed);
        airHumidityChkBox = fragmentView.findViewById(R.id.chkBox_air_humidity);
        pressureChkBox = fragmentView.findViewById(R.id.chkBox_pressure);
        final Button showWeatherBtn = fragmentView.findViewById(R.id.btn_show_weather);

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
                FragmentNavigator fragmentNavigator = (FragmentNavigator) that;
                fragmentNavigator.startDetailedWeatherFragment(currentCity);
            }
        });

        if (savedInstanceState != null) {
            currentCity = (Parcel) savedInstanceState.getSerializable("CurrentCity");
        } else {
            createParcel();
        }

        return fragmentView;
    }

    private void createParcel()   {
        currentCity = new Parcel(cityTxt.toString(), temperatureChkBox.isChecked(),
                windSpeedChkBox.isChecked(), airHumidityChkBox.isChecked(), pressureChkBox.isChecked());
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("CurrentCity", currentCity);
    }

}