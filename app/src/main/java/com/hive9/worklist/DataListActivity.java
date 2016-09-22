package com.hive9.worklist;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.ListView;

/**
 * Created by hIVE9 on 04/08/2016.
 */
public class DataListActivity extends AppCompatActivity {

    ListView listView;
    SQLiteDatabase sqLiteDatabase;
    UserDbHelper userDbHelper;
    Cursor cursor;
    ListDataAdapter listDataAdapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_data_list);
        listView = (ListView) findViewById(R.id.list_View);
        listDataAdapter = new ListDataAdapter(getApplicationContext(),R.layout.raw_layout);
        listView.setAdapter(listDataAdapter);
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        cursor = userDbHelper.GetInformations(sqLiteDatabase);
        if(cursor.moveToFirst())
        {
            do {

                String name,device,repair,status,priority,booked;
                name = cursor.getString(0);
                device = cursor.getString(1);
                repair = cursor.getString(2);
                status = cursor.getString(3);
                priority = cursor.getString(4);
                booked = cursor.getString(5);

                DataProvider dataProvider = new DataProvider(name,device,repair,status,priority,booked);
                listDataAdapter.add(dataProvider);

            }while (cursor.moveToNext());

        }


    }
}
