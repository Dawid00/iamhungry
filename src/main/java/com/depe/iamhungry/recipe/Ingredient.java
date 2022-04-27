package com.depe.iamhungry.recipe;

class Ingredient {
    private String ingredient;
    private double quantity;
    private String wholeLine;
    private Amount amount;

    String getIngredient() {
        return ingredient;
    }

    double getQuantity() {
        return quantity;
    }

    String getWholeLine() {
        return wholeLine;
    }

    Amount getAmount() {
        return amount;
    }
}
