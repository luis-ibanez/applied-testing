package com.the3rocks.appliedtesting.ui.profile;


import com.the3rocks.appliedtesting.domain.model.User;
import com.the3rocks.appliedtesting.domain.profile.GetUserByIdCallback;

import javax.inject.Inject;

public class ProfilePresenter {

    private final GetUserByIdCallback getUserById;
    private User currentUser;

    @Inject
    public ProfilePresenter(GetUserByIdCallback getUserById) {
        this.getUserById = getUserById;
    }

    private View view;

    public void setView(View view) {
        if (view == null) {
            throw new IllegalArgumentException("The view should be instantiated");
        }
        this.view = view;
    }

    public void loadUser(final String userId) {
        view.showLoading();
        getUserById.execute(userId, new GetUserByIdCallback.Callback() {
            @Override
            public void onUserLoaded(User user) {
                currentUser = user;
                if(view.isReady()){
                    view.showUserCompleteName(user.getName(), user.getLastname());
                    view.showUserImage(user.getProfilePictureUrl());
                    view.hideLoading();
                }
            }

            @Override
            public void onUserNotFound() {
                if(view.isReady()) {
                    view.showUserNotFoundMessage();
                }
            }

            @Override
            public void onConnectionError() {
                if(view.isReady()){
                    view.showConnectionErrorMessage();

                }
            }
        });
    }


    public interface View {

        void showLoading();

        void hideLoading();

        void showUserCompleteName(final String name, final String lastname);

        void showUserImage(String url);

        void showUserNotFoundMessage();

        void showConnectionErrorMessage();

        boolean isReady();
    }
}
