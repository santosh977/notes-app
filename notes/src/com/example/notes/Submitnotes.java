package com.example.notes;

import android.app.ListActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.CheckedTextView;
import android.widget.ListView;
import android.widget.Toast;

public class Submitnotes extends ListActivity {

	String[] Subjects = { "DAA", "AOS", "AI", "TOC", "DBMS", "DMS",

	};

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_submitnotes);

		ListView lstView = getListView();
		// lstView.setChoiceMode(ListView.CHOICE_MODE_NONE);
		// lstView.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
		lstView.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
		lstView.setTextFilterEnabled(true);

		setListAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_checked, Subjects));
	}

	public void onListItemClick(ListView parent, View v, int position, long id) {
		CheckedTextView item = (CheckedTextView) v;
		Toast.makeText(this,
				Subjects[position] + " checked : " + !item.isChecked(),
				Toast.LENGTH_SHORT).show();
		// item.removeTextChangedListener(watcher);
	}

}
