package online.z0lk1n.android.niceweather;

import android.app.FragmentTransaction;
import android.app.ListFragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import static online.z0lk1n.android.niceweather.DetailedWeatherFragment.PARCEL;


public class CitiesFragment extends ListFragment {

    boolean isExistParams;
    Parcel currentParcel;

    @Override
    public View onCreateView(LayoutInflater inflater,
                             ViewGroup container,
                             Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_cities, container, false);
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);

        ArrayAdapter adapter = ArrayAdapter.createFromResource(getActivity(),
                R.array.Cities,
                android.R.layout.simple_list_item_activated_1);

        setListAdapter(adapter);

        // Определение, можно ли будет расположить рядом герб в другом фрагменте
        View detailsFrame = getActivity().findViewById(R.id.info);
        // getActivity - получить контекст активити, где расположен фрагмент
        isExistParams = detailsFrame != null && detailsFrame.getVisibility() == View.VISIBLE;

        // Если это не повторное создание, то восстановим текущую позицию
        if (savedInstanceState != null) {
            // Restore last state for checked position.
            currentParcel = (Parcel) savedInstanceState.getSerializable("CurrentCity");
        }
        else {
            currentParcel = new Parcel(0, getResources().getTextArray(R.array.Cities)[0].toString(), getResources().getString(R.string.test_wind_speed),
                    getResources().getString(R.string.test_wind_speed), getResources().getString(R.string.test_air_humidity), getResources().getString(R.string.pressure));
        }

        // Если можно нарисовать рядом герб, то сделаем это
        if (isExistParams){
            getListView().setChoiceMode(ListView.CHOICE_MODE_SINGLE);
            showInfo(currentParcel);
        }
    }

    // Сохраним текущую позицию (вызывается перед выходом из фрагмента)
    @Override
    public void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        outState.putSerializable("CurrentCity", currentParcel);
    }

    // Обработка выбора позиции
    @Override
    public void onListItemClick(ListView l, View v, int position, long id) {
        TextView cityNameView = (TextView) v;

        //position only 0

        currentParcel =  new Parcel(0, cityNameView.getText().toString(), getResources().getString(R.string.test_wind_speed),
                getResources().getString(R.string.test_wind_speed), getResources().getString(R.string.test_air_humidity), getResources().getString(R.string.pressure));
        showInfo(currentParcel);
    }

    // Показать герб. Ecли возможно, то показать рядом со списком,
    // если нет, то открыть второе активити
    private void showInfo(Parcel parcel) {
        if (isExistParams) {
            // Выделим текущий элемент списка
            getListView().setItemChecked(0, true);

            // Проверим, что фрагмент с гербом существует в активити
            DetailedWeatherFragment detail = (DetailedWeatherFragment)
                    getFragmentManager().findFragmentById(R.id.info);
            // если есть необходимость, то выведем герб
            if (detail == null || detail.getParcel().getImageIndex() != parcel.getImageIndex()) {

                // Создаем новый фрагмент, с текущей позицией, для вывода герба
                detail = DetailedWeatherFragment.create(parcel);

                FragmentTransaction ft = getFragmentManager().beginTransaction();
                ft.replace(R.id.info, detail);
                ft.setTransition(FragmentTransaction.TRANSIT_FRAGMENT_FADE);
                ft.commit();
            }

        }
        else {
            Intent intent = new Intent();
            intent.setClass(getActivity(), DetailedWeatherActivity.class);
            intent.putExtra(PARCEL, parcel);
            startActivity(intent);
        }
    }

}