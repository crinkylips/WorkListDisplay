package com.hive9.worklist;


import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.security.PublicKey;

/**
 * Created by hIVE9 on 05/08/2016.
 */
public class SearchWorksheetActivity extends AppCompatActivity{

    TextView display_name, display_device, display_repair, display_status, display_priority, display_booked;

    EditText Search_name;

    //Spinner display_colour;

    //ArrayAdapter<CharSequence> adapter;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    String search_name,NAME,DEVICE,REPAIR,STATUS,PRIORITY,BOOKED;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.search_worksheet_layout);

        Search_name = (EditText) findViewById(R.id.Search_name);

        display_name = (TextView) findViewById(R.id.display_name);
        display_device = (TextView) findViewById(R.id.display_device);
        display_repair = (TextView) findViewById(R.id.display_repair);
        display_status = (TextView) findViewById(R.id.display_status);
        display_priority = (TextView) findViewById(R.id.display_priority);
        display_booked = (TextView) findViewById(R.id.display_booked);

        //display_colour = (Spinner) findViewById(R.id.spinner);
        //adapter = ArrayAdapter.createFromResource(this,R.array.colours,android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //display_colour.setAdapter(adapter);

        display_name.setVisibility(View.INVISIBLE);
        display_device.setVisibility(View.INVISIBLE);
        display_repair.setVisibility(View.INVISIBLE);
        display_status.setVisibility(View.INVISIBLE);
        display_priority.setVisibility(View.INVISIBLE);
        display_booked.setVisibility(View.INVISIBLE);

    }

        /*
        SPINNER
        display_colour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {


            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 0:

                        break;
                    case 1:


                        Toast.makeText(getBaseContext(),"Yellow selected", Toast.LENGTH_LONG).show();
                        break;
                    case 2:

                        Toast.makeText(getBaseContext(),"Blue selected", Toast.LENGTH_LONG).show();
                        break;
                    case 3:

                        Toast.makeText(getBaseContext(),"Green selected", Toast.LENGTH_LONG).show();
                        break;
                    case 4:

                        Toast.makeText(getBaseContext(),"Red selected", Toast.LENGTH_LONG).show();
                        break;
                    default:

                        break;
                }



                //Toast.makeText(getBaseContext(),parent.getItemAtPosition(position)+" selected", Toast.LENGTH_LONG).show();



            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
    }
*/



        public void searchContact(View view) {

            search_name = Search_name.getText().toString();
            userDbHelper = new UserDbHelper(getApplicationContext());
            sqLiteDatabase = userDbHelper.getReadableDatabase();
            Cursor cursor = userDbHelper.getContact(search_name,sqLiteDatabase);
            if(cursor.moveToFirst())
            {
                //String NAME =cursor.getString(0);
                DEVICE = cursor.getString(0);
                REPAIR = cursor.getString(1);
                STATUS = cursor.getString(2);
                PRIORITY = cursor.getString(3);
                BOOKED = cursor.getString(4);

                NAME = search_name;
                display_name.setText(NAME);
                display_device.setText(DEVICE);
                display_repair.setText(REPAIR);
                display_status.setText(STATUS);
                display_priority.setText(PRIORITY);
                display_booked.setText(BOOKED);

                display_name.setVisibility(view.VISIBLE);
                display_device.setVisibility(View.VISIBLE);
                display_repair.setVisibility(View.VISIBLE);
                display_status.setVisibility(View.VISIBLE);
                display_priority.setVisibility(View.VISIBLE);
                display_booked.setVisibility(View.VISIBLE);

            }

        }

    public void deleteContact (View veiw)
    {
        userDbHelper = new UserDbHelper(getApplicationContext());
        sqLiteDatabase = userDbHelper.getReadableDatabase();
        userDbHelper.deleteInformation(search_name,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Work Item Deleted!",Toast.LENGTH_LONG).show();
    }








}
