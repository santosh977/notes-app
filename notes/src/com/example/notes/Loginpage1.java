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
		boolean founduser=false;
		DatabaseHandler db = new DatabaseHandler(this);
		List<Users> users = db.getAllContacts();       
		//Toast.makeText(getApplicationContext(),(((EditText)findViewById(R.id.Editpass)).getText()).toString(), Toast.LENGTH_LONG).show();
        for (Users cn : users) {
           // String log = "\n\n Name: " + cn.getName() + " ,Password: " + cn.getPassword();
                // Writing Contacts to log
        //Log.d("Name: ", log);
         if( cn.getPassword().equals((((EditText)findViewById(R.id.Editpass)).getText()).toString())&&cn.getEmail().equals((((EditText)findViewById(R.id.EditMail)).getText()).toString()))
         {founduser=true;
        	 startActivity(new Intent(Loginpage1.this,Homepage1.class));
        	 finish();
         }}
        /*TextView tv=(TextView)findViewById(R.id.textView1);
        tv.setText("UsersList:");
        //DatabaseHandler db = new DatabaseHandler(this);
		//List<Users> users1 = db.getAllContacts();       
        for (Users cn : users) {
        tv.setText(tv.getText()+":"+cn.getName());}*/
if(!founduser)Toast.makeText(getApplicationContext(),"Wrong Email or Password", Toast.LENGTH_LONG).show();
        }	
	public void Function9(View v) {
		startActivity(new Intent(Loginpage1.this,Signup.class));
		
}

}



	