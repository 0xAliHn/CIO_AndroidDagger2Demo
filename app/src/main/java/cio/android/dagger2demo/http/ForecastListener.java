package cio.android.dagger2demo.http;

import cio.android.dagger2demo.models.Forecast;

public interface ForecastListener {
    void onForecastLoaded(Forecast forecast);
    void onForecastFailed(Exception e);
}
