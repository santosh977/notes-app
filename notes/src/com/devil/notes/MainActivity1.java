package com.devil.notes;

import android.annotation.TargetApi;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;

public class MainActivity1 extends Action {

	private DrawerLayout drawerLayout;
	private String[] PlanetTitles;
	private ListView drawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	// private ActionBarDrawerToggle mDrawerToggle;
	@TargetApi(Build.VERSION_CODES.HONEYCOMB)
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main_activity1);

		PlanetTitles = getResources().getStringArray(R.array.planets);
		// drawerList.setOnItemClickListener( (OnItemClickListener) this);
		drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		drawerList = (ListView) findViewById(R.id.left_drawer);
		mDrawerToggle = new ActionBarDrawerToggle(this, /* host Activity */
		drawerLayout, /* DrawerLayout object */
		R.drawable.drawer, /* nav drawer image to replace 'Up' caret */
		R.string.drawer_open, /* "open drawer" description for accessibility */
		R.string.drawer_close /* "close drawer" description for accessibility */
		) {
			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(R.string.title_activity_main_activity1);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}

			@TargetApi(Build.VERSION_CODES.HONEYCOMB)
			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(R.string.title_activity_main_activity1);
				invalidateOptionsMenu(); // creates call to
											// onPrepareOptionsMenu()
			}
		};
		drawerLayout.setDrawerListener(mDrawerToggle);

		getActionBar().setHomeButtonEnabled(true);
	}

	/*
	 * @Override
	 * 
	 * 
	 * public void setOnItemClickListener(AdapterView<?>parent, View view,int
	 * position,long id) { Toast.makeText(this, PlanetTitles[position] +
	 * " checked : " , Toast.LENGTH_SHORT).show(); }
	 *//*
		 * public void onItemClick(AdapterView<?> arg0, View arg1, int arg2,
		 * long arg3) { // Toast.makeText(MainActivity.this, ""+arg2, //
		 * Toast.LENGTH_LONG).show();
		 * 
		 * selectItem(main_model.get(arg2).getName());
		 * 
		 * } });
		 */

	/*
	 * public void onListItemClickListener(AdapterView<?>parent, View view,int
	 * position,long id) { Toast.makeText(this, PlanetTitles[position] +
	 * " checked : " , Toast.LENGTH_SHORT).show(); }
	 */

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		/*
		 * MenuInflater inflater = getMenuInflater();
		 * getMenuInflater().inflate(R.menu.main, menu);
		 */
		return super.onCreateOptionsMenu(menu);

		// bar.setBackgroundDrawable(new
		// ColorDrawable(Color.parseColor("#0000ff")));
	}

	@Override
	public boolean onPrepareOptionsMenu(Menu menu) {
		// If the nav drawer is open, hide action items related to the content
		// view
		boolean drawerOpen = drawerLayout.isDrawerOpen(drawerList);
		// menu.findItem(R.id.action_websearch).setVisible(!drawerOpen);
		return super.onPrepareOptionsMenu(menu);
	}

	protected int getLayoutResourceID() {

		return R.layout.activity_main_activity1;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// The action bar home/up action should open or close the drawer.
		// ActionBarDrawerToggle will take care of this.
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

}
