package online.z0lk1n.android.niceweather.network;

import android.content.Context;
import android.util.Log;

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
        void onFailure(String error);
    }

    public void requestRetrofit(final Context context, String city) {
        OpenWeatherMapRequester.getApi()
                .loadWeather(city, Const.OWM_API_KEY, Const.OWM_UNITS_METRIC)
                .enqueue(new retrofit2.Callback<OpenWeatherMap>() {
                    OpenWeatherMap owm;
                    @Override
                    public void onResponse(retrofit2.Call<OpenWeatherMap> call, retrofit2.Response<OpenWeatherMap> response) {
                        if (response.body() != null) {
                            owm = response.body();
                            if (owm != null) {
                                if (owm.getCod() == 200) {
                                    listener.onCompleted(owm);
                                } else {
                                    listener.onFailure(context.getString(R.string.place_not_found));
                                }
                            } else {
                                listener.onFailure("owm is null");
                            }
                        }
                    }

                    @Override
                    public void onFailure(retrofit2.Call<OpenWeatherMap> call, Throwable t) {
//                        if (owm == null) {
//                            listener.onFailure("owm is null");
//                        }
//                        if (owm.getCod() != 200) {
//                            listener.onFailure(context.getString(R.string.place_not_found));
//                        }
                        listener.onFailure("internet problem");
                        call.cancel();
                        Log.d(getClass().getSimpleName(), t.toString());
                    }
                });
    }
}
