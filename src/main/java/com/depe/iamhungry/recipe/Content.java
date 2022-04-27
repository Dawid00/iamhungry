package com.depe.iamhungry.recipe;


import java.util.List;

class Content {
    private Description description;
    private Details details;
    private List<Ingredient> ingredientLines;
    private Tags tags;
    private List<String> preparationSteps;
    private Nutrition nutrition;

    Description getDescription() {
        return description;
    }

    Details getDetails() {
        return details;
    }

    List<Ingredient> getIngredientLines() {
        return ingredientLines;
    }

    Tags getTags() {
        return tags;
    }

    List<String> getPreparationSteps() {
        return preparationSteps;
    }

    Nutrition getNutrition() {
        return nutrition;
    }
}
