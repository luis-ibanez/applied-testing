package com.the3rocks.appliedtesting.di.components;

import com.the3rocks.appliedtesting.di.modules.ActivityModule;
import com.the3rocks.appliedtesting.di.scopes.ActivityScope;
import com.the3rocks.appliedtesting.ui.profile.ProfileActivity;

import dagger.Component;

@ActivityScope
@Component(dependencies = ApplicationComponent.class,
        modules = {
                ActivityModule.class
        })
public interface ProfileComponent extends AbstractActivityComponent {
    void inject(ProfileActivity profileActivity);
}
