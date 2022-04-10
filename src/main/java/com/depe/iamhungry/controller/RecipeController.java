package com.depe.iamhungry.controller;

import com.depe.iamhungry.recipe.dto.RecipeDto;
import com.depe.iamhungry.service.RecipeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping("/api/recipes")
class RecipeController {

    private final RecipeService recipeService;

    RecipeController(RecipeService recipeService) {
        this.recipeService = recipeService;
    }

    @GetMapping()
    List<RecipeDto> getRecipesWithNameAndLimitAndStart(@RequestParam String name, @RequestParam(required = false) Integer limit, @RequestParam(required = false) Integer start) {
        if(limit == null){
            limit = 3;
        }
        if(start == null){
            start = 0;
        }
        return recipeService.getRecipesWithNameAndLimit(name, limit, start);
    }

    @GetMapping("/one")
    RecipeDto getRecipe() {
        return recipeService.getRecipeDto();
    }
}
