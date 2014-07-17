package com.example.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

public class NewNotes extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_new_notes);
	}

	public void upload(View v) {
		/*NotesDatabaseHandler db = new NotesDatabaseHandler(this);
		db.addContact(new NotesData(((EditText) findViewById(R.id.editText2))
				.getText().toString(), "a", 1, 1, "a", "a", "a",
				((EditText) findViewById(R.id.editText1)).getText().toString()));

		db.getAllContacts();*/
		String url=new String("http://wscubetech.org/app/appkit/upload.php"
				+"?sm_type=raw&sm_category=notes&sm_file="
				+((EditText) findViewById(R.id.editText1)).getText().toString()
				);
		QuickJSON json=new QuickJSON(url);
		json.TABLE_NAME="study_material";
		json.TAG1="sm_file";
		json.execute();
		startActivity(new Intent(getApplicationContext(), scrolltab.class));
		finish();
	}

}
