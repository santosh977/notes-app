package com.devil.notes;

import java.io.File;

import android.app.Activity;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class OpenNoteView extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_open_note_view);
		Bundle extraData = getIntent().getExtras();
		if (extraData != null) {
			Toast.makeText(getApplicationContext(),
					"Path:" + extraData.getString("noteImagePath"),
					Toast.LENGTH_LONG).show();
			Toast.makeText(getApplicationContext(),
					"Name:" + extraData.getString("noteImageName"),
					Toast.LENGTH_LONG).show();
			// Toast.makeText(getApplicationContext(),
			// "Pos:"+extraData.getInt("noteImagePosition"),Toast.LENGTH_LONG).show();
			Toast.makeText(getApplicationContext(),
					"Type:" + extraData.getCharSequence("noteImageType"),
					Toast.LENGTH_LONG).show();
			TextView noteText = (TextView) findViewById(R.id.textView1);
			noteText.setText(String.valueOf(extraData
					.getInt("noteImagePosition"))
					+ extraData.getCharSequence("noteImageText"));
			ImageView noteImage = (ImageView) findViewById(R.id.imageView1);
			File NotesFile = new File(extraData.getString("noteImagePath"),
					extraData.getString("noteImageName"));
			if (NotesFile.exists() && NotesFile.length() != 0)
				// noteImage.setImageURI(Uri.fromFile(NotesFile));
				// InputStream imageStream =
				// getContentResolver().openInputStream();
				// noteImage = BitmapFactory.decodeStream(imageStream);
				noteImage.setImageBitmap(BitmapFactory.decodeFile(extraData
						.getString("noteImagePath")
						+ extraData.getString("noteImageName")));
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.open_note_view, menu);
		return true;
	}

}
