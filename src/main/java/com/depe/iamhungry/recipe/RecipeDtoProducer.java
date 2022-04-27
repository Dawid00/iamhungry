package com.depe.iamhungry.recipe;

import com.depe.iamhungry.recipe.dto.IngredientDto;
import com.depe.iamhungry.recipe.dto.InstructionDto;
import com.depe.iamhungry.recipe.dto.NutritionDto;
import com.depe.iamhungry.recipe.dto.RecipeDto;
import com.google.gson.Gson;
import okhttp3.ResponseBody;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

@Component
public class RecipeDtoProducer {

    public static Root getRootFromResponseBodyInJson(ResponseBody responseBody) {
        Gson gson = new Gson();
        try{
            return gson.fromJson(responseBody.string(), Root.class);
        }
        catch (IOException exception){
            throw new IllegalArgumentException();
        }
    }

    public static RecipeDto recipeDtoFromRoot(ResponseBody responseBody) {
        Root root = getRootFromResponseBodyInJson(responseBody);
        List<Feed> feed = root.getFeed();
        if(feed.size() == 1){
            return recipeDtoFromFeed(feed.get(0));
        }
        throw new RuntimeException();
    }
    public static List<RecipeDto> recipeDtoListFromRoot(Root root) {
        List<Feed> feed = root.getFeed();
        return feed.stream()
                .map(RecipeDtoProducer::recipeDtoFromFeed)
                .collect(Collectors.toList());
    }

    private static RecipeDto recipeDtoFromFeed(Feed feed){
        Content content = feed.getContent();
        Details details = content.getDetails();
        RecipeDto.RecipeDtoBuilder recipeDtoBuilder = RecipeDto.builder();
            if (Objects.nonNull(details.getNumberOfServings())) {
                recipeDtoBuilder.numberOfServings(details.getNumberOfServings());
            }

            if (Objects.nonNull(content.getDescription())) {
                recipeDtoBuilder.description(content.getDescription().getText());
            }

            if (Objects.nonNull(details.getName())) {
                recipeDtoBuilder.name(details.getName());
            }

            if (Objects.nonNull(details.getTotalTime())) {
                recipeDtoBuilder.totalTime(details.getTotalTime());
            }

            if (Objects.nonNull(content.getIngredientLines())) {
                recipeDtoBuilder.ingredients(fromIngredientLine(content.getIngredientLines()));
            }

            if (Objects.nonNull(content.getPreparationSteps())) {
                recipeDtoBuilder.instructions(fromPreparationsSteps(content.getPreparationSteps()));
            }
            if (Objects.nonNull(content.getNutrition())) {
                recipeDtoBuilder.nutrition(fromNutrition(content.getNutrition()));
            }

        return recipeDtoBuilder.build();
    }

    private static List<NutritionDto> fromNutrition(Nutrition nutrition) {
        return nutrition.getNutritionEstimates().stream()
                .filter(n -> n.getAttribute().equals("ENERC_KCAL"))
                .map(n -> NutritionDto.builder().kcal(n.getValue()).build())
                .collect(Collectors.toList());

    }
    private static List<IngredientDto> fromIngredientLine(List<Ingredient> ingredientLines){
        return ingredientLines.stream()
                .map(ingredient -> IngredientDto.builder()
                        .ingredient(ingredient.getIngredient())
                        .wholeLine(ingredient.getWholeLine())
                        .quantity(ingredient.getQuantity())
                        .build())
                .collect(Collectors.toList());
    }
    private static List<InstructionDto> fromPreparationsSteps(List<String> preparationSteps){
        return preparationSteps.stream()
                .map(InstructionDto::new)
                .collect(Collectors.toList());
    }

}
