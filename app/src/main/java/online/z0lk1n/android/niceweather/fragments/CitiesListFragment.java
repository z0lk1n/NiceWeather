package online.z0lk1n.android.niceweather.fragments;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import online.z0lk1n.android.niceweather.R;
import online.z0lk1n.android.niceweather.util.RecyclerAdapter;

public class CitiesListFragment extends Fragment {
    public static final String CITY = "CurrentCity";
    private List<String> cities = new ArrayList<String>(Arrays.asList(
            "Nizhnevartovsk", "Moscow", "Saint Petersburg", "Sochi", "Omsk"));
    private String city = "";
    boolean isExistAnotherFragment;
    int currentPosition = 0;
    private RecyclerAdapter adapter;

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_cities_list, container, false);

        RecyclerView recyclerView = fragmentView.findViewById(R.id.recycler_view);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        adapter = new RecyclerAdapter(cities);
        recyclerView.setAdapter(adapter);

//        final Activity that = getActivity();
        adapter.SetOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                currentPosition = position;
//                String city = ((TextView) view).getText().toString();
//
//                Toast.makeText(that, city, Toast.LENGTH_SHORT).show();
//                FragmentNavigator fragmentNavigator = (FragmentNavigator) that;
//                fragmentNavigator.startParametersFragment(city);

                showAnotherFragmen();
            }
        });

        return fragmentView;
    }

    @Override
    public void onStart() {
        super.onStart();
//        if(!city.isEmpty())    {
//            cities.add(0, city);
//            adapter.setNewArray(cities);
//            city = "";
//        }
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        View detailsWeather = getActivity().findViewById(R.id.detailed_weather);
        isExistAnotherFragment = detailsWeather != null && detailsWeather.getVisibility() == View.VISIBLE;

        if(savedInstanceState != null)  {
            currentPosition = savedInstanceState.getInt(CITY, 0);
        }

        if (isExistAnotherFragment) {
            showAnotherFragmen();
        }
    }

    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putInt(CITY, currentPosition);
    }

    private void showAnotherFragmen() {
        if (isExistAnotherFragment) {
            DetailedWeatherFragment fragment =
                    (DetailedWeatherFragment)getFragmentManager().findFragmentById(R.id.detailed_weather);

            if(fragment == null || fragment.getIndex() != currentPosition)    {
                fragment = DetailedWeatherFragment.create(currentPosition);

                FragmentTransaction fragmentTransaction = getFragmentManager().beginTransaction();
                fragmentTransaction.replace(R.id.fragment_container, fragment);
                fragmentTransaction.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                fragmentTransaction.commit();
            }
        } else {
            Intent intent = new Intent();
            intent.setClass(getActivity(), DetailedWeatherFragment.class);
            intent.putExtra(DetailedWeatherFragment.INDEX, currentPosition);
            startActivity(intent);
        }
    }

    public void setCity(String city) {
        this.city = city;
    }
}
