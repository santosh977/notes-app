package com.example.notes;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

public class Loginpage extends Activity {@Override
	protected void onCreate(Bundle savedInstanceState) {
	super.onCreate(savedInstanceState);
	setContentView(R.layout.loginpage);}
public void Function1(View v) {
	startActivity(new Intent(Loginpage.this,Homepage1.class));
     }
public void onClick(View v) {
	startActivity(new Intent(Loginpage.this,Signup.class));
	
     }
public void imageSelect(View v) {
	switch(v.getId())
{
	case R.id.imageView0:
		startActivity(new Intent(getApplicationContext(),NotesActivity.class));
		break;
	case R.id.imageView2:
		startActivity(new Intent(getApplicationContext(),Members.class));
		break;
	default:Toast.makeText(getApplicationContext(), "TODO",Toast.LENGTH_LONG).show();
}
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

	
	
	
	
	
	
	
	