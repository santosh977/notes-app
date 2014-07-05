package com.example.notes;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ExpandableListView;
import android.widget.TextView;

public class NotesActivity extends Activity {
ExpandableListView exlist;
TextView item;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.notes);
		exlist=(ExpandableListView)findViewById(R.id.expandableListView1);
		
		item=new TextView(getApplicationContext());
		item.setText("Notes 1: Android is freeeee  !!!");
		exlist.addView(item,0);
		item.setText("Notes 2: We make Design and Code and Run.");
		exlist.addView(item,1);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.notes, menu);
		return true;
	}

}
