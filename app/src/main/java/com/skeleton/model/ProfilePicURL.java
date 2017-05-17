package com.skeleton.model;

import com.google.gson.annotations.SerializedName;

/**
 * profie pic model
 */
public class ProfilePicURL {
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("original")
    private String original;

    /**
     * @return thumbnail
     */
    public String getThumbnail() {
        return thumbnail;
    }

    /**
     * @param thumbnail thumbnail
     */
    public void setThumbnail(final String thumbnail) {
        this.thumbnail = thumbnail;
    }

    /**
     * @return original
     */
    public String getOriginal() {
        return original;
    }

    /**
     * @param original original
     */
    public void setOriginal(final String original) {
        this.original = original;
    }
}
