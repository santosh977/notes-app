package com.example.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Loginpage extends Activity {@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.loginpage);}
public void Function1(View v) {
	startActivity(new Intent(Loginpage.this,Homepage.class));
     }
public void onClick(View v) {
	startActivity(new Intent(Loginpage.this,Signup.class));
	
     }
}
    

	/*Button b=(Button)findViewById(R.id.button1);
	Button b1=(Button)findViewById(R.id.button2);}
	public void Function1(View v) {
		startActivity(new Intent(Loginpage.this,Homepage.class));}
	//}
	b.setOnClickListener(new OnClickListener() {
		
		@Override
		public void onClick(View v) {
			startActivity(new Intent(Loginpage.this,Homepage.class));
			
		}
	});
	}
*/

	
	
	
	
	
	
	
	