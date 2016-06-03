package com.example.pc12_13.database.database.provider;

import android.content.Context;

import com.example.pc12_13.database.database.dao.CountryDAO;
import com.example.pc12_13.database.model.Country;

import java.util.List;

public class CountryProvider implements IDataProvider {
    private Context context;
    private CountryDAO countryDAO;

    public CountryProvider(Context context) {
        this.context = context;
        countryDAO = new CountryDAO(context);
    }

    @Override
    public List<Country> get() {
        return countryDAO.get();
    }

    @Override
    public long insertCountry(Country country) {
        return countryDAO.insert(country);
    }
}
