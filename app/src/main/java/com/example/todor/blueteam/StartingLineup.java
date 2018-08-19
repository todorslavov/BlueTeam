package com.example.todor.blueteam;

import android.app.Activity;
import android.app.Fragment;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Toolbar;

import com.example.todor.blueteam.Repositories.Repositoriable;
import com.google.firebase.firestore.FirebaseFirestore;
import com.mikepenz.materialdrawer.Drawer;
import com.mikepenz.materialdrawer.DrawerBuilder;
import com.mikepenz.materialdrawer.model.DividerDrawerItem;
import com.mikepenz.materialdrawer.model.PrimaryDrawerItem;
import com.mikepenz.materialdrawer.model.SecondaryDrawerItem;
import com.mikepenz.materialdrawer.model.interfaces.IDrawerItem;

import java.util.function.Consumer;

public class StartingLineup extends Activity {
    private ArrayAdapter<String> mPlayersAdapter;
    private FirebaseFirestore mDB;
    private StartingLineupFragment fragment;
    private android.support.v7.widget.Toolbar mToolbar;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_starting_lineup);
        fragment = StartingLineupFragment.newInstance();
        this.getFragmentManager()
                .beginTransaction()
                .replace(R.id.content, fragment)
                .commit();
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
                            intent=new Intent(StartingLineup.this,StartingLineup.class);
                        }
                        else if(idfier==2){
                            intent=new Intent(StartingLineup.this,Subtitutes.class);
                        }
                        else if(idfier==3){
                            intent=new Intent(StartingLineup.this,Reserves.class);
                        }
                        else if(idfier==4){
                            intent=new Intent(StartingLineup.this,Coach.class);
                        }
                        else if(idfier==5){
                            intent=new Intent(StartingLineup.this,ClubOwner.class);
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