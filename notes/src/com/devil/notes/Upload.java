package com.devil.notes;

import java.io.InputStream;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Matrix;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class Upload extends Activity {
	// String encodedString;

	String imgPath;
	Bitmap thumb,selectedImage;

	private final int sel_pic = 1;
	private ImageView prof;
	Intent imageSelectintenetIntent;

	Spinner s1, s2, s3, s4, s5, s6, s7, s8;

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
	String[] country = { "India", "Australia",

	};

	String[] category = { "Notes", "Assignment", "quizzes", "",

	};

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.upload);
		prof = (ImageView) findViewById(R.id.imageView1);

		// ---Spinner View---
		s4 = (Spinner) findViewById(R.id.spinner4);
		ArrayAdapter<String> adapter7 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, mainstream);
		s4.setAdapter(adapter7);

		s1 = (Spinner) findViewById(R.id.spinner1);
		ArrayAdapter<String> adapter2 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, state);
		s1.setAdapter(adapter2);
		s1.setPrompt("Select a State");

		s2 = (Spinner) findViewById(R.id.spinner2);

		ArrayAdapter<String> adapter3 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, city);
		s2.setAdapter(adapter3);
		s2.setPrompt("Select a City");

		s3 = (Spinner) findViewById(R.id.spinner3);
		ArrayAdapter<String> adapter1 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, collagename);
		s3.setAdapter(adapter1);
		s3.setPrompt("Select a College");

		s5 = (Spinner) findViewById(R.id.spinner5);
		ArrayAdapter<String> adapter4 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, branch);
		s5.setAdapter(adapter4);
		s5.setPrompt("Select a Branch");

		s6 = (Spinner) findViewById(R.id.spinner6);
		ArrayAdapter<String> adapter5 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, year);
		s6.setAdapter(adapter5);
		s6.setPrompt("Select a Year");
		s7 = (Spinner) findViewById(R.id.spinner7);
		ArrayAdapter<String> adapter6 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, country);
		s7.setAdapter(adapter6);
		s7.setPrompt("Select a Country");
		s8 = (Spinner) findViewById(R.id.spinner8);
		ArrayAdapter<String> adapter8 = new ArrayAdapter<String>(this,
				android.R.layout.simple_spinner_item, category);
		s8.setAdapter(adapter8);
		s8.setPrompt("Select a Category");

		((Button) findViewById(R.id.button3))
				.setOnClickListener(new OnClickListener() {

					@Override
					public void onClick(View arg0) {
						startActivity(new Intent(getApplicationContext(),
								NewNotes.class));
						finish();
					}
				});
	}

	public void UploadFunc(View v) {

		/*
		 * if(encodedString!=null){ String url = new
		 * String("http://wscubetech.org/app/appkit/upload.php" +
		 * "?sm_type=pic&sm_category=notes&sm_file=" + encodedString); //String
		 * CRLF="\n"; //url.replaceAll(CRLF,"A");
		 * url.replaceAll("[^A-Za-z0-9/+]", ""); QuickJSON json = new
		 * QuickJSON(url); json.TABLE_NAME = "study_material"; json.TAG1 =
		 * "sm_file"; Log.d("Encoded::",encodedString);
		 * //Toast.makeText(getApplicationContext(),url.substring(0,60),
		 * //Toast.LENGTH_LONG).show(); json.execute(); startActivity(new
		 * Intent(getApplicationContext(), scrolltab.class)); finish();} else{
		 * Toast.makeText(getApplicationContext(),"Select a image",
		 * Toast.LENGTH_LONG).show(); }
		 */
		if (imgPath != null) {
			// new
			// UploadFile(Environment.getExternalStorageDirectory().getAbsolutePath(),"picture.jpg","http://wscubetech.org/app/appkit/uploadfile.php",Upload.this);
			
			String dirPath=imgPath.substring(0, imgPath.lastIndexOf('/'));
			String filePath=imgPath.substring(imgPath.lastIndexOf('/') + 1,
					imgPath.length());
			
			
			/*File file = new File(dirPath, filePath);
			try {
				OutputStream fOut = null;
				thumb.compress(Bitmap.CompressFormat.JPEG, 85, fOut);
				fOut.flush();
				fOut.close();
				fOut = new FileOutputStream(file);
			} catch (Exception e) {
				Toast.makeText(getApplicationContext(),e.toString(),
						Toast.LENGTH_LONG).show();
			}*/
			new UploadFile(dirPath,
					filePath,
					"http://wscubetech.org/app/appkit/uploadfile.php",
					Upload.this);
			String url = new String(
					"http://wscubetech.org/app/appkit/upload.php"
							+ "?sm_type=pic&sm_category=notes&sm_file="
							+ filePath);
			QuickJSON json = new QuickJSON(url);
			json.TABLE_NAME = "study_material";
			json.TAG1 = "sm_file";
			json.execute();
			startActivity(new Intent(getApplicationContext(), scrolltab.class));
			finish();
		} else {
			Toast.makeText(getApplicationContext(), "Select a File",
					Toast.LENGTH_LONG).show();
		}
	}

	/*
	 * if (((EditText) findViewById(R.id.editText1)) .getText() .toString()
	 * .equals(((EditText) findViewById(R.id.editText2)).getText() .toString()))
	 */
	/*
	 * { DatabaseHandler db = new DatabaseHandler(this); db.addContact(new
	 * Users(((EditText) findViewById(R.id.editText1)) .getText().toString(),
	 * ((Spinner) findViewById(R.id.spinner5)).getSelectedItem() .toString(),
	 * Integer .parseInt((((Spinner) findViewById(R.id.spinner6))
	 * .getSelectedItem()).toString()), Integer .parseInt((((Spinner)
	 * findViewById(R.id.spinner1)) .getSelectedItem()).toString()), ((Spinner)
	 * findViewById(R.id.spinner3)).getSelectedItem() .toString(), ((Spinner)
	 * findViewById(R.id.spinner2)).getSelectedItem() .toString(), ((EditText)
	 * findViewById(R.id.textView1)).getText() .toString(), ((EditText)
	 * findViewById(R.id.editText9)).getText() .toString()));
	 * 
	 * startActivity(new Intent(Upload.this,Profdiv.class)); finish(); }}
	 */

	@SuppressLint("NewApi")
	public void Clik(View view) {
		// Intent pickerIntent = new Intent(Intent.ACTION_ATTACH_DATA);
		// pickerIntent.setTypeAndNormalize(INPUT_SERVICE);
		// startActivity(pickerIntent);

		Intent photoPickerIntent = new Intent(Intent.ACTION_PICK);
		photoPickerIntent.setType("image/*");
		startActivityForResult(photoPickerIntent, sel_pic);
		// Log.v(ALARM_SERVICE, encodedString);

		/*
		 * Intent intent = new
		 * Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE); File file =
		 * new File(Environment.getExternalStorageDirectory(), "MyPhoto.jpg");
		 * outputFileUri = Uri.fromFile(file);
		 * intent.putExtra(MediaStore.EXTRA_OUTPUT, outputFileUri);
		 * startActivityForResult(intent, TAKE_PICTURE); }
		 * 
		 * Intent photoPickerIntent = new Intent( Intent.ACTION_PICK);
		 * photoPickerIntent.setType("image/*");
		 * startActivityForResult(photoPickerIntent, sel_pic);
		 */

	}

	@Override
	protected void onActivityResult(int requestCode, int resultCode,
			Intent imageReturnedIntent) {
		super.onActivityResult(requestCode, resultCode, imageReturnedIntent);
		imageSelectintenetIntent = imageReturnedIntent;
		switch (requestCode) {
		case sel_pic:
			if (resultCode == RESULT_OK) {
				if (requestCode == 1/* PICKER */) {
					try {
						final Uri imageUri = imageReturnedIntent.getData();

						// byte[] bytes;
						// byte[] buffer = new byte[8192];
						/*
						 * int bytesRead; ByteArrayOutputStream output = new
						 * ByteArrayOutputStream(); try { while ((bytesRead =
						 * imageStream.read(buffer)) != -1) {
						 * output.write(buffer, 0, bytesRead); } } catch
						 * (IOException e) { e.printStackTrace(); }
						 */
						// bytes = output.toByteArray();
						// encodedString =
						// Base64.encodeToString(bytes,Base64.NO_PADDING|Base64.NO_WRAP);

						/*
						 * imageStream = getContentResolver()
						 * .openInputStream(imageUri);
						 */

						String[] medData = { MediaStore.Images.Media.DATA };
						// query the data
						Cursor picCursor = managedQuery(imageUri, medData,
								null, null, null);
						if (picCursor != null) {
							// get the path string
							int index = picCursor
									.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
							picCursor.moveToFirst();
							imgPath = picCursor.getString(index);
						} else
							imgPath = imageUri.getPath();
						/*
						 * Toast.makeText(getApplicationContext(), imgPath,
						 * Toast.LENGTH_LONG).show();
						 */
						InputStream imageStream = getContentResolver()
								.openInputStream(imageUri);

						selectedImage = BitmapFactory
								.decodeStream(imageStream);
						/*
						 * Toast.makeText(getApplicationContext(),encodedString,
						 * Toast.LENGTH_LONG).show();
						 */
						prof.setImageBitmap(selectedImage);
						((TextView) findViewById(R.id.textView1))
								.setText(imgPath);
						//Bitmap thumb = Bitmap.createScaledBitmap(selectedImage, 120, 120, false);
						//thumb=getResizedBitmap(selectedImage, 200,160);
						//if(thumb.equals(thumb));

					} catch (Exception e) {
						e.printStackTrace();
					}
				}

			}
		}
	}
	
	public Bitmap getResizedBitmap(Bitmap bm, int newHeight, int newWidth) {
	    int width = bm.getWidth();
	    int height = bm.getHeight();
	    float scaleWidth = ((float) newWidth) / width;
	    float scaleHeight = ((float) newHeight) / height;
	    // CREATE A MATRIX FOR THE MANIPULATION
	    Matrix matrix = new Matrix();
	    // RESIZE THE BIT MAP
	    matrix.postScale(scaleWidth, scaleHeight);

	    // "RECREATE" THE NEW BITMAP
	    Bitmap resizedBitmap = Bitmap.createBitmap(bm, 0, 0, width, height, matrix, false);
	    return resizedBitmap;
	}
}