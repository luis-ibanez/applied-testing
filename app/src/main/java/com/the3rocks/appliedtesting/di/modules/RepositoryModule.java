package com.the3rocks.appliedtesting.di.modules;

import com.the3rocks.appliedtesting.repository.profile.ProfileRepository;
import com.the3rocks.appliedtesting.repository.profile.ProfileRepositoryFakeImpl;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public ProfileRepository providesProfileRepository(ProfileRepositoryFakeImpl profileRepositoryFake) {
        return profileRepositoryFake;
    }
}
