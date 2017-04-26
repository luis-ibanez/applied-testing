package com.the3rocks.appliedtesting.di.modules;


import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

import com.the3rocks.appliedtesting.executor.*;

@Module
public class ApplicationModule {
    private final Application application;

    public ApplicationModule(Application application) {
        this.application = application;
    }

    @Provides
    @Singleton
    Application providesApplication() {
        return application;
    }

    @Provides
    @Singleton
    public Context providesApplicationContext() {
        return application.getBaseContext();
    }

    @Provides
    @Singleton
    Executor provideThreadExecutor(ThreadExecutor threadExecutor) {
        return threadExecutor;
    }

    @Provides
    @Singleton
    MainThread providePostExecutionThread(MainThreadImpl mainThread) {
        return mainThread;
    }

}

