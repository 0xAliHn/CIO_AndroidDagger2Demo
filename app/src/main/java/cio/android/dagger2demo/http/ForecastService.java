package cio.android.dagger2demo.http;

public interface ForecastService {
    void getForecastFor(String latitude, String longitude, ForecastListener forecastListener);
}
