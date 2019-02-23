package com.example.kresna.photography.data;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.annotation.Nullable;

public class Database extends SQLiteOpenHelper {
    public static final String TABLE_PHOTO = "photo";
    public static final String COLUMN_FORMAT = "format";
    public static final String COLUMN_Width = "width";
    public static final String COLUMN_HEIGHT = "height";
    public static final String COLUMN_FILENAME = "filename";
    public static final String COLUMN_ID = "id";
    public static final String COLUMN_AUTHOR = "author";
    public static final String COLUMN_AUTHOR_URL = "author_url";
    public static final String COLUMN_POST_URL = "post_url";
    public static final String SQL_CREATE_TABLE_FOTO = String.format("CREATE TABLE %s" +
            "(%s INTEGER PRIMARY KEY, " +
            "%s TEXT NULL, " +
            "%s TEXT NULL, " +
            "%s TEXT NULL, " +
            "%s TEXT NULL, " +
            "%s TEXT NULL, " +
            "%s TEXT NULL, " +
            "%s TEXT NULL " +
            ")",
            TABLE_PHOTO,
            COLUMN_ID,
            COLUMN_FORMAT,
            COLUMN_Width,
            COLUMN_HEIGHT,
            COLUMN_FILENAME,
            COLUMN_AUTHOR,
            COLUMN_AUTHOR_URL,
            COLUMN_POST_URL);

    public Database(@Nullable Context context) {
        super(context, "db_photography.db", null, 2);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        sqLiteDatabase.execSQL(SQL_CREATE_TABLE_FOTO);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int oldVersion, int newVersion) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + TABLE_PHOTO);
        onCreate(sqLiteDatabase);

    }
}
