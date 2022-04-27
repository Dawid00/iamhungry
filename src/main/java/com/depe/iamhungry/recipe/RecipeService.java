package com.depe.iamhungry.recipe;
import com.depe.iamhungry.client.BadParamsException;
import com.depe.iamhungry.client.YummlyApiClient;
import com.depe.iamhungry.recipe.dto.RecipeDto;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Random;

@Service
public class RecipeService {

    private final YummlyApiClient yummlyApiClient;

    public RecipeService(final YummlyApiClient yummlyApiClient) {
        this.yummlyApiClient = yummlyApiClient;
    }

    public RecipeDto getRecipeDto() {
        return RecipeDtoProducer.recipeDtoFromRoot(yummlyApiClient.getResponseBodyWithRecipe(randomStart()));
    }

    public RecipeDto getRecipeWithName(String name){
        return RecipeDtoProducer.recipeDtoFromRoot(yummlyApiClient.getResponseBodyWithRecipeWithName(name));
    }

    public List<RecipeDto> getRecipesWithNameAndLimit(String name, Integer limit, Integer start){
        if(limit == null){
            limit = 3;
        }
        if(start == null){
            start = 0;
        }
        validParams(start, limit);
        Root root = RecipeDtoProducer.getRootFromResponseBodyInJson(yummlyApiClient.getResponseBodyWithRecipesWithNameAndLimitAndStart(name, limit, start));
        return RecipeDtoProducer.recipeDtoListFromRoot(root);
    }

    private static void validParams(int start, int limit){
        if ((limit + start) > 500 || limit < 1 || start < 0 ){
            throw new BadParamsException();
        }
    }

    private static int randomStart(){
        Random random = new Random();
        return random.nextInt(499);
    }
}
