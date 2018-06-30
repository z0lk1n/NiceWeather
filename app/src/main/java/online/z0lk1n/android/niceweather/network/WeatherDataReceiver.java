package online.z0lk1n.android.niceweather.network;

import android.content.Context;
import android.util.Log;
import android.widget.Toast;

import online.z0lk1n.android.niceweather.R;
import online.z0lk1n.android.niceweather.model.OpenWeatherMap;
import online.z0lk1n.android.niceweather.util.Const;

public class WeatherDataReceiver {
    private OnResponseCompleted listener;

    public WeatherDataReceiver(OnResponseCompleted listener) {
        this.listener = listener;
    }

    public interface OnResponseCompleted {
        void onCompleted(OpenWeatherMap owm);
    }

    public void requestRetrofit(final Context context, String city) {
        OpenWeatherMapRequester.getApi()
                .loadWeather(city, Const.OWM_API_KEY, Const.OWM_UNITS_METRIC)
                .enqueue(new retrofit2.Callback<OpenWeatherMap>() {
                    @Override
                    public void onResponse(retrofit2.Call<OpenWeatherMap> call, retrofit2.Response<OpenWeatherMap> response) {
                        if (response.body() != null) {
                            OpenWeatherMap owm = response.body();
                            if (owm != null) {
                                if (owm.getCod() == 200) {
                                    listener.onCompleted(owm);
                                } else {
                                    Toast.makeText(context,
                                            context.getString(R.string.place_not_found),
                                            Toast.LENGTH_LONG).show();
                                }
                            }
                        }
                    }

                    @Override
                    public void onFailure(retrofit2.Call<OpenWeatherMap> call, Throwable t) {
                        call.cancel();
                        Log.d(getClass().getSimpleName(), "onFailure");
                    }
                });
    }
}
