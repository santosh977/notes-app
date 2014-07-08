package com.example.notes;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends Activity {

TextView loading;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
loading=((TextView)(findViewById(R.id.textView2)));
loading.setTextColor(Color.WHITE);
loading.setText("Loading...\n\nPlease Wait\n\nUn Momento");
	
	Thread timer = new Thread(){
		public void run(){
			try{
				//sleep(3000);
				
			}catch(Exception e){
				e.printStackTrace();
			}finally{
				//Intent openMainActivity =  new Intent("com.boston.startingpoint.MAINACTIVITY");
				Intent openMainActivity =  new Intent(MainActivity.this,Loginpage.class);
				startActivity(openMainActivity);
				finish();
			}
		}
	};
	timer.start();
	//requestWindowFeature(Window.FEATURE_NO_TITLE);
}
/*@Override
protected void onPause() {
	// TODO Auto-generated method stub
	super.onPause();
	mp1.release();
	finish();
}*/
	

}
