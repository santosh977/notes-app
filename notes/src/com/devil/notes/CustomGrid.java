package com.devil.notes;

import java.util.ArrayList;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

/**
 * 
 * @author manish.s
 * 
 */

public class CustomGrid extends Action {
	GridView gridView;
	ArrayList<Item> gridArray = new ArrayList<Item>();
	CustomGridViewAdapter customGridAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.customgrid);

		// set grid view item
		// Bitmap homeIcon = BitmapFactory.decodeResource(this.getResources(),
		// R.drawable.home);
		Bitmap userIcon = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.personal);

		gridArray.add(new Item("1", userIcon));
		gridArray.add(new Item("2", userIcon));
		gridArray.add(new Item("3", userIcon));
		gridArray.add(new Item("4", userIcon));
		gridArray.add(new Item("5", userIcon));
		gridArray.add(new Item("6", userIcon));
		gridArray.add(new Item("7", userIcon));
		gridArray.add(new Item("8", userIcon));
		gridArray.add(new Item("9", userIcon));
		gridArray.add(new Item("10", userIcon));
		gridArray.add(new Item("11", userIcon));
		gridArray.add(new Item("12", userIcon));

		gridView = (GridView) findViewById(R.id.gridView1);
		customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid,
				gridArray);
		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				startActivity(new Intent(getApplicationContext(),
						Usernotes.class));

			}
		});
		gridView.setAdapter(customGridAdapter);
	}

	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}
}
