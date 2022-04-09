package com.depe.iamhungry.recipe.dto;

import lombok.Builder;
import lombok.Data;
import java.util.List;

@Data
@Builder
public class RecipeDto {


    private List<IngredientDto> ingredientDtoList;
    private List<InstructionDto> instructionDtoList;
    private List<NutritionDto> nutritionDtoList;
    private String totalTime;
    private String description;
    private String name;
    private String numberOfServings;

}
