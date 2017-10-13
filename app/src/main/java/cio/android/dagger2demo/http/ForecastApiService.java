package cio.android.dagger2demo.http;


import cio.android.dagger2demo.models.Forecast;
import retrofit.http.GET;
import retrofit.http.Path;

public interface ForecastApiService {
    @GET("/{latitude},{longitude}")
    Forecast getForecast(@Path("latitude") String latitude, @Path("longitude") String longitude);
}
