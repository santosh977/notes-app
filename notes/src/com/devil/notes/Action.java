package com.devil.notes;

import android.app.Activity;
import android.content.Intent;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

public class Action extends Activity {
	private DrawerLayout mDrawerLayout;
	private String[] mPlanetTitles;
	private ListView mDrawerList;

	/*
	 * @Override public void onCreate(view v) { super.onCreate(v);
	 * setContentView(R.layout.action); mPlanetTitles =
	 * getResources().getStringArray(R.array.planets); mDrawerLayout =
	 * (DrawerLayout) findViewById(R.id.drawer_layout); mDrawerList = (ListView)
	 * findViewById(R.id.left_drawer);}
	 */
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
		// bar.setBackgroundDrawable(new
		// ColorDrawable(Color.parseColor("#0000ff")));
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case R.id.menu1:
			startActivity(new Intent(getApplicationContext(), Search.class));
			finish();
			break;
		case R.id.menu2_1:
			startActivity(new Intent(getApplicationContext(), Profdiv.class));
			finish();
			break;
		case R.id.menu2_2:
			startActivity(new Intent(getApplicationContext(), Clges.class));
			finish();
			break;
		case R.id.menu2_3:
			startActivity(new Intent(getApplicationContext(), Members.class));
			finish();
			break;
		case R.id.menu2_4:
			startActivity(new Intent(getApplicationContext(), NewNotes.class));
			finish();
			break;
		case R.id.menu2_5:
			startActivity(new Intent(getApplicationContext(), Loginpage.class));
			finish();
			break;
		case R.id.menu2_6:
			startActivity(new Intent(getApplicationContext(), NewsFeed.class));
			finish();
			break;
		default:
			Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
			break;
		}
		return true;
	}

	/*
	 * public void onCreateContextMenu(ContextMenu menu, View view,
	 * ContextMenuInfo menuInfo) { getMenuInflater().inflate(R.menu.main, menu);
	 * }
	 */
	/*
	 * public boolean onContextItemSelected(MenuItem item) {
	 * Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show(); return
	 * true; }
	 */
	public void setOnItemClickListener(AdapterView<?> parent, View view,
			int position, long id) {
		// Toast.makeText(this,String.valueOf(position),
		// Toast.LENGTH_LONG).show();
	}

}