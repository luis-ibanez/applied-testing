package com.the3rocks.appliedtesting;


import android.app.Application;

import com.the3rocks.appliedtesting.di.components.ApplicationComponent;
import com.the3rocks.appliedtesting.di.components.DaggerApplicationComponent;
import com.the3rocks.appliedtesting.di.modules.ApplicationModule;

public class TestingApplication extends Application {

    private ApplicationComponent applicationComponent;

    @Override
    public void onCreate() {
        super.onCreate();
        applicationComponent = DaggerApplicationComponent.builder()
                .applicationModule(new ApplicationModule(this))
                .build();
    }

    public ApplicationComponent getApplicationComponent() {
        return applicationComponent;
    }
}
