package com.skeleton.model;

import android.os.Parcel;
import android.os.Parcelable;

import com.google.gson.annotations.SerializedName;


/**
 * model class
 */
public class SignUpResponseModel implements Parcelable {

    public static final Creator<SignUpResponseModel> CREATOR = new Creator<SignUpResponseModel>() {
        @Override
        public SignUpResponseModel createFromParcel(final Parcel in) {
            return new SignUpResponseModel(in);
        }

        @Override
        public SignUpResponseModel[] newArray(final int size) {
            return new SignUpResponseModel[size];
        }
    };

    @SerializedName("statusCode")
    private int statusCode;
    @SerializedName("message")
    private String message;
    @SerializedName("data")
    private Data data;


    /**
     * @param in in
     */
    protected SignUpResponseModel(final Parcel in) {
        statusCode = in.readInt();
        message = in.readString();
    }

    @Override
    public void writeToParcel(final Parcel dest, final int flags) {
        dest.writeInt(statusCode);
        dest.writeString(message);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    /**
     * @return status code
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * @param statusCode status code
     */
    private void setStatusCode(final int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * @return get message
     */
    private String getMessage() {
        return message;
    }

    /**
     * @param message set message
     */
    private void setMessage(final String message) {
        this.message = message;
    }

    /**
     * @return get data
     */
    public Data getData() {
        return data;
    }

    /**
     * @param data set data
     */
    private void setData(final Data data) {
        this.data = data;
    }
}
