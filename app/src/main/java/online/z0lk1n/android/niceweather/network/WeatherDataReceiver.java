package online.z0lk1n.android.niceweather.network;

import android.content.Context;
import android.util.Log;

import online.z0lk1n.android.niceweather.R;
import online.z0lk1n.android.niceweather.model.OpenWeatherMap;
import online.z0lk1n.android.niceweather.util.Const;

public class WeatherDataReceiver {
    private static final String TAG = "CallInstances";
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
                        if (checkForNull(response.body())) {
                            owm = response.body();
                            if (checkForNull(owm)) {
                                if (owm.getCod() == 200) {
                                    if(owm.getCod() < 1)   {
                                        onFailure(call, new Throwable("Dt is null"));
                                    }
                                    if(owm.getName().isEmpty()) {
                                        onFailure(call, new Throwable("Name is null"));
                                    }
                                    if(owm.getWeather()[0].getId() < 1){
                                        onFailure(call, new Throwable("Id is null"));
                                    }
                                    if(owm.getSys().getSunrise() < 1)   {
                                        onFailure(call, new Throwable("Sunrise is null"));
                                    }
                                    if(owm.getSys().getSunset() < 1)   {
                                        onFailure(call, new Throwable("Sunset is null"));
                                    }
                                    if(owm.getWeather()[0].getDescription().isEmpty())  {
                                        onFailure(call, new Throwable("Description is null"));
                                    }
//                                    if(owm.getMain().getTemp() == null) {
//                                        onFailure(call, new Throwable("Temp is null"));
//                                    }
//                                    if(owm.getWind().getSpeed() == null) {
//                                        onFailure(call, new Throwable("Wind speed is null"));
//                                    }
                                    if(owm.getWind().getDeg() < 1 && owm.getWind().getDeg() > 360) {
                                        onFailure(call, new Throwable("Wind deg is null"));
                                    }
                                    if(owm.getMain().getHumidity() < 1) {
                                        onFailure(call, new Throwable("Humidity is null"));
                                    }
                                    if(owm.getMain().getPressure() < 1) {
                                        onFailure(call, new Throwable("Pressure is null"));
                                    }
                                    listener.onCompleted(owm);
                                } else {
                                    onFailure(call, new Throwable(context.getString(R.string.place_not_found)));
                                }
                            } else {
                                onFailure(call, new Throwable(context.getString(R.string.owm_null)));
                            }
                        }
                        Log.d(TAG, context.getString(R.string.request_success));
                    }

                    @Override
                    public void onFailure(retrofit2.Call<OpenWeatherMap> call, Throwable t) {
                        listener.onFailure(t.getMessage());
                        Log.d(TAG, context.getString(R.string.request_failed));
                        call.cancel();
                    }
                });
    }

    private boolean checkForNull(Object object)  {
        return object != null;
    }
}
