package com.depe.iamhungry.recipe.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class RecipeDto {


    private List<IngredientDto> ingredients;
    private List<InstructionDto> instructions;
    private List<NutritionDto> nutrition;
    private String totalTime;
    private String description;
    private String name;
    private String numberOfServings;

}
