package com.example.pc12_13.database.database.provider;

import android.content.Context;

import com.example.pc12_13.database.model.Country;

import java.util.ArrayList;
import java.util.List;

public class CountryProvider2 implements IDataProvider{
    private Context context;

    public CountryProvider2(Context context) {
        this.context = context;
    }

    String[] nameEn = new String[]{"Vietnam", "China", "Japan", "Korea"};
    String[] nameVi = new String[]{"Việt Nam", "Trung Quốc", "Nhật Bản", "Hàn Quốc"};
    String[] flag = new String[]{"vietnam.png", "china.png", "japan.png", "korea.png"};

    @Override
    public List<Country> get() {
        List<Country> countries = new ArrayList<>();
        for (int i = 0; i < nameEn.length; i++) {
            countries.add(new Country(i+1,nameEn[i], nameVi[i], flag[i]));
        }
        return countries;
    }

    @Override
    public long insertCountry(Country country) {
        return 0;
    }
}
