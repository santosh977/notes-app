package com.devil.notes;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemLongClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class Submitnotes extends Action{
	ListView lv;
	ArrayAdapter<String> adapter;
	List<String> arr;
	String[] language = { "C", "Java", "C++", "C-sharp", ".Net", "SQL",
			"Android", "PhoneGap", "Ios", "windows", "PHP", "Phyton", "Perl" };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_submitnotes);
		getIntent().getExtras().getInt("x");

		lv = (ListView) findViewById(R.id.listView1);
		arr = new ArrayList<String>(Arrays.asList(language));
		adapter = new ArrayAdapter<String>(this, R.layout.row, arr);
		lv.setAdapter(adapter);

		lv.setOnItemLongClickListener(new OnItemLongClickListener() {
			// setting onItemLongClickListener and passing the position to the
			// function
			@Override
			public boolean onItemLongClick(AdapterView<?> arg0, View arg1,
					int position, long arg3) {
				removeItemFromList(position);

				return true;
			}
		});
	}

	// method to remove list item
	protected void removeItemFromList(int position) {
		final int deletePosition = position;

		AlertDialog.Builder alert = new AlertDialog.Builder(Submitnotes.this);

		alert.setTitle("Delete");
		alert.setMessage("Do you want delete this item?");
		alert.setPositiveButton("YES", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {
				// TOD O Auto-generated method stub

				// main code on after clicking yes
				arr.remove(deletePosition);
				adapter.notifyDataSetChanged();
				adapter.notifyDataSetInvalidated();

			}
		});
		alert.setNegativeButton("CANCEL", new OnClickListener() {
			@Override
			public void onClick(DialogInterface dialog, int which) {

				dialog.dismiss();
			}
		});

		alert.show();
	}
	public boolean onOptionsItemSelected(MenuItem item)
    {   return super.onOptionsItemSelected(item);  
    }   
}