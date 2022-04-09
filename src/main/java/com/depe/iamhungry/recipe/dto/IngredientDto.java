package com.depe.iamhungry.recipe.dto;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@Builder
@AllArgsConstructor
public class IngredientDto {

    private String ingredient;
    private double quantity;
    private String wholeLine;


}
