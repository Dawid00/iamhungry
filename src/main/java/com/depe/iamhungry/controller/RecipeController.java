package com.depe.iamhungry.controller;

import com.depe.iamhungry.recipe.dto.RecipeDto;
import com.depe.iamhungry.service.RecipeService;
import org.springframework.http.ResponseEntity;
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
    ResponseEntity<List<RecipeDto>> getRecipesWithNameAndLimitAndStart(@RequestParam String name, @RequestParam(defaultValue = "3") Integer limit, @RequestParam(defaultValue = "0") Integer start) {
        return ResponseEntity.ok(recipeService.getRecipesWithNameAndLimit(name, limit, start));
    }

    @GetMapping("/one")
    ResponseEntity<RecipeDto> getRecipe() {
        return ResponseEntity.ok(recipeService.getRecipeDto());
    }
}
