package com.depe.iamhungry.recipe;

import lombok.Getter;
import lombok.ToString;

@Getter
@ToString
class Unit {
        private String name;
        private String abbreviation;
        private String plural;
        private String pluralAbbreviation;
        private String kind;
        private boolean decimal;
}