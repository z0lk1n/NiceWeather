package online.z0lk1n.android.niceweather;

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

public class CitiesListFragment extends Fragment {
    public static final String CITY = "city";
    private  String[] city = {"Nizhnevartovsk", "Moscow", "Saint Petersburg", "Sochi", "Omsk"};

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_cities_list, container, false);

        RecyclerView recyclerView = fragmentView.findViewById(R.id.recycler_view);

        recyclerView.setHasFixedSize(true);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        RecyclerAdapter adapter = new RecyclerAdapter(city);
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
}
