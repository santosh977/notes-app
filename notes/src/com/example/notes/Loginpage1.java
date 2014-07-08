package com.example.notes;

import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Loginpage1 extends Activity {
	View rootView;
	String editMailString = "";
	String editpassString = "";
	String dialogMailString = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.loginpage1);}
	public void Function8(View v) {
		DatabaseHandler db = new DatabaseHandler(this);
		List<Users> users = db.getAllContacts();       
        
        for (Users cn : users) {
            //String log = "Id: "+cn.getID()+" ,Name: " + cn.getName() + " ,Phone: " + cn.getPhoneNumber();
                // Writing Contacts to log
        //Log.d("Name: ", log);
         if( cn.getPassword()==((EditText)findViewById(R.id.Editpass)).toString()&&cn.getPassword()==((EditText)findViewById(R.id.Editpass)).toString())
         {
        	 startActivity(new Intent(Loginpage1.this,Homepage1.class)); 
         }
        
         else
         {
        	  Toast.makeText(getApplicationContext(),"Wrong Email or Password", Toast.LENGTH_LONG).show();
        	 }
        }
		
		
		
	     }	
	public void Function9(View v) {
		startActivity(new Intent(Loginpage1.this,Signup.class));
		
}

}



	