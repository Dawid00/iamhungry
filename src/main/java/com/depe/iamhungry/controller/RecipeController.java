package com.depe.iamhungry.controller;


import com.depe.iamhungry.recipe.Root;
import com.depe.iamhungry.recipe.dto.RecipeDto;
import com.depe.iamhungry.service.RecipeService;
import org.springframework.stereotype.Controller;
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

    @GetMapping("/food")
    RecipeDto getRecipeWithName(@RequestParam String name) {
        return recipeService.getRecipeWithName(name);
    }

    @GetMapping("/foods")
    List<RecipeDto> getRecipesWithNameAndLimit(@RequestParam String name, @RequestParam Integer limit) {
        return recipeService.getRecipesWithNameAndLimit(name, limit, 0);
    }

    @GetMapping()
    RecipeDto getRecipe() {
        return recipeService.getRecipeDto();
    }


}
