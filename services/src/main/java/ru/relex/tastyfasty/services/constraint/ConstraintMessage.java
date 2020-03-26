package ru.relex.tastyfasty.services.constraint;

public final class ConstraintMessage {

    public static class Field {

        public static final String USERNAME = "USERNAME";
        public static final String PASSWORD = "PASSWORD";
        public static final String FIRST_NAME = "FIRSTNAME";
        public static final String MIDDLE_NAME = "MIDDLENAME";
        public static final String LAST_NAME = "LASTNAME";
        public static final String ROLE = "ROLE";
        public static final String PERSONAL_INFO = "PERSONALINFO";

        public static final String RESTAURANT_NAME = "RESTAURANTNAME";
        public static final String RESTAURANT_TAGS = "RESTAURANTTAGS";
        public static final String RESTAURANT_RATING = "RESTAURANTRATING";
        public static final String RESTAURANT_TIME = "RESTAURANTTIME";
        public static final String RESTAURANT_INFO = "RESTAURANTINFO";

        public static final String ORDER_INFO = "ORDERINFO";
        public static final String ORDER_NAME = "ORDERNAME";
        public static final String ORDER_TAG = "ORDERTAG";
        public static final String STATUS = "STATUS";

        public static final String BREAKFAST_NAME = "ORDERNAME";
        public static final String BREAKFAST_TAG = "BREAKFASTTAG";

        public static final String CITY = "CITY";
        public static final String STREET = "CITY";
        public static final String BUILDING = "CITY";

        public static final String PRICE = "PRICE";

    }

    public static class Constraint {

        public static final String IS_NULL = "_NULL";
        public static final String IS_EMPTY = "_EMPTY";
        public static final String TOO_LONG = "_TOOLONG";
        public static final String TOO_SHORT = "_TOOSHORT";
    }

}
