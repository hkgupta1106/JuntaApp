package com.skeleton.model.profile;

import com.google.gson.annotations.SerializedName;

import java.util.List;

/**
 * data model
 */
public class Data {
    @SerializedName("Orientation")
    private List<String> orientation;
    @SerializedName("RelationshipHistory")
    private List<String> relationshipHistory;
    @SerializedName("Ethnicity")
    private List<String> ethnicity;
    @SerializedName("Religion")
    private List<String> religion;
    @SerializedName("BodyType")
    private List<String> bodyType;
    @SerializedName("Smoking")
    private List<String> smoking;
    @SerializedName("Drinking")
    private List<String> drinking;
    @SerializedName("Height")
    private List<String> height;

    /**
     * @return orientation
     */
    public List<String> getOrientation() {
        return orientation;
    }

    /**
     * @param orientation orientation
     */
    public void setOrientation(final List<String> orientation) {
        this.orientation = orientation;
    }

    /**
     * @return history
     */
    public List<String> getRelationshipHistory() {
        return relationshipHistory;
    }

    /**
     * @param relationshipHistory history
     */
    public void setRelationshipHistory(final List<String> relationshipHistory) {
        this.relationshipHistory = relationshipHistory;
    }

    /**
     * @return ethenicity
     */
    public List<String> getEthnicity() {
        return ethnicity;
    }

    /**
     * @param ethnicity ethinicity
     */
    public void setEthnicity(final List<String> ethnicity) {
        this.ethnicity = ethnicity;
    }

    /**
     * @return religion
     */
    public List<String> getReligion() {
        return religion;
    }

    /**
     * @param religion religion
     */
    public void setReligion(final List<String> religion) {
        this.religion = religion;
    }

    /**
     * @return body type
     */
    public List<String> getBodyType() {
        return bodyType;
    }

    /**
     * @param bodyType bodytype
     */
    public void setBodyType(final List<String> bodyType) {
        this.bodyType = bodyType;
    }

    /**
     * @return smoking
     */
    public List<String> getSmoking() {
        return smoking;
    }

    /**
     * @param smoking smoking
     */
    public void setSmoking(final List<String> smoking) {
        this.smoking = smoking;
    }

    /**
     * @return drinking
     */
    public List<String> getDrinking() {
        return drinking;
    }

    /**
     * @param drinking drinking
     */
    public void setDrinking(final List<String> drinking) {
        this.drinking = drinking;
    }

    /**
     * @return ht
     */
    public List<String> getHeight() {
        return height;
    }

    /**
     * @param height ht
     */
    public void setHeight(final List<String> height) {
        this.height = height;
    }
}
