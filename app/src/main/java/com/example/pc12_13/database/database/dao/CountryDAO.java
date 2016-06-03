package com.example.pc12_13.database.database.dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;

import com.example.pc12_13.database.database.DBContext;
import com.example.pc12_13.database.model.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryDAO {
    private Context context;
    private DBContext dbContext;

    public CountryDAO(Context context) {
        this.context = context;
        dbContext = new DBContext(context);
    }

    /**
     * Insert one country
     * @param country
     * @return id
     */
    public long insert(Country country) {
        SQLiteDatabase database = dbContext.getWritableDatabase();

        long id = database.insert(Country.TABLE_NAME, null, mapContentValues(country));

        database.close();
        return id ;
    }

    /**
     * Insert list country
     * @param countries
     * @return record insert
     */
    public int insert(List<Country> countries) {
        SQLiteDatabase database = dbContext.getWritableDatabase();

        database.beginTransaction();
        int count = 0;
        try {
            for (Country country : countries) {
                database.insert(Country.TABLE_NAME, null, mapContentValues(country));
            }

            database.setTransactionSuccessful();
            count = countries.size();
        } catch (SQLiteException e){

        }

        database.endTransaction();

        database.close();
        return count;
    }

    public int update(Country country) {
        SQLiteDatabase database = dbContext.getWritableDatabase();

        int count = database.update(Country.TABLE_NAME, mapContentValues(country), Country.COL_ID +  "=?", new String[] { country.getId() + ""});

        database.close();
        return count;
    }

    public int delete(long id) {
        SQLiteDatabase database = dbContext.getWritableDatabase();

        int count = database.delete(Country.TABLE_NAME, Country.COL_ID + "=?", new String[] {id + ""});
        return count;
    }


    public List<Country> get() {
        SQLiteDatabase database = dbContext.getReadableDatabase();

        Cursor cursor = database.query(Country.TABLE_NAME, null, null, null, null, null, null);

        List<Country> countries = fetchAll(cursor);

        database.close();
        return countries;
    }

    public Country get(long id) {
        return null;
    }

    private ContentValues mapContentValues(Country country) {
        ContentValues contentValues = new ContentValues();

        contentValues.put(Country.COL_NAME_EN, country.getNameEn());
        contentValues.put(Country.COL_NAME_VI, country.getNameVi());
        contentValues.put(Country.COL_FLAG, country.getFlag());

        return contentValues;
    }

    private Country fetch(Cursor cursor) {
        Country country = new Country();

        country.setId(cursor.getLong(cursor.getColumnIndex(Country.COL_ID)));
        country.setNameEn(cursor.getString(cursor.getColumnIndex(Country.COL_NAME_EN)));
        country.setNameVi(cursor.getString(cursor.getColumnIndex(Country.COL_NAME_VI)));
        country.setFlag(cursor.getString(cursor.getColumnIndex(Country.COL_FLAG)));

        return country;
    }

    private List<Country> fetchAll(Cursor cursor) {
        List<Country> countries = new ArrayList<>();
        if(cursor != null) {
            if (cursor.moveToFirst()) {
                do {
                    countries.add(fetch(cursor));
                } while (cursor.moveToFirst());
            }
            cursor.close();
        }
        return countries;
    }
}
