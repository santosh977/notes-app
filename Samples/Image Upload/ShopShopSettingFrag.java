package com.shopFragment;

import java.io.File;
import java.io.IOException;

import mylibs.MyApplication;
import mylibs.Myalert;

import org.json.JSONArray;
import org.json.JSONObject;

import android.app.Activity;
import android.app.ProgressDialog;
import android.content.Intent;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.net.Uri;
import android.os.AsyncTask;
import android.os.Bundle;
import android.provider.MediaStore.MediaColumns;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.CompoundButton.OnCheckedChangeListener;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.ScrollView;

import com.fragment.MultipartUtility;
import com.wscube.barginwindow.R;

public class ShopShopSettingFrag extends Fragment {

	
	Button brouwseButton, SendShopShopInfoButton;
	ImageView ShopShopBrowseImg;

	Bitmap bm;

	private final int SELECT_FILE = 1;

	String uploadphotofile;
    EditText ShopShhippingEdittext,PaypalIDEdittext;
    
    String getShopShhippingEdittext,getPaypalIDEdittext;
    
    CheckBox ShopShopSettingCheck;
    
    ScrollView ShopShopSettingScrollView;
	
	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View view = inflater.inflate(R.layout.shop_shop_setting, container,
				false);
		brouwseButton = (Button) view.findViewById(R.id.browseShopShopButton);
		ShopShhippingEdittext=(EditText) view.findViewById(R.id.ShopShhippingEdittext);
		ShopShopSettingCheck=(CheckBox) view.findViewById(R.id.ShopShopSettingCheck);
		PaypalIDEdittext=(EditText) view.findViewById(R.id.PaypalIDEdittext);
		SendShopShopInfoButton = (Button) view
				.findViewById(R.id.SendShopShopInfoButton);
		ShopShopBrowseImg = (ImageView) view
				.findViewById(R.id.ShopShopBrowseImg);
		
		ShopShopSettingScrollView=(ScrollView) view.findViewById(R.id.ShopShopSettingScrollView);
		ShopShopSettingScrollView.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
			System.out.println("ShopShopSettingScrollView back ground was clicked>?>>>>>>>");	
			}
		});

		brouwseButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				Intent intent = new Intent(
						Intent.ACTION_PICK,
						android.provider.MediaStore.Images.Media.EXTERNAL_CONTENT_URI);
				intent.setType("image/*");
				startActivityForResult(
						Intent.createChooser(intent, "Select File"),
						SELECT_FILE);
			}
		});

		SendShopShopInfoButton.setOnClickListener(new OnClickListener() {

			@Override
			public void onClick(View arg0) {
				// TODO Auto-generated method stub
				getShopShhippingEdittext=ShopShhippingEdittext.getText().toString();
				if (ShopShopSettingCheck.isChecked()) {
					getPaypalIDEdittext=PaypalIDEdittext.getText().toString();	
				}
				
				new PostpollsAsync().execute();
			}
		});
		
		ShopShopSettingCheck.setOnCheckedChangeListener(new OnCheckedChangeListener() {
			
			@Override
			public void onCheckedChanged(CompoundButton arg0, boolean Checked) {
				// TODO Auto-generated method stub
				System.out.println("check box Clicked>>>>> ");
				if (Checked) {
					PaypalIDEdittext.setVisibility(View.VISIBLE);
					
				}
				else{
					PaypalIDEdittext.setVisibility(View.GONE);	
				}
				
			}
		});
		

		return view;
	}

	@Override
	public void onActivityResult(int requestCode, int resultCode, Intent data) {
		super.onActivityResult(requestCode, resultCode, data);
		if (requestCode == SELECT_FILE) {
			Uri selectedImageUri = data.getData();
			String tempPath = getPath(selectedImageUri, getActivity());
			uploadphotofile = tempPath;
			System.out.println("Image Path>>>>" + uploadphotofile);
			BitmapFactory.Options btmapOptions = new BitmapFactory.Options();
			bm = BitmapFactory.decodeFile(tempPath, btmapOptions);
			Drawable d = new BitmapDrawable(getResources(), bm);
			ShopShopBrowseImg.setImageDrawable(d);

		}

	}
	public String getPath(Uri uri, Activity activity) {
		String[] projection = { MediaColumns.DATA };
		Cursor cursor = activity
				.managedQuery(uri, projection, null, null, null);
		int column_index = cursor.getColumnIndexOrThrow(MediaColumns.DATA);
		cursor.moveToFirst();
		return cursor.getString(column_index);
	}

	public class PostpollsAsync extends AsyncTask<Void, Void, Void> {
		String response = "";
		ProgressDialog pd;

		String charset = "UTF-8";

		String requestURL = "http://wscubetech.org/bargain_window/iphone/shop/shop-setting.php";

		@Override
		protected void onPreExecute() {
			super.onPreExecute();
			pd = ProgressDialog.show(getActivity(), "Loading ...",
					"please wait...");
		}

		@Override
		protected Void doInBackground(Void... arg0) {

			// new Get_postpoll().decodejson(New_pollsfragmmentactivity.this,
			// Stats.userid, quesString, hashString, cat_id, option1,
			// option2, option3, option4, pollopen);

			requestURL = requestURL.replace(" ", "%20");
			Log.d("res", requestURL);

			try {
				MultipartUtility multipart = new MultipartUtility(requestURL,
						charset);

				multipart.addHeaderField("User-Agent", "CodeJava");
				multipart.addHeaderField("Test-Header", "Header-Value");

				// multipart.addFormField("description", "Cool Pictures");
				// multipart.addFormField("keywords", "Java,upload,Spring");

				multipart.addFormField("shop_shipping", getShopShhippingEdittext);
				
			if (ShopShopSettingCheck.isChecked()) {
				multipart.addFormField("shop_paypal", "1");
				multipart.addFormField("shop_paypalid", getPaypalIDEdittext);
				}
			else{
				multipart.addFormField("shop_paypal", "0");
				multipart.addFormField("shop_paypalid", "");
			}
				
				multipart.addFormField("shop_id", MyApplication.getInstance()
						.getStaffLoginId());

				multipart.addFilePart("file", new File(uploadphotofile));

				response = multipart.finish().toString();

				Log.d("RESPONSE", response);

			} catch (IOException ex) {
				Log.d("hii", ex.toString());
			}

			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			super.onPostExecute(result);
			pd.dismiss();
			try {
				JSONArray jarr = new JSONArray(response);
				JSONObject objJson = jarr.getJSONObject(0);
				JSONObject objJson1 = objJson.getJSONObject("response");
				String resultfinal = objJson1.getString("result");
				String Message=objJson1.getString("Message");
				Log.d("result", resultfinal);
				if (resultfinal.equalsIgnoreCase("0")) {
				new Myalert().alert(getActivity(), Message);
				} else if (resultfinal.equalsIgnoreCase("1")) {
					new Myalert().alert(getActivity(), Message);
				}
			} catch (Exception e) {
				e.printStackTrace();
			}
         
		}
	}

}
