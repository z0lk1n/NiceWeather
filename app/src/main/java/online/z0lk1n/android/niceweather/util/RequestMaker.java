package online.z0lk1n.android.niceweather.util;

import android.content.Context;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.lang.reflect.Type;
import java.net.HttpURLConnection;
import java.net.URL;

import online.z0lk1n.android.niceweather.R;
import online.z0lk1n.android.niceweather.model.OpenWeatherMap;

public class RequestMaker {
    private static final String OPEN_WEATHER_MAP_API =
            "http://api.openweathermap.org/data/2.5/weather?q=%s&units=metric";

    public static JSONObject getJSON(Context context, String city) {
        try {
            URL url = new URL(String.format(OPEN_WEATHER_MAP_API, city));
            HttpURLConnection connection =
                    (HttpURLConnection) url.openConnection();

            connection.addRequestProperty("x-api-key",
                    context.getString(R.string.open_weather_map_api_key));

            BufferedReader reader = new BufferedReader(
                    new InputStreamReader(connection.getInputStream()));

            StringBuilder json = new StringBuilder(1024);
            String tmp;
            while ((tmp = reader.readLine()) != null) {
                json.append(tmp).append("\n");
            }
            reader.close();
            connection.disconnect();

            JSONObject data = new JSONObject(json.toString());

            if (data.getInt("cod") != 200) {
                return null;
            }

            // TODO TEST
            OpenWeatherMap openWeatherMap = new OpenWeatherMap();
            Gson gson = new Gson();
            Type type = new TypeToken<OpenWeatherMap>(){}.getType();
            openWeatherMap = gson.fromJson(json.toString(), type);

//            TODO doInBackground
//            String stream = null;
//            String ulrString = "  ";
//            Helper http = new Helper();
//            stream = http.getHTTPData(ulrString);

            return data;
        } catch (Exception e) {
            return null;
        }
    }
}
