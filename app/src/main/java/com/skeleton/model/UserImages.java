package com.skeleton.model;

import com.google.gson.annotations.SerializedName;

/**
 * user image
 */
public class UserImages {
    @SerializedName("_id")
    private String _id;
    @SerializedName("thumbnail")
    private String thumbnail;
    @SerializedName("original")
    private String original;

    /**
     * @return id
     */
    public String get_id() {
        return _id;
    }

    /**
     * @param id id
     */
    public void set_id(final String id) {
        this._id = id;
    }

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
