package com.depe.iamhungry.recipe;


import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
class Details {
    private String totalTime;
    private String displayName;
    private String name;
    private String numberOfServings;
    private double totalTimeInSeconds;
}
