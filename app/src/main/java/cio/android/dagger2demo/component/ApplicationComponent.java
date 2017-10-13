package cio.android.dagger2demo.component;

import cio.android.dagger2demo.MainActivity;
import cio.android.dagger2demo.TaskoApplication;
import cio.android.dagger2demo.fragments.MainFragment;
import cio.android.dagger2demo.module.ApiModule;
import cio.android.dagger2demo.module.ApplicationModule;
import cio.android.dagger2demo.services.CurrentConditionService;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = { ApplicationModule.class, ApiModule.class })
public interface ApplicationComponent {
    void inject(TaskoApplication target);
    void inject(MainActivity target);
    void inject(CurrentConditionService target);
    void inject(MainFragment target);
}
