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
    private boolean isExistAnotherFragment;
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
                showAnotherFragment();
            }
        });

        View detailsWeather = getActivity().findViewById(R.id.fragment_container);
        isExistAnotherFragment = detailsWeather != null && detailsWeather.getVisibility() == View.VISIBLE;

        if (savedInstanceState != null) {
            currentPosition = savedInstanceState.getInt(CITY, 0);
        }

        if (isExistAnotherFragment) {
            showAnotherFragment();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CITY, currentPosition);
    }

    private void showAnotherFragment() {
        String city = citiesList.getCities().get(currentPosition);

        if (isExistAnotherFragment) {
            DetailWeatherFragment fragment =
                    (DetailWeatherFragment) getFragmentManager().findFragmentById(R.id.fragment_container);

            if (fragment == null || !city.equals(fragment.getCity())) {
                fragment = DetailWeatherFragment.create(city);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.commit();
            }
        }
    }

    public void setCity(String city) {
        this.citiesList.setCity(city);
    }
}
