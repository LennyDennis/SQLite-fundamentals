package com.lennydennis.sqlite.Database;

import android.content.ContentValues;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

import com.lennydennis.sqlite.Model.Customer;

public class DatabaseOpenHelper extends SQLiteOpenHelper {

    private static final String DATABASE_NAME = "customer.db";
    private static final int DATABASE_VERSION = 1;
    public static final String CUSTOMER_TABLE = "CUSTOMER_TABLE";
    public static final String COLUMN_CUSTOMER_NAME = "CUSTOMER_NAME";
    public static final String COLUMN_CUSTOMER_AGE = "CUSTOMER_AGE";
    public static final String COLUMN_ID = "ID";
    public static final String COLUMN_ACTIVE = "ACTIVE";

    public DatabaseOpenHelper(@Nullable Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createCustomerTable = "CREATE TABLE " + CUSTOMER_TABLE + " (" +
                COLUMN_ID + " INTEGER PRIMARY KEY AUTOINCREMENT," +
                COLUMN_CUSTOMER_NAME + " TEXT," +
                COLUMN_CUSTOMER_AGE + " INTEGER," +
                COLUMN_ACTIVE + " BOOL )";

        db.execSQL(createCustomerTable);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }

    public boolean addOne(Customer customer){
        SQLiteDatabase database = this.getWritableDatabase();
        ContentValues contentValues = new ContentValues();
        contentValues.put(COLUMN_CUSTOMER_NAME,customer.getCustomerName());
        contentValues.put(COLUMN_CUSTOMER_AGE,customer.getCustomerAge());
        contentValues.put(COLUMN_ACTIVE,customer.getActive());

        long insert = database.insert(CUSTOMER_TABLE, null, contentValues);
        if(insert == -1){
            return false;
        }else{
            return true;
        }
    }
}
