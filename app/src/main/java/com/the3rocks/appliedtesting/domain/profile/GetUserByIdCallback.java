package com.the3rocks.appliedtesting.domain.profile;


import com.the3rocks.appliedtesting.domain.model.User;

public interface GetUserByIdCallback {

    interface Callback {
        void onUserLoaded(final User user);

        void onUserNotFound();

        void onConnectionError();
    }

    void execute(final String tvShowId, final Callback callback);

}
