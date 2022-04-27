package com.depe.iamhungry.recipe;

import com.google.gson.annotations.SerializedName;

import java.util.List;

class Tags {
    private List<Tag> cuisine;
    private List<Tag> nutrition;
    private List<Tag> technique;
    private List<Tag> equipment;
    private List<Tag> difficulty;

    List<Tag> getCuisine() {
        return cuisine;
    }

    List<Tag> getNutrition() {
        return nutrition;
    }

    List<Tag> getTechnique() {
        return technique;
    }

    List<Tag> getEquipment() {
        return equipment;
    }

    List<Tag> getDifficulty() {
        return difficulty;
    }
}

class Tag{
    @SerializedName("display-name")
    private String displayName;

    String getDisplayName() {
        return displayName;
    }
}

