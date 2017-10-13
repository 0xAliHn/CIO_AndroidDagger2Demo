package cio.android.dagger2demo;

import android.app.Application;
import android.content.Intent;

import cio.android.dagger2demo.component.ApplicationComponent;
import cio.android.dagger2demo.component.DaggerApplicationComponent;
import cio.android.dagger2demo.module.ApiModule;
import cio.android.dagger2demo.module.ApplicationModule;
import cio.android.dagger2demo.services.CurrentConditionService;

import io.realm.Realm;
import io.realm.RealmConfiguration;

public class TaskoApplication extends Application {

    private ApplicationComponent component;

    @Override
    public void onCreate() {
        super.onCreate();

        component = DaggerApplicationComponent.builder()
                            .applicationModule(new ApplicationModule(this))
                            .apiModule(new ApiModule())
                            .build();

        // Configure Realm for the application
        Realm.init(this);
        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("tasko.realm")
                .build();
        Realm.deleteRealm(realmConfiguration); // Clean slate
        Realm.setDefaultConfiguration(realmConfiguration); // Make this Realm the default

        // Check the current conditions
        startService(new Intent(this, CurrentConditionService.class));
    }

    public ApplicationComponent getComponent() {
        return component;
    }
}
