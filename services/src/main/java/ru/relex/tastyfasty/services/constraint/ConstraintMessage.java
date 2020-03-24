package ru.relex.tastyfasty.services.constraint;

public final class ConstraintMessage {
    private ConstraintMessage() {
    }

    public static class Field {

        private Field() {
        }

        public static final String USERNAME = "USERNAME";
        public static final String PASSWORD = "PASSWORD";
        public static final String FIRST_NAME = "FIRSTNAME";
        public static final String LAST_NAME = "LASTNAME";
        public static final String ROLE = "ROLE";
        public static final String MIDDLE_NAME = "MIDDLENAME";
        public static final String PERSONAL_INFO = "PERSONALINFO";

        public static final String RESTAURANT_NAME = "RESTAURANTNAME";
        public static final String RESTAURANT_TAGS = "RESTAURANTTAGS";
        public static final String RESTAURANT_RATING = "RESTAURANTRATING";
        public static final String RESTAURANT_TIME = "RESTAURANTTIME";
        public static final String RESTAURANT_INFO = "RESTAURANTINFO";



    }

    public static class Constraint {
        private Constraint() {
        }

        public static final String IS_NULL = "_NULL";
        public static final String IS_EMPTY = "_EMPTY";
        public static final String TOO_LONG = "_TOOLONG";
        public static final String TOO_SHORT = "_TOOSHORT";
    }

}
