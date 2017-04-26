package com.the3rocks.appliedtesting.domain.profile;

import com.the3rocks.appliedtesting.domain.model.User;
import com.the3rocks.appliedtesting.executor.Executor;
import com.the3rocks.appliedtesting.executor.Interactor;
import com.the3rocks.appliedtesting.executor.MainThread;
import com.the3rocks.appliedtesting.repository.profile.ProfileRepository;



import javax.inject.Inject;

public class GetUserByIdCallbackInteractor implements Interactor, GetUserByIdCallback {

    private final Executor executor;
    private final MainThread mainThread;

    private final ProfileRepository profileRepository;

    private String userId;
    private Callback callback;

    @Inject
    GetUserByIdCallbackInteractor(Executor executor, MainThread mainThread, ProfileRepository profileRepository) {
        this.executor = executor;
        this.mainThread = mainThread;
        this.profileRepository = profileRepository;
    }

    @Override public void execute(final String userId, final Callback callback) {
        this.callback = callback;
        this.userId = userId;
        this.executor.run(this);
    }

    @Override public void run() {
        User user = profileRepository.getUserById(userId);
        if(user != null){
            notifyUserFound(user);
        }else{
            notifyUserNotFound();
        }

    }

    private void notifyConnectionError() {
        mainThread.post(new Runnable() {
            @Override public void run() {
                callback.onConnectionError();
            }
        });
    }

    private void notifyUserFound(final User user) {
        mainThread.post(new Runnable() {
            @Override public void run() {
                callback.onUserLoaded(user);
            }
        });
    }

    private void notifyUserNotFound() {
        mainThread.post(new Runnable() {
            @Override public void run() {
                callback.onUserNotFound();
            }
        });
    }
}
