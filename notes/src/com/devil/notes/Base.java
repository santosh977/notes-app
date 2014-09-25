package com.devil.notes;

import java.util.ArrayList;

import android.annotation.TargetApi;
import android.app.Activity;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;

public abstract class Base extends Activity {
DrawerLayout dLayout;
ListView listViewLTR;
ActionBarDrawerToggle toggle;
CharSequence title;
CharSequence drawerTitle;
static ArrayList<String> dareList;
private Button secondActivityBtn;

@TargetApi(Build.VERSION_CODES.HONEYCOMB)
@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(getLayoutResourceID());
    title = drawerTitle = getTitle();
    dLayout = (DrawerLayout) findViewById(R.id.drawer);
    listViewLTR = (ListView) findViewById(R.id.adventuresLTR);
    dLayout.setDrawerShadow(R.drawable.drawer,
            GravityCompat.START);
    dareList = new ArrayList<String>();
    dareList.add("Scuba_Diving");
    dareList.add("Sky_Diving");
    dareList.add("Bungee_Jumping");
    dareList.add("Paragliding");
    dareList.add("Drifting");
    listViewLTR.setAdapter(new ArrayAdapter<String>(this,
            R.layout.row, dareList));
   // listViewLTR.setOnItemClickListener(new DrawerItemClickListener(this));

    getActionBar().setDisplayHomeAsUpEnabled(true);
    getActionBar().setHomeButtonEnabled(true);

    toggle = new ActionBarDrawerToggle(this, dLayout,
            R.drawable.drawer, R.string.drawer_open, R.string.drawer_close);

    dLayout.setDrawerListener(toggle);
    
    
    
    /*if (savedInstanceState == null) {
        new DrawerItemClickListener(this).selectItem(2);
    }*/
}

@Override
public boolean onOptionsItemSelected(MenuItem item) {
    // The action bar home/up action should open or close the drawer.
    // ActionBarDrawerToggle will take care of this.
    if (toggle.onOptionsItemSelected(item)) {
        return true;
    }
    // Handle action buttons
    switch (item.getItemId()) {

    default:

        return super.onOptionsItemSelected(item);
    }
}
protected abstract int getLayoutResourceID();

@Override
public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.main, menu);
    return true;
  }
}