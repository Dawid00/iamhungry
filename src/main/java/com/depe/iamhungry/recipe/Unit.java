package com.depe.iamhungry.recipe;

class Unit {
        private String name;
        private String abbreviation;
        private String plural;
        private String pluralAbbreviation;
        private String kind;
        private boolean decimal;

        String getName() {
                return name;
        }

        String getAbbreviation() {
                return abbreviation;
        }

        String getPlural() {
                return plural;
        }

        String getPluralAbbreviation() {
                return pluralAbbreviation;
        }

        String getKind() {
                return kind;
        }

        boolean isDecimal() {
                return decimal;
        }
}