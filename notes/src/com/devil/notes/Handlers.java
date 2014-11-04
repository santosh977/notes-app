package com.devil.notes;

import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class Handlers extends Action {
	ListView l1, l2, l3, l4;
	String[] lists = { "IIT", "MIT", "Harvard", "Oxford", "BITS", "RTU", "JNVU" };

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_handlers);

		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, lists);

		// ---List View---
		l1 = (ListView) findViewById(R.id.ListView1);
		l1.setAdapter(adapter);
		l1.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				int index = arg2;
				Toast.makeText(getBaseContext(),
						"You have selected item : " + lists[index],
						Toast.LENGTH_SHORT).show();
			}
		});

		// ---List View---
		l2 = (ListView) findViewById(R.id.ListView2);
		l2.setAdapter(adapter);
		l2.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				int index = arg2;
				Toast.makeText(getBaseContext(),
						"You have selected item : " + lists[index],
						Toast.LENGTH_SHORT).show();
			}
		});

		// ---List View---
		l3 = (ListView) findViewById(R.id.ListView3);
		l3.setAdapter(adapter);
		l3.setOnItemClickListener(new OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
					long arg3) {
				int index = arg2;
				Toast.makeText(getBaseContext(),
						"You have selected item : " + lists[index],
						Toast.LENGTH_SHORT).show();
			}
		});

	}

	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}
}
