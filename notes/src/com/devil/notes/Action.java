package com.devil.notes;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class Action extends Activity{
	private DrawerLayout mDrawerLayout;
    private String[] mPlanetTitles;
    private ListView mDrawerList;
 
	/*
    @Override
    public void onCreate(view v) {
        super.onCreate(v);
        setContentView(R.layout.action);
        mPlanetTitles = getResources().getStringArray(R.array.planets);
        mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        mDrawerList = (ListView) findViewById(R.id.left_drawer);}*/
	 @Override
	 public boolean onCreateOptionsMenu(Menu menu) {
	  getMenuInflater().inflate(R.menu.main, menu);
	  return true;
	  //bar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#0000ff")));
	 }

	 @Override
	 public boolean onOptionsItemSelected(MenuItem item) {

	 
		 startActivity(new Intent(getApplicationContext(), Search.class));
    	
          return true;    
	  }

	public void setOnItemClickListener(AdapterView<?> parent, View view,
			int position, long id) {
		// TODO Auto-generated method stub
		
	}

	 

}