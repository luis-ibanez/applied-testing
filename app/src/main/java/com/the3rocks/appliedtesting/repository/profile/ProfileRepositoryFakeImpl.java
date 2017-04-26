package com.the3rocks.appliedtesting.repository.profile;


import android.util.Log;

import com.the3rocks.appliedtesting.domain.model.User;
import com.the3rocks.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

import javax.inject.Inject;

public class ProfileRepositoryFakeImpl implements ProfileRepository{

    public static final int FAKE_WAIT_IN_MILLIS = 500;

    @Inject
    public ProfileRepositoryFakeImpl(){}

    @Override
    public List<User> getUsers() {
        List<User> users = new ArrayList<>();
        for (int i = 0 ; i < 6 ; i++){
            users.add(generateUser());
        }
        fakeDelay();
        return users;
    }

    @Override
    public User getUserById(String id) {
        fakeDelay();
        return generateUser();
    }

    private void fakeDelay(){
        try {
            Thread.sleep(FAKE_WAIT_IN_MILLIS);
        } catch (InterruptedException e) {
            e.printStackTrace();
            Log.e(ProfileRepositoryFakeImpl.class.getName(), "Error on the thread sleep");
        }
    }

    private User generateUser(){
        return new User(
                StringUtils.randomString(5),
                StringUtils.randomString(8),
                "ttp://placehold.it/300x300");
    }
}
