package com.hive9.worklist;

import android.app.Activity;
import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.os.Bundle;
import android.text.style.BackgroundColorSpan;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

/**
 * Created by hIVE9 on 04/08/2016.
 */
public class NewWorksheetActivity extends Activity {

    EditText custName, custDevice, custRepair, custStatus, custPriority, custBooked;
   // String colour;
    Context context = this;
    UserDbHelper userDbHelper;
    SQLiteDatabase sqLiteDatabase;
    //Spinner colourMain;
    //ArrayAdapter<CharSequence> adapter;
    GridLayout bkColour;



    @Override
    protected void onCreate(Bundle savedInsanceState)
    {

        super.onCreate(savedInsanceState);
        setContentView(R.layout.new_worksheet_layout);
        custName = (EditText) findViewById(R.id.user_name);
        custDevice = (EditText) findViewById(R.id.user_device);
        custRepair = (EditText) findViewById(R.id.user_repair);
        custStatus = (EditText) findViewById(R.id.user_status);
        custPriority = (EditText) findViewById(R.id.user_priority);
        custBooked = (EditText) findViewById(R.id.user_booked);

        //colourMain = (Spinner) findViewById(R.id.spinner);
        //adapter = ArrayAdapter.createFromResource(this,R.array.colours,android.R.layout.simple_spinner_item);
        //adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        //colourMain.setAdapter(adapter);
        bkColour = (GridLayout) findViewById(R.id.gridLayout);


        /*colourMain.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {

            @Override
            public void onItemSelected( AdapterView<?> parent, View view, int position, long id) {

                switch (position)
                {
                    case 0:
                         parent.getItemAtPosition(position).toString();
                        break;
                    case 1:
                        parent.getItemAtPosition(position).toString();
                        Toast.makeText(getBaseContext(),"Yellow selected", Toast.LENGTH_LONG).show();
                        break;
                    case 2:
                        parent.getItemAtPosition(position).toString();

                        Toast.makeText(getBaseContext(),"Blue selected", Toast.LENGTH_LONG).show();
                        break;
                    case 3:
                        parent.getItemAtPosition(position).toString();

                        Toast.makeText(getBaseContext(),"Green selected", Toast.LENGTH_LONG).show();
                        break;
                    case 4:

                        parent.getItemAtPosition(position).toString();
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
        });*/
    }

    //method for adding info to database

    public void addWorkToList (View view)
    {

        String name = custName.getText().toString();
        String device = custDevice.getText().toString();
        String repair = custRepair.getText().toString();
        String status = custStatus.getText().toString();
        String priority = custPriority.getText().toString();
        String booked = custBooked.getText().toString();

       // String colour = colourMain.getSelectedItem().toString().trim();

        userDbHelper = new UserDbHelper(context);
        sqLiteDatabase = userDbHelper.getWritableDatabase();
        userDbHelper.addInformations(name,device,repair,status,priority,booked,sqLiteDatabase);
        Toast.makeText(getBaseContext(),"Data Saved",Toast.LENGTH_LONG).show();
        userDbHelper.close();

    }

}