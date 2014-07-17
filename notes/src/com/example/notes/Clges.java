package com.example.notes;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.GridView;

public class Clges extends Activity {
	GridView gridView;
	ArrayList<Item> gridArray = new ArrayList<Item>();
	CustomGridViewAdapter customGridAdapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_clges);

		// set grid view item
		Bitmap homeIcon = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.home);
		Bitmap userIcon = BitmapFactory.decodeResource(this.getResources(),
				R.drawable.personal);

		gridArray.add(new Item("colg_name", userIcon));
		gridArray.add(new Item("colg_name", userIcon));
		gridArray.add(new Item("colg_name", userIcon));
		gridArray.add(new Item("colg_name", userIcon));
		gridArray.add(new Item("colg_name", userIcon));
		gridArray.add(new Item("colg_name", userIcon));
		gridArray.add(new Item("colg_name", userIcon));
		gridArray.add(new Item("colg_name", userIcon));
		gridArray.add(new Item("colg_name", userIcon));
		gridArray.add(new Item("colg_name", userIcon));
		gridArray.add(new Item("colg_name", userIcon));
		gridArray.add(new Item("colg_name", userIcon));

		gridView = (GridView) findViewById(R.id.gridView1);
		customGridAdapter = new CustomGridViewAdapter(this, R.layout.row_grid,
				gridArray);
		gridView.setOnItemClickListener(new OnItemClickListener() {
			public void onItemClick(AdapterView<?> parent, View v,
					int position, long id) {
				startActivity(new Intent(getApplicationContext(),
						Handlers.class));

			}
		});
		gridView.setAdapter(customGridAdapter);
	}

}
