package com.depe.iamhungry.recipe;

import lombok.Getter;
import lombok.ToString;

import java.util.List;

@Getter
@ToString
class Nutrition {
        private List<NutritionEstimate> nutritionEstimates;
}

@Getter
@ToString
class NutritionEstimate{
        private String attribute;
        private double value;
        private Unit unit;
}