package online.z0lk1n.android.niceweather.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import online.z0lk1n.android.niceweather.R;
import online.z0lk1n.android.niceweather.util.CitiesList;
import online.z0lk1n.android.niceweather.util.RecyclerAdapter;

public class CitiesListFragment extends Fragment {
    public static final String NAME = "CitiesListFragment";
    public static final String CITY = "CurrentCity";
    private RecyclerView recyclerView;
    private CitiesList citiesList;
    int currentPosition = 0;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_cities_list, container, false);
        recyclerView = fragmentView.findViewById(R.id.recycler_view);
        return fragmentView;
    }


    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        citiesList = new CitiesList();

        RecyclerAdapter adapter = new RecyclerAdapter(citiesList.getCities());
        recyclerView.setAdapter(adapter);

        adapter.SetOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                currentPosition = position;
                showDetailWeather();
            }
        });

        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt(CITY, 0);
        }

    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CITY, currentPosition);
    }

    private void showDetailWeather() {
        String city = citiesList.getCities().get(currentPosition);

        DetailWeatherFragment detailWeatherFragment =
                (DetailWeatherFragment) getFragmentManager()
                        .findFragmentByTag(DetailWeatherFragment.NAME);

        if (detailWeatherFragment == null || !city.equals(detailWeatherFragment.getCity())) {
            detailWeatherFragment = DetailWeatherFragment.create(city);

            getFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, detailWeatherFragment)
                    .setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE)
                    .commit();
        }
    }

    public void setCity(String city) {
        this.citiesList.setCity(city);
    }
}
