package online.z0lk1n.android.niceweather.util;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import online.z0lk1n.android.niceweather.interfaces.OpenWeatherMapRequest;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Controller {

    public static OpenWeatherMapRequest getApi()    {
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(Const.OWM_URL)
                .addConverterFactory(GsonConverterFactory.create())
                .client(createOkHttpClient())
                .build();

        return retrofit.create(OpenWeatherMapRequest.class);
    }

    private static OkHttpClient createOkHttpClient()   {
        final OkHttpClient.Builder httpClient = new OkHttpClient.Builder();
        httpClient.addInterceptor(new HttpLoggingInterceptor().setLevel(HttpLoggingInterceptor.Level.BODY));
        return httpClient.build();
    }
}
