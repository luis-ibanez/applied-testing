package com.the3rocks.appliedtesting.di.components;


import android.app.Activity;


import com.the3rocks.appliedtesting.di.modules.ActivityModule;
import com.the3rocks.appliedtesting.di.scopes.ActivityScope;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class,
        modules = ActivityModule.class)
public interface AbstractActivityComponent {
    /**
     * Expose the activity to sub-graphs.
     */
    Activity activityContext();
}
