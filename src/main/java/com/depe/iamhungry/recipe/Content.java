package com.depe.iamhungry.recipe;


import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
class Content {
    private Description description;
    private Details details;
    private List<Ingredient> ingredientLines;
    private Tags tags;
    private List<String> preparationSteps;
    private Nutrition nutrition;
}
