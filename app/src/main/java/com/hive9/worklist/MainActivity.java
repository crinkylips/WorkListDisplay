package com.hive9.worklist;


import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;
import android.widget.Spinner;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {

    VideoView vv;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        vv = (VideoView) findViewById(R.id.logoLoop);
        vv.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.desolve));

        Uri uri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.desolve);
        VideoView simpleView = (VideoView) findViewById(R.id.logoLoop);
        simpleView.setVideoURI(uri);
        vv.setOnPreparedListener (new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
        simpleView.start();


    }


    //how to switch between activity
    public void addWork (View view)
    {
        Intent intent = new Intent(this,NewWorksheetActivity.class);
        startActivity(intent);
    }
    public void viewWork (View view)
    {
        Intent intent = new Intent(this,DataListActivity.class);
        startActivity(intent);
    }
    public void searchWork (View view)
    {
        Intent intent = new Intent(this,SearchWorksheetActivity.class);
        startActivity(intent);
    }
    public void updateWorklist (View view)
    {
        Intent intent = new Intent(this,UpdateWorksheetActivity.class);
        startActivity(intent);
    }

    public void deleteWork (View view)
    {
        Intent intent = new Intent(this,SearchWorksheetActivity.class);
        startActivity(intent);
    }


}
