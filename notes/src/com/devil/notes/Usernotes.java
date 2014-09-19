package com.devil.notes;

import android.os.Bundle;
import android.view.MenuItem;

public class Usernotes extends Action {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_usernotes);
	}
	public boolean onOptionsItemSelected(MenuItem item)
    {   return super.onOptionsItemSelected(item);  
    }   
}
