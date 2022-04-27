package com.depe.iamhungry.recipe;

import java.util.List;

class Nutrition {
        private List<NutritionEstimate> nutritionEstimates;

        List<NutritionEstimate> getNutritionEstimates() {
                return nutritionEstimates;
        }
}


class NutritionEstimate{
        private String attribute;
        private double value;
        private Unit unit;

        String getAttribute() {
                return attribute;
        }

        double getValue() {
                return value;
        }

        Unit getUnit() {
                return unit;
        }
}