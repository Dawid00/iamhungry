package com.depe.iamhungry;

import com.depe.iamhungry.exception.BadParamsException;
import com.depe.iamhungry.recipe.YummlyApiClient;
import com.depe.iamhungry.service.RecipeService;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import java.util.stream.Stream;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertThrows;

@SpringBootTest
public class RecipeServiceTest {

    @Autowired
    private YummlyApiClient apiClient;
    private RecipeService recipeService;

    @BeforeEach
    void setUp(){
        recipeService = new RecipeService(apiClient);
    }
    @Test
    void shouldReturnNotNullRecipeDto(){
        //when
        var result = recipeService.getRecipeDto();
        //then
        assertThat(result).isNotNull();
    }


    @Test
    void shouldReturnNotNullRecipeDtoWithNameChicken(){
        //when
        var result = recipeService.getRecipeWithName("chicken");
        //then
        assertThat(result).isNotNull();
        assertThat(result.getName().contains("Chicken")).isTrue();
    }

    @Test
    void shouldReturnNotNullRecipeDtoWithNameChickenAndLimitAndStart(){
        //when
        var result = recipeService.getRecipesWithNameAndLimit("chicken", 2, 1);
        //then
        assertThat(result).isNotNull();
        assertThat(result).hasSize(2);
        assertThat(result.get(0).getName().contains("Chicken")).isTrue();
        assertThat(result.get(1).getName().contains("Chicken")).isTrue();
    }

    private static Stream<Arguments> provideQueryParams(){
        return Stream.of(
                Arguments.of(1, -1),
                Arguments.of(0, -1),
                Arguments.of(0, 0),
                Arguments.of(1, 500),
                Arguments.of(3, 498)
        );
    }
    @ParameterizedTest
    @MethodSource("provideQueryParams")
    void shouldThrowBadQueryExceptionWhenLimit(Integer limit, Integer start){
        assertThrows(BadParamsException.class, () -> recipeService.getRecipesWithNameAndLimit("chicken", limit, start));
    }
}
