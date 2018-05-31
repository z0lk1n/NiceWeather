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

    public static final String PARCEL = "parcel";

    public static DetailedWeatherFragment create(Parcel parcel) {
        DetailedWeatherFragment f = new DetailedWeatherFragment();

        Bundle args = new Bundle();
        args.putSerializable(PARCEL, parcel);
        f.setArguments(args);
        return f;
    }

    public Parcel getParcel() {
        Parcel parcel = (Parcel) getArguments().getSerializable(PARCEL);
        return parcel;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_info, container, false);
        
        ImageView weatherImage = layout.findViewById(R.id.imageView);
        TextView cityNameView = layout.findViewById(R.id.cityView);

        TypedArray imgs = getResources().obtainTypedArray(R.array.weather_images);
        Parcel parcel = getParcel();

//        weatherImage.setImageResource(imgs.getResourceId(parcel.getImageIndex(), -1));
        weatherImage.setImageResource(imgs.getResourceId(0, -1));
        cityNameView.setText(parcel.getCityName());
        return layout;
    }
}
