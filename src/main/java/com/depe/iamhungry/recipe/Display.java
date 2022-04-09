package com.depe.iamhungry.recipe;

import lombok.Getter;

@Getter
class Display {

    private String displayName;

    @Override
    public String toString() {
        return "Display{" +
                "displayName='" + displayName + '\'' +
                '}';
    }


}
