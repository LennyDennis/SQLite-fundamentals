package com.lennydennis.sqlite.Database;

import android.provider.BaseColumns;

public class DatabaseContract {

    public DatabaseContract() {
    }

    public static final class CustomerEntry implements BaseColumns{

        public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
        public static final String COLUMN_CUSTOMER_NAME = "CUSTOMER_NAME";
        public static final String COLUMN_CUSTOMER_AGE = "CUSTOMER_AGE";
        public static final String COLUMN_ID = "ID";
        public static final String COLUMN_ACTIVE = "ACTIVE";

    }

}
