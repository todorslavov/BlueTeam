package com.example.todor.blueteam.MainMenuChoices;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.View;

import com.example.todor.blueteam.R;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

public class Coach extends Activity {

    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_coach);
        mToolbar=findViewById(R.id.drawer);
        setupDrawer();
    }
    public void setupDrawer(){
        PrimaryDrawerItem item1 = new PrimaryDrawerItem().withIdentifier(1).withName("Starting Lineup");
        PrimaryDrawerItem item2 = new PrimaryDrawerItem().withIdentifier(2).withName("Subtitutes");
        PrimaryDrawerItem item3 = new PrimaryDrawerItem().withIdentifier(3).withName("Reserves");
        PrimaryDrawerItem item4 = new PrimaryDrawerItem().withIdentifier(4).withName("Coach");
        PrimaryDrawerItem item5 = new PrimaryDrawerItem().withIdentifier(5).withName("Owner");

//create the drawer and remember the `Drawer` result object
        Drawer result = new DrawerBuilder()
                .withActivity(this)
                .withToolbar(mToolbar)
                .addDrawerItems(
                        item1,
                        new DividerDrawerItem(),
                        item2,
                        new DividerDrawerItem(),
                        item3,
                        new DividerDrawerItem(),
                        item4,
                        new DividerDrawerItem(),
                        item5
                )
                .withOnDrawerItemClickListener(new Drawer.OnDrawerItemClickListener() {
                    @Override
                    public boolean onItemClick(View view, int position, IDrawerItem drawerItem) {
                        long idfier=drawerItem.getIdentifier();
                        Intent intent;
                        if(idfier==1) {
                            intent=new Intent(Coach.this,StartingLineup.class);
                        }
                        else if(idfier==2){
                            intent=new Intent(Coach.this,Subtitutes.class);
                        }
                        else if(idfier==3){
                            intent=new Intent(Coach.this,Reserves.class);
                        }
                        else if(idfier==4){
                            intent=new Intent(Coach.this,Coach.class);
                        }
                        else if(idfier==5){
                            intent=new Intent(Coach.this,ClubOwner.class);
                        }else {
                            return false;
                        }
                        startActivity(intent);
                        return true;
                    }
                })
                .build();
    }
}
