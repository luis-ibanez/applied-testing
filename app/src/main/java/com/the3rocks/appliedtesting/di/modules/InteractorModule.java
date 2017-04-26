package com.the3rocks.appliedtesting.di.modules;


import com.the3rocks.appliedtesting.domain.profile.GetUserByIdCallback;
import com.the3rocks.appliedtesting.domain.profile.GetUserByIdCallbackInteractor;
import com.the3rocks.appliedtesting.repository.profile.ProfileRepository;
import com.the3rocks.appliedtesting.repository.profile.ProfileRepositoryFakeImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class InteractorModule {

    @Provides
    @Singleton
    public GetUserByIdCallback providesGetUserById(GetUserByIdCallbackInteractor getUserById) {
        return getUserById;
    }
}
