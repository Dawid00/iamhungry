package com.depe.iamhungry.service;
import com.depe.iamhungry.recipe.RecipeDtoProducer;
import com.depe.iamhungry.recipe.YummlyApiClient;
import com.depe.iamhungry.recipe.Root;
import com.depe.iamhungry.recipe.dto.RecipeDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RecipeService {

    private final YummlyApiClient yummlyApiClient;

    public RecipeService(YummlyApiClient yummlyApiClient) {
        this.yummlyApiClient = yummlyApiClient;
    }


    public RecipeDto getRecipeDto() {
        return RecipeDtoProducer.recipeDtoFromRoot(yummlyApiClient.getRecipe(randomStart()));
    }

    private static int randomStart(){
        Random random = new Random();
        return random.nextInt(499);
    }

    public RecipeDto getRecipeWithName(String name) {
        return RecipeDtoProducer.recipeDtoFromRoot(yummlyApiClient.getRecipeWithName(name));
    }

    public List<RecipeDto> getRecipesWithNameAndLimit(String name, Integer limit, Integer start) {
        Root root = yummlyApiClient.getRecipesWithNameAndLimitAndStart(name, limit,start);
        return RecipeDtoProducer.recipeDtoListFromRoot(root);
    }
}
