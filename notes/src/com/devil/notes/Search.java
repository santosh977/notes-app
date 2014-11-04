package com.devil.notes;

import android.os.Bundle;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class Search extends Action {
	// int i;
	Spinner s1, s2, s3, s4, s5, s6, s7, s8;
	String[] country = { "India", "Australia",

	};

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
	
	String[] category = { "Notes", "Assignment", "quizzes",

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.search);
		// ---Spinner View---
		s4= (Spinner) findViewById(R.id.spinner4);
		ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, mainstream);
		s4.setAdapter(adapter4);
		s4.setPrompt("Select your stream");

		s1 = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, state);
		s1.setAdapter(adapter1);
		s1.setPrompt("Select a State");

		s2 = (Spinner) findViewById(R.id.spinner2);

		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, city);
		s2.setAdapter(adapter2);
		s2.setPrompt("Select a City");

		s3 = (Spinner) findViewById(R.id.spinner3);
		ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, collagename);
		s3.setAdapter(adapter3);
		s3.setPrompt("Select a College");

		s5 = (Spinner) findViewById(R.id.spinner5);
		ArrayAdapter<String> adapter5= new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, branch);
		s5.setAdapter(adapter5);
		s5.setPrompt("Select a Branch");

		s6 = (Spinner) findViewById(R.id.spinner6);
		ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, year);
		s6.setAdapter(adapter6);
		s6.setPrompt("Select a Year");
/*
		s7 = (Spinner) findViewById(R.id.spinner7);
		ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, semester);
		s7.setAdapter(adapter6);
		s7.setPrompt("Select a Semester");*/
		s8 = (Spinner) findViewById(R.id.spinner8);
		ArrayAdapter<String> adapter8 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, country);
		s8.setAdapter(adapter8);
		s8.setPrompt("Select a Country");
		
		  s7 = (Spinner) findViewById(R.id.spinner7); ArrayAdapter<String>
		  adapter7 = new ArrayAdapter<String>(this,
		  android.R.layout.simple_spinner_item, category);
		  s7.setAdapter(adapter7);
		  s7.setPrompt("Select a Category");
		 

	}

	public boolean onOptionsItemSelected(MenuItem item) {
		return super.onOptionsItemSelected(item);
	}

}