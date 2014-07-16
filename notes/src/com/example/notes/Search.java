package com.example.notes;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Search extends Activity {
	// int i;
	Spinner s1, s2, s3, s4, s5, s6, s7;

	String[] mainstream = { "Engineering", "MBA",

	};
	String[] state = { "raj", "jharkhand", "gujrat", "dehli",

	};
	String[] city = { "jodhpur", "jaipur", "kota", "surat", "ranchi",

	};
	String[] collagename = { "mbm", "iit", "nlu", "jnu",

	};

	String[] branch = { "it", "cse", "me", "ece", "eee",

	};
	String[] year = { "1", "2", "3", "4", "5",

	};
	String[] semester = { "1", "2", "3", "4", "5", "6", "7", "8", "9", "10",

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		// ---Spinner View---
		s4 = (Spinner) findViewById(R.id.spinner4);
		ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, mainstream);
		s4.setAdapter(adapter7);

		s4.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				int index = s4.getSelectedItemPosition();
				/*
				 * Toast.makeText(getBaseContext(), "You have selected item : "
				 * + mainstream[index], Toast.LENGTH_SHORT).show();
				 */
			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		s1 = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, state);
		s1.setAdapter(adapter2);

		s1.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				int index = s1.getSelectedItemPosition();
				/*
				 * Toast.makeText(getBaseContext(), "You have selected item : "
				 * + state[index], Toast.LENGTH_SHORT).show();
				 */
			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		s2 = (Spinner) findViewById(R.id.spinner2);
		ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, city);
		s2.setAdapter(adapter3);

		s2.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				int index = s2.getSelectedItemPosition();
				/*
				 * Toast.makeText(getBaseContext(), "You have selected item : "
				 * + city[index], Toast.LENGTH_SHORT).show();
				 */
			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		s3 = (Spinner) findViewById(R.id.spinner3);
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, collagename);
		s3.setAdapter(adapter1);

		s3.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				int index = s3.getSelectedItemPosition();
				/*
				 * Toast.makeText(getBaseContext(), "You have selected item : "
				 * + collagename[index], Toast.LENGTH_SHORT).show();
				 */
			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});

		s5 = (Spinner) findViewById(R.id.spinner5);
		ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, branch);
		s5.setAdapter(adapter4);

		s5.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				int index = s5.getSelectedItemPosition();
				/*
				 * Toast.makeText(getBaseContext(), "You have selected item : "
				 * + branch[index], Toast.LENGTH_SHORT).show();
				 */
			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		s6 = (Spinner) findViewById(R.id.spinner6);
		ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, year);
		s6.setAdapter(adapter5);

		s6.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				int index = s6.getSelectedItemPosition();
				/*
				 * Toast.makeText(getBaseContext(), "You have selected item : "
				 * + year[index], Toast.LENGTH_SHORT).show();
				 */
			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
		s7 = (Spinner) findViewById(R.id.spinner7);
		ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, semester);
		s7.setAdapter(adapter6);

		s7.setOnItemSelectedListener(new OnItemSelectedListener() {
			public void onItemSelected(AdapterView<?> arg0, View arg1,
					int arg2, long arg3) {
				int index = s7.getSelectedItemPosition();
				/*
				 * Toast.makeText(getBaseContext(), "You have selected item : "
				 * + semester[index], Toast.LENGTH_SHORT).show();
				 */
			}

			public void onNothingSelected(AdapterView<?> arg0) {
			}
		});
	}
}