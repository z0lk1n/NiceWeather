package online.z0lk1n.android.niceweather.ui;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v7.app.AlertDialog;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.text.InputType;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;

import online.z0lk1n.android.niceweather.R;
import online.z0lk1n.android.niceweather.util.CitiesList;
import online.z0lk1n.android.niceweather.util.RecyclerAdapter;

public class CitiesListFragment extends Fragment implements View.OnClickListener {
    public static final String NAME = "ec1cbfa6-3885-4b51-b2ba-ac388db60f23";
    public static final String CITY = "ed00b2f2-e551-4d2d-8262-c4fa5d89e32c";
    private RecyclerView recyclerView;
    private CitiesList citiesList;
    private int currentPosition = 0;
    private RecyclerAdapter adapter;

    @SuppressLint("ResourceAsColor")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View fragmentView = inflater.inflate(R.layout.fragment_cities_list, container, false);
        recyclerView = fragmentView.findViewById(R.id.recycler_view);
        FloatingActionButton fab = fragmentView.findViewById(R.id.fab_add_city);
        fab.setOnClickListener(this);
//        registerForContextMenu(recyclerView);
        setupToolbar();
        return fragmentView;
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());
        recyclerView.setLayoutManager(layoutManager);

        citiesList = new CitiesList();

        adapter = new RecyclerAdapter(citiesList.getCities());
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
        FragmentNavigator fragmentNavigator = (FragmentNavigator) getActivity();
        fragmentNavigator.showDetailWeather(citiesList.getCities().get(currentPosition));
    }

    public void setCity(String city) {
        this.citiesList.setCity(city);
    }

    public void removeCity(int city) {
        this.citiesList.removeCity(city);
    }


    @Override
    public void onCreateOptionsMenu(Menu menu, MenuInflater inflater) {
        super.onCreateOptionsMenu(menu, inflater);
        inflater.inflate(R.menu.menu_cities_list, menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                getFragmentManager().popBackStack();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

//    @Override
//    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
//        super.onCreateContextMenu(menu, v, menuInfo);
//        MenuInflater inflater = getActivity().getMenuInflater();
//        inflater.inflate(R.menu.context_menu, menu);
//    }
//
//    @Override
//    public boolean onContextItemSelected(MenuItem item) {
//        switch (item.getItemId()) {
//            case R.id.remove_city:
//                removeCity(currentPosition);
//                adapter.notifyDataSetChanged();
//                return true;
//            default:
//                return super.onContextItemSelected(item);
//        }
//    }

    public void setupToolbar() {
        setHasOptionsMenu(true);
        FragmentNavigator fragmentNavigator = (FragmentNavigator) getActivity();
        fragmentNavigator.setupToolbar(getResources().getString(R.string.cities_list),
                R.drawable.ic_toolbar_cursor);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.fab_add_city:
                showAddCityDialog(view);
                break;
            default:
                break;
        }
    }

    private void showAddCityDialog(View view) {
        final EditText input = new EditText(view.getContext());
        input.setInputType(InputType.TYPE_CLASS_TEXT);
        input.setTextColor(getResources().getColor(R.color.colorBrighterAlizarinRed));
        AlertDialog.Builder builder = new AlertDialog.Builder(view.getContext(), R.style.MyDialogTheme)
                .setView(input)
                .setTitle(R.string.dialog_add_city_title)
                .setPositiveButton(R.string.ok, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        String cityName = input.getText().toString().trim();
                        if (!cityName.isEmpty()) {
                            setCity(cityName);
                            adapter.notifyDataSetChanged();
                        }
                    }
                })
                .setNegativeButton(R.string.cancel, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.dismiss();
                    }
                });
        builder.show();
    }
}
