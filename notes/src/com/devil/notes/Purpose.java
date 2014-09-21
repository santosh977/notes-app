package com.devil.notes;

import android.os.Bundle;
import android.view.MenuItem;

public class Purpose extends Action {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_purpose);

	}
	public boolean onOptionsItemSelected(MenuItem item)
    {   return super.onOptionsItemSelected(item);  
    }  
}
