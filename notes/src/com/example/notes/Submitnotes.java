package com.example.notes;

import java.util.ArrayList;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Submitnotes extends Activity {
	ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_submitnotes);
		getIntent().getExtras().getInt("x");
		lv= (ListView)findViewById(R.id.listView1);
		ArrayList<String> ar= new ArrayList<String>();
		ar.add("engineering physics");
		ar.add("dbms");
		ar.add("dms");
		ar.add("computer architecture");
		ar.add("ads");
		ar.add("tef");
		ar.add("computer networks");
		ar.add("daa");
		ar.add("artificial intelligence");
		ar.add("robotics");
		lv.setAdapter(new ArrayAdapter<String>(getApplicationContext(), R.layout.row, ar));
	}

	
}
