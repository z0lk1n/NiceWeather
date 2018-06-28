package online.z0lk1n.android.niceweather.util;

import android.content.Context;
import android.os.Handler;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.io.IOException;
import java.lang.reflect.Type;

import okhttp3.Call;
import okhttp3.Callback;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import online.z0lk1n.android.niceweather.R;
import online.z0lk1n.android.niceweather.model.OpenWeatherMap;

import static junit.framework.Assert.fail;

public class HttpRequester {
    private static final String OWM_API_URL = "http://api.openweathermap.org/data/2.5/weather?q=%s&%s";
    private static final String OWM_KEY = "x-api-key";
    private static final String OWM_UNITS = "units=metric";
    private OnResponseCompleted listener;

    public HttpRequester(OnResponseCompleted listener) {
        this.listener = listener;
    }

    public interface OnResponseCompleted {
        void onCompleted(OpenWeatherMap owm);
    }

    public void run(final Context context, String city) {
        OkHttpClient client = new OkHttpClient();
        Request request = new Request.Builder()
                .url(String.format(OWM_API_URL, city, OWM_UNITS))
                .addHeader(OWM_KEY, context.getString(R.string.owm_api_key))
                .build();
        Call call = client.newCall(request);

        call.enqueue(new Callback() {
            final Handler handler = new Handler();

            public void onResponse(Call call, Response response) throws IOException {
                Type type = new TypeToken<OpenWeatherMap>(){}.getType();
                String answer = response.body().string();
                final OpenWeatherMap owm = new Gson().fromJson(answer, type);

                if (owm.getCod() == 200) {
                    handler.post(new Runnable() {
                        @Override
                        public void run() {
                            listener.onCompleted(owm);
                        }
                    });
                } else {
                    handler.post(new Runnable() {
                        public void run() {
                            Toast.makeText(context,
                                    context.getString(R.string.place_not_found),
                                    Toast.LENGTH_LONG).show();
                        }
                    });
                }
            }

            public void onFailure(Call call, IOException e) {
                fail();
            }
        });
    }
}
