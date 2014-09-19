package com.devil.notes;

import android.app.Activity;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuItem;

public class Action extends Activity{
	 @Override
	 public boolean onCreateOptionsMenu(Menu menu) {
	  getMenuInflater().inflate(R.menu.main, menu);
	  return true;
	 }

	 @Override
	 public boolean onOptionsItemSelected(MenuItem item) {

	 
		 startActivity(new Intent(getApplicationContext(), Search.class));
    	 //Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
          return true;    
	  }

	 }

	