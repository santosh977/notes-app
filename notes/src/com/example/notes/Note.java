package com.example.notes;

import android.annotation.SuppressLint;
import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

@SuppressLint("NewApi")
public class Note extends Fragment {
	// int i;
	/*
	 * @Override protected void onCreate(Bundle savedInstanceState) {
	 * super.onCreate(savedInstanceState); setContentView(R.layout.note);}
	 * public void Search(View v) { startActivity(new
	 * Intent(Note.this,Search.class));
	 * 
	 * } public void Upload(View v) { startActivity(new
	 * Intent(Note.this,Upload.class));
	 * 
	 * } public void Switchprofile(View v) { startActivity(new
	 * Intent(Note.this,Profdiv.class));
	 * 
	 * }
	 */
	TextView tv;

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.notes, container, false);

		return rootView;
	}

}
