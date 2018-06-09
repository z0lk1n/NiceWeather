package online.z0lk1n.android.niceweather.fragments;

import android.app.Activity;
import android.app.Fragment;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import online.z0lk1n.android.niceweather.R;
import online.z0lk1n.android.niceweather.util.RecyclerAdapter;

public class CitiesListFragment extends Fragment {
    public static final String CITY = "cities";
    private List<String> cities = new ArrayList<String>(Arrays.asList(
            "Nizhnevartovsk", "Moscow", "Saint Petersburg", "Sochi", "Omsk"));
    private String city = "";
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

        final Activity that = getActivity();
        adapter.SetOnItemClickListener(new RecyclerAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position) {
                String city = ((TextView) view).getText().toString();

                Toast.makeText(that, city, Toast.LENGTH_SHORT).show();

                FragmentNavigator fragmentNavigator = (FragmentNavigator) that;
                fragmentNavigator.startParametersFragment(city);
            }
        });

        return fragmentView;
    }

    @Override
    public void onStart() {
        super.onStart();
        if(!city.isEmpty())    {
            cities.add(0, city);
            adapter.setNewArray(cities);
            city = "";
        }
    }

    public void setCity(String city) {
        this.city = city;
    }
}
