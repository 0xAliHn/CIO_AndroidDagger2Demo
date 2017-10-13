package cio.android.dagger2demo.module;

import android.content.Context;


import javax.inject.Named;
import javax.inject.Singleton;

import cio.android.dagger2demo.Constants;
import cio.android.dagger2demo.R;
import cio.android.dagger2demo.http.ForecastIOApiEndpoint;
import dagger.Module;
import dagger.Provides;
import retrofit.Endpoint;
import retrofit.RestAdapter;

@Module
public class ApiModule {

    @Provides
    @Named(Constants.Injection.Named.FORECAST_API_KEY)
    public String provideForecastIOApiKey(Context context) {
        return context.getString(R.string.forecast_io_api_key);
    }

    @Provides
    public Endpoint provideEndpoint(@Named(Constants.Injection.Named.FORECAST_API_KEY) String apiKey) {
        return new ForecastIOApiEndpoint().setApiKey(apiKey);
    }

    @Provides
    @Singleton
    public RestAdapter provideRestAdapter(Endpoint endpoint) {
        return new RestAdapter.Builder()
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setEndpoint(endpoint)
                .build();
    }
}
