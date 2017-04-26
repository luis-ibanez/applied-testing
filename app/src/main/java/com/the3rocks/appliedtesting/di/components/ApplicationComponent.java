package com.the3rocks.appliedtesting.di.components;


import android.app.Application;
import android.content.Context;

import com.the3rocks.appliedtesting.TestingApplication;
import com.the3rocks.appliedtesting.di.modules.ApplicationModule;
import com.the3rocks.appliedtesting.di.modules.InteractorModule;
import com.the3rocks.appliedtesting.di.modules.RepositoryModule;
import com.the3rocks.appliedtesting.domain.profile.GetUserByIdCallback;
import com.the3rocks.appliedtesting.executor.MainThread;
import com.the3rocks.appliedtesting.executor.ThreadExecutor;
import com.the3rocks.appliedtesting.repository.profile.ProfileRepository;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                InteractorModule.class,
                RepositoryModule.class
        })
public interface ApplicationComponent {

    /**
     * Injections for the dependencies
     */
    void inject(TestingApplication app);

    void inject(Context context);

    /**
     * Used in child components
     */
    Application application();

    /**
     * Direct contact to interactor
     */
    GetUserByIdCallback getUserById();

    /**
     * Direct contact to repo
     */
    ProfileRepository profileRepository();
}

