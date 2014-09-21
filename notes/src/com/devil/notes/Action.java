package com.devil.notes;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class Action extends Activity{
	//ActionBar bar = getActionBar();
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

	 }

	