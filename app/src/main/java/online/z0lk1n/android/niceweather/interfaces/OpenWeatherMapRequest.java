package online.z0lk1n.android.niceweather.interfaces;

import online.z0lk1n.android.niceweather.model.OpenWeatherMap;
import retrofit2.Call;
import retrofit2.http.GET;
import retrofit2.http.Query;

public interface OpenWeatherMapRequest {
    @GET("data/2.5/weather")
    Call<OpenWeatherMap> loadWeather(@Query("q") String city, @Query("appid") String keyApi,
                                     @Query("units") String units);
}
