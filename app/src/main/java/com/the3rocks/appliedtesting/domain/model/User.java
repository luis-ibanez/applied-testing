package com.the3rocks.appliedtesting.domain.model;


import java.net.URL;

public class User {
    private String name;
    private String lastname;
    private String profilePictureUrl;

    public User(String name, String lastname, String profilePictureUrl) {
        this.name = name;
        this.lastname = lastname;
        this.profilePictureUrl = profilePictureUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getProfilePictureUrl() {
        return profilePictureUrl;
    }

    public void setProfilePictureUrl(String profilePictureUrl) {
        this.profilePictureUrl = profilePictureUrl;
    }
}

