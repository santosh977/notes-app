package com.example.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends Activity {


	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
	

	
	Thread timer = new Thread(){
		public void run(){
			try{
				sleep(3000);
				
			}catch(InterruptedException e){
				e.printStackTrace();
			}finally{
				//Intent openMainActivity =  new Intent("com.boston.startingpoint.MAINACTIVITY");
				Intent openMainActivity =  new Intent(MainActivity.this,Loginpage.class);
				startActivity(openMainActivity);
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
