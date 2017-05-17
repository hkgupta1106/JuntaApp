package com.skeleton.model.profile;

import com.google.gson.annotations.SerializedName;

/**
 * Created by himanshu on 17/5/17.
 */

public class Response {


    @SerializedName("statusCode")
    private int statusCode;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private Data data;

    /**
     * @return status code
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode status code
     */
    public void setStatusCode(final int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return message
     */
    public String getMessage() {
        return message;
    }

    /**
     * @param message message
     */
    public void setMessage(final String message) {
        this.message = message;
    }

    /**
     * @return data
     */
    public Data getData() {
        return data;
    }

    /**
     * @param data data
     */
    public void setData(final Data data) {
        this.data = data;
    }
}
