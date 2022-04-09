package com.depe.iamhungry.recipe;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
class Ingredient {
    private String ingredient;
    private double quantity;
    private String wholeLine;
    private Amount amount;
}
