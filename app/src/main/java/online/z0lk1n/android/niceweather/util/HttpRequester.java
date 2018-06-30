package online.z0lk1n.android.niceweather.util;

import android.content.Context;
import android.widget.Toast;

import online.z0lk1n.android.niceweather.R;
import online.z0lk1n.android.niceweather.model.OpenWeatherMap;

public class HttpRequester {
    private OnResponseCompleted listener;

    public HttpRequester(OnResponseCompleted listener) {
        this.listener = listener;
    }

    public interface OnResponseCompleted {
        void onCompleted(OpenWeatherMap owm);
    }

    public void requestRetrofit(final Context context, String city) {
        Controller.getApi()
                .loadWeather(city, Const.OWM_API_KEY, Const.OWM_UNITS_METRIC)
                .enqueue(new retrofit2.Callback<OpenWeatherMap>() {
                    @Override
                    public void onResponse(retrofit2.Call<OpenWeatherMap> call, retrofit2.Response<OpenWeatherMap> response) {
                        if (response.body() != null) {
                            OpenWeatherMap owm = response.body();
                            listener.onCompleted(owm);

                            if (owm.getCod() == 200) {
                                listener.onCompleted(owm);
                            } else {
                                Toast.makeText(context,
                                        context.getString(R.string.place_not_found),
                                        Toast.LENGTH_LONG).show();
                            }
                        }
                    }

                    @Override
                    public void onFailure(retrofit2.Call<OpenWeatherMap> call, Throwable t) {
                    }
                });
    }
}
