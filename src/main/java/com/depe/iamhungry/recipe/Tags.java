package com.depe.iamhungry.recipe;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonValue;
import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.google.gson.annotations.SerializedName;
import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
class Tags {
    private List<Tag> cuisine;
    private List<Tag> nutrition;
    private List<Tag> technique;
    private List<Tag> equipment;
    private List<Tag> difficulty;
}

@Getter
@ToString
class Tag{
    @SerializedName("display-name")
    String displayName;
}

