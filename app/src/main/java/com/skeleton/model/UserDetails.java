package com.skeleton.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * user details
 */
public class UserDetails {
    @SerializedName("_id")
    private String _id;
    @SerializedName("createdAt")
    private String createdAt;
    @SerializedName("updatedAt")
    private String updatedAt;
    @SerializedName("dob")
    private String dob;
    @SerializedName("countryCode")
    private String countryCode;
    @SerializedName("phoneNo")
    private String phoneNo;
    @SerializedName("email")
    private String email;
    @SerializedName("orientation")
    private String orientation;
    @SerializedName("newNumber")
    private String newNumber;
    @SerializedName("userImages")
    private List<UserImages> userImages;
    @SerializedName("adminDeactivateAccount")
    private boolean adminDeactivateAccount;
    @SerializedName("timeOffset")
    private int timeOffset;
    @SerializedName("gender")
    private String gender;
    @SerializedName("aboutMe")
    private String aboutMe;
    @SerializedName("step2CompleteOrSkip")
    private boolean step2CompleteOrSkip;
    @SerializedName("step1CompleteOrSkip")
    private boolean step1CompleteOrSkip;
    @SerializedName("interestCategories")
    private List<InterestCategories> interestCategories;
    @SerializedName("profilePicURL")
    private ProfilePicURL profilePicURL;
    @SerializedName("defaultAddressId")
    private String defaultAddressId;
    @SerializedName("phoneVerified")
    private boolean phoneVerified;
    @SerializedName("emailVerified")
    private boolean emailVerified;
    @SerializedName("drinking")
    private String drinking;
    @SerializedName("smoking")
    private String smoking;
    @SerializedName("bodyType")
    private String bodyType;
    @SerializedName("height")
    private String height;
    @SerializedName("religion")
    private String religion;
    @SerializedName("ethnicity")
    private String ethnicity;
    @SerializedName("relationshipHistory")
    private String relationshipHistory;
    @SerializedName("notificationEnable")
    private boolean notificationEnable;
    @SerializedName("directDateRequestEnable")
    private boolean directDateRequestEnable;
    @SerializedName("privacy")
    private boolean privacy;
    @SerializedName("isDisable")
    private boolean isDisable;
    @SerializedName("language")
    private String language;
    @SerializedName("firstTimeLogin")
    private boolean firstTimeLogin;
    @SerializedName("lastName")
    private String lastName;
    @SerializedName("firstName")
    private String firstName;

    /**
     * @return country code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * @param countryCode country code
     */
    public void setCountryCode(final String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * @return phone no
     */
    public String getPhoneNo() {
        return phoneNo;
    }

    /**
     * @param phoneNo phone no
     */
    public void setPhoneNo(final String phoneNo) {
        this.phoneNo = phoneNo;
    }

    /**
     * @return boolean
     */
    public boolean isPhoneVerified() {
        return phoneVerified;
    }

    /**
     * @param phoneVerified yes or no
     */
    public void setPhoneVerified(final boolean phoneVerified) {
        this.phoneVerified = phoneVerified;
    }

    /**
     * @return boolean
     */
    public boolean isStep1CompleteOrSkip() {
        return step1CompleteOrSkip;
    }

    /**
     * @param step1CompleteOrSkip boolean
     */
    public void setStep1CompleteOrSkip(final boolean step1CompleteOrSkip) {
        this.step1CompleteOrSkip = step1CompleteOrSkip;
    }

    /**
     * @return boolean
     */
    public boolean isStep2CompleteOrSkip() {
        return step2CompleteOrSkip;
    }

    /**
     * @param step2CompleteOrSkip boolean
     */
    public void setStep2CompleteOrSkip(final boolean step2CompleteOrSkip) {
        this.step2CompleteOrSkip = step2CompleteOrSkip;
    }
}
