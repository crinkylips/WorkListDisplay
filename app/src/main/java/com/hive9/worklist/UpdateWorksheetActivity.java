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

/**
 * Created by hIVE9 on 05/08/2016.
 */
public class UpdateWorksheetActivity extends AppCompatActivity{

    EditText Search_name,Update_name, Update_device, Update_repair, Update_status, Update_priority, Update_booked;
    TextView UpdateWork;
    //Spinner Update_colour;


    String SearchName,NAME,DEVICE,REPAIR,STATUS,PRIORITY,BOOKED,name,device,repair,status,priority,booked;

    //ArrayAdapter<CharSequence> adapter;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    String search_name;

    @Override
    protected void onCreate (Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.update_worksheet_layout);

        Search_name = (EditText) findViewById(R.id.Search_name);

        UpdateWork = (TextView) findViewById(R.id.UpdateWork);

        Update_name = (EditText) findViewById(R.id.Update_name);
        Update_device = (EditText) findViewById(R.id.Update_device);
        Update_repair = (EditText) findViewById(R.id.Update_repair);
        Update_status = (EditText) findViewById(R.id.Update_status);
        Update_priority = (EditText) findViewById(R.id.Update_priority);
        Update_booked = (EditText) findViewById(R.id.Update_booked);
        //Update_colour = (Spinner) findViewById(R.id.spinner);
        //adapter = ArrayAdapter.createFromResource(this,R.array.colours,android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //Update_colour.setAdapter(adapter);

        Update_name.setVisibility(View.INVISIBLE);
        Update_device.setVisibility(View.INVISIBLE);
        Update_repair.setVisibility(View.INVISIBLE);
        Update_status.setVisibility(View.INVISIBLE);
        Update_priority.setVisibility(View.INVISIBLE);
        Update_booked.setVisibility(View.INVISIBLE);

        /*
        //SPINNER CODE

        Update_colour.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {

                switch (position) {
                    case 0:

                       break;
                    case 1:


                        Toast.makeText(getBaseContext(), "Yellow selected", Toast.LENGTH_LONG).show();
                        break;
                    case 2:

                        Toast.makeText(getBaseContext(), "Blue selected", Toast.LENGTH_LONG).show();
                        break;
                    case 3:

                        Toast.makeText(getBaseContext(), "Green selected", Toast.LENGTH_LONG).show();
                        break;
                    case 4:

                        Toast.makeText(getBaseContext(), "Red selected", Toast.LENGTH_LONG).show();
                        break;
                    default:

                        break;
                }

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });*/
    }
            public void searchWorklist(View view) {

                SearchName = Search_name.getText().toString();
                userDbHelper = new UserDbHelper(getApplicationContext());
                sqLiteDatabase = userDbHelper.getReadableDatabase();
                Cursor cursor = userDbHelper.getContact(SearchName, sqLiteDatabase);
                if (cursor.moveToFirst()) {

                    DEVICE = cursor.getString(0);
                    REPAIR = cursor.getString(1);
                    STATUS = cursor.getString(2);
                    PRIORITY = cursor.getString(3);
                    BOOKED = cursor.getString(4);
                    NAME = SearchName;
                    Update_name.setText(NAME);
                    Update_device.setText(DEVICE);
                    Update_repair.setText(REPAIR);
                    Update_status.setText(STATUS);
                    Update_priority.setText(PRIORITY);
                    Update_booked.setText(BOOKED);
                    //Update_colour.getOnItemSelectedListener();
                    Update_name.setVisibility(view.VISIBLE);
                    Update_device.setVisibility(View.VISIBLE);
                    Update_repair.setVisibility(View.VISIBLE);
                    Update_status.setVisibility(View.VISIBLE);
                    Update_priority.setVisibility(View.VISIBLE);
                    Update_booked.setVisibility(View.VISIBLE);



                }
            }

            public void updateButton(View view) {
                userDbHelper = new UserDbHelper(getApplicationContext());
                sqLiteDatabase = userDbHelper.getWritableDatabase();
                name = Update_name.getText().toString();
                device = Update_device.getText().toString();
                repair = Update_repair.getText().toString();
                status = Update_status.getText().toString();
                priority = Update_priority.getText().toString();
                booked = Update_booked.getText().toString();

                //colour = Update_colour.getSelectedItem().toString();
                int count = userDbHelper.updateInformation(SearchName, name, device, repair, status, priority, booked, sqLiteDatabase);
                Toast.makeText(getApplicationContext(), count + " contact updated", Toast.LENGTH_LONG).show();
                finish();
            }
}



