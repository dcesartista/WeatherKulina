package id.kulina.exercise.kulinaexecise.API;

import java.util.Map;

import id.kulina.exercise.kulinaexecise.POJO.Forecasts;
import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.GET;
import retrofit2.http.QueryMap;

/**
 * Created by ACER on 9/6/2016.
 */
public interface GetWeatherAPI {
    public static final String OPEN_WEATHER_MAP_API = "http://api.openweathermap.org";

    @GET("/data/2.5/forecast/daily")
    Call<Forecasts> forecasts(
            @QueryMap Map<String, String> options
    );

    public static final Retrofit retrofit = new Retrofit.Builder()
            .baseUrl(OPEN_WEATHER_MAP_API)
            .addConverterFactory(GsonConverterFactory.create())
            .build();
}
