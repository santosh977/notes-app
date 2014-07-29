package com.devil.notes;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import android.content.Context;
import android.os.Environment;
import android.widget.Toast;

public class Downld {

	// ProgressBar pb;
	// Dialog dialog;
	int downloadedSize = 0;
	int totalSize = 0;
	// TextView cur_val;
	public String dwnload_file_path, file_name;
	Context c;

	Downld(String Path, String FileName, Context context) {
		c = context;
		dwnload_file_path = Path;
		file_name = FileName;
		downloadFile();
	}

	void downloadFile() {

		try {
			URL url = new URL(dwnload_file_path);
			HttpURLConnection urlConnection = (HttpURLConnection) url
					.openConnection();
			urlConnection.setRequestMethod("GET");
			urlConnection.setDoOutput(true);

			// connect
			urlConnection.connect();

			// set the path where we want to save the file
			File SDCardRoot = new File(Environment
					.getExternalStorageDirectory().getAbsolutePath()
					+ "/NotesStation/");
			// create a new file, to save the downloaded file
			if (!SDCardRoot.exists())
				SDCardRoot.mkdir();
			File file = new File(SDCardRoot, file_name);
			// File file = new File(SDCardRoot+"/NotesStation/",file_name);
			// if(!file.exists()){file.mkdir();}
			// while(!file.exists()){file.mkdir();}
			FileOutputStream fileOutput = new FileOutputStream(file);

			// Stream used for reading the data from the internet
			InputStream inputStream = urlConnection.getInputStream();

			// this is the total size of the file which we are downloading
			totalSize = urlConnection.getContentLength();

			// create a buffer...
			byte[] buffer = new byte[1024];
			int bufferLength = 0;

			while ((bufferLength = inputStream.read(buffer)) > 0) {
				fileOutput.write(buffer, 0, bufferLength);
				downloadedSize += bufferLength;
				// update the progressbar //
			}
			// close the output stream when complete //
			fileOutput.close();

		} catch (final MalformedURLException e) {
			showError("Error : MalformedURLException " + e);
			e.printStackTrace();
		} catch (final IOException e) {
			showError("Error : IOException " + e);
			e.printStackTrace();
		} catch (final Exception e) {
			showError("Error : Please check your internet connection " + e);
		}
	}

	void showError(final String err) {

		Toast.makeText(c, err, Toast.LENGTH_LONG).show();

	}
}