package com.example.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Homepage1 extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage1);
	}

	/*
	 * public void Function5(View v) { startActivity(new
	 * Intent(Homepage1.this,Note.class));
	 * 
	 * }
	 */
	public void imageSelect(View v) {
		switch (v.getId()) {
		case R.id.notes:
			startActivity(new Intent(getApplicationContext(),
					NotesActivity.class));
			break;
		case R.id.asquz:
			startActivity(new Intent(getApplicationContext(),
					NotesActivity.class));
			break;
		case R.id.tnp1:
			startActivity(new Intent(getApplicationContext(), Members.class));
			break;
		/*
		 * case R.id.notes: startActivity(new
		 * Intent(getApplicationContext(),Note.class)); break;
		 */

		default:
			Toast.makeText(getApplicationContext(), "TODO", Toast.LENGTH_LONG)
					.show();
		}
	}

}
