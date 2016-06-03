package com.example.pc12_13.database.database.provider;

import com.example.pc12_13.database.model.Country;

import java.util.List;

public interface IDataProvider {
    //interface use to declare method access database or dump data
    List<Country> get();
    long insertCountry(Country country);
}
