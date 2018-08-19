package com.example.todor.blueteam;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainMenuActivity extends Activity implements View.OnClickListener {
CardView startingLineup,subtitutes,reserves,clubOwner,coach;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_menu);
        startingLineup=(CardView)findViewById(R.id.startingLineup);
        subtitutes=(CardView)findViewById(R.id.subtitutes);
        reserves=(CardView)findViewById(R.id.reserves);
        clubOwner=(CardView)findViewById(R.id.clubOwner);
        coach=(CardView)findViewById(R.id.coach);

        startingLineup.setOnClickListener(this);
        subtitutes.setOnClickListener(this);
        reserves.setOnClickListener(this);
        clubOwner.setOnClickListener(this);
        coach.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent intent;

        switch(v.getId())
        {
            case R.id.startingLineup : intent = new Intent(this,StartingLineup.class);startActivity(intent);break;
            case R.id.subtitutes : intent = new Intent(this,Subtitutes.class);startActivity(intent);break;
            case R.id.reserves : intent = new Intent(this,Reserves.class);startActivity(intent);break;
            case R.id.clubOwner : intent = new Intent(this,ClubOwner.class);startActivity(intent);break;
            case R.id.coach : intent = new Intent(this,Coach.class);startActivity(intent);break;
        }
    }
}
