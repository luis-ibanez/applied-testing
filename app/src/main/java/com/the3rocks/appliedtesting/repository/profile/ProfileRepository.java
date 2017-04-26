package com.the3rocks.appliedtesting.repository.profile;


import com.the3rocks.appliedtesting.domain.model.User;

import java.util.List;

public interface ProfileRepository {

    List<User> getUsers();
    User getUserById(String id);

}
