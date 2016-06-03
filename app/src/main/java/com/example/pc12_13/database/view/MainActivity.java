package com.example.pc12_13.database.view;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;

import com.example.pc12_13.database.R;
import com.example.pc12_13.database.database.provider.CountryProvider2;
import com.example.pc12_13.database.database.provider.IDataProvider;
import com.example.pc12_13.database.model.Country;

import butterknife.BindView;
import butterknife.BindViews;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    @BindView(R.id.btnLoadDB) Button btnLoadDB;
    @BindView(R.id.btnLoadDump) Button btnLoadDump;
    @BindView(R.id.listView) ListView listView;
    IDataProvider iDataProvider;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);
        btnLoadDB.setOnClickListener(this);
        btnLoadDump.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.btnLoadDB) {

        }
        else if(id == R.id.btnLoadDump) {
            iDataProvider = new CountryProvider2(this);
        }

        CountryAdapter adapter = new CountryAdapter(this, R.layout.item_list_view_countries, iDataProvider.get());
        adapter.notifyDataSetChanged();
        listView.setAdapter(adapter);
    }
}
