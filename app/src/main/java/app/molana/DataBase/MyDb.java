package app.molana.DataBase;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteQueryBuilder;

import com.readystatesoftware.sqliteasset.SQLiteAssetHelper;

import java.util.ArrayList;
import java.util.List;

public class MyDb extends SQLiteAssetHelper {

    private static final String DB_NAME = "Molana.db";
    private static final int DB_VERSION = 1;


    public MyDb(Context context) {
        super(context, DB_NAME, null, DB_VERSION);
    }

    public List<FiheMaFih> getAllData() {

        SQLiteDatabase db = getReadableDatabase();
        SQLiteQueryBuilder sqLiteQueryBuilder = new SQLiteQueryBuilder();

        String[] sql_select = {"id", "favorite", "title", "content"};
        String TABLE_NAME = "FiheMaFih";

        sqLiteQueryBuilder.setTables(TABLE_NAME);
        Cursor cursor = sqLiteQueryBuilder.query(db, sql_select, null, null, null, null, null);
        List<FiheMaFih> result = new ArrayList<>();


        if (cursor.moveToFirst()) {
            do {
                FiheMaFih fiheMaFih = new FiheMaFih();
                fiheMaFih.setId(cursor.getInt(cursor.getColumnIndexOrThrow("id")));
                fiheMaFih.setId(cursor.getInt(cursor.getColumnIndexOrThrow("favorite")));
                fiheMaFih.setTitle(cursor.getString(cursor.getColumnIndexOrThrow("title")));
                fiheMaFih.setContent(cursor.getString(cursor.getColumnIndexOrThrow("content")));

                result.add(fiheMaFih);

            } while (cursor.moveToNext());
        }

        return result;
    }




}




