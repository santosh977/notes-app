package com.devil.notes;

import android.app.Activity;
import android.support.v4.widget.DrawerLayout;
import android.view.ContextMenu;
import android.view.ContextMenu.ContextMenuInfo;
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
		
		 
		/*switch (item.getTitle()) {
		case R.id.menu_item_1:
			startActivity(new Intent(getApplicationContext(), Profdiv.class));
			break;
		case R.id.menu_item_2:
			startActivity(new Intent(getApplicationContext(), LayerStack.class));
			break;
		case R.id.menu_item_3:
			startActivity(new Intent(getApplicationContext(), Members.class));
			break;
		case R.id.menu_item_4:
			startActivity(new Intent(getApplicationContext(), scrolltab.class));
			break;
		case R.id.menu_item_7:
			startActivity(new Intent(getApplicationContext(), NewsFeed.class));
			break;
		case R.id.menu_item_10:
			startActivity(new Intent(getApplicationContext(), Members.class));
			break;
		case R.id.menu_item_11:
			startActivity(new Intent(getApplicationContext(), Loginpage.class));
			break;

		default:
			Toast.makeText(getApplicationContext(), "TODO", Toast.LENGTH_LONG)
					.show();
			break;
		
		}*/

		//startActivity(new Intent(getApplicationContext(), Search.class));
		Toast.makeText(this,item.getTitle(), Toast.LENGTH_LONG).show();
        return true;    

	}
	/*public void onCreateContextMenu(ContextMenu menu, View view, 
		    ContextMenuInfo menuInfo) 
		    {
		        getMenuInflater().inflate(R.menu.main, menu);
		    }*/
	/*public boolean onContextItemSelected(MenuItem item)
    {    
    	Toast.makeText(this, item.getTitle(), Toast.LENGTH_LONG).show();
    	return true;
    }*/
	public void setOnItemClickListener(AdapterView<?> parent, View view,
			int position, long id) {
		// TODO Auto-generated method stub

	}

}