package com.skeleton.model;

import com.google.gson.annotations.SerializedName;

/**
 * data model
 */
public class Data {
    @SerializedName("accessToken")
    private String accessToken;
    @SerializedName("userDetails")
    private UserDetails userDetails;

    /**
     * @return access token
     */
    public String getAccessToken() {
        return accessToken;
    }

    /**
     * @param accessToken access token
     */
    private void setAccessToken(final String accessToken) {
        this.accessToken = accessToken;
    }

    /**
     * @return user details
     */
    public UserDetails getUserDetails() {
        return userDetails;
    }

    /**
     * @param userDetails user details
     */
    private void setUserDetails(final UserDetails userDetails) {
        this.userDetails = userDetails;
    }
}
