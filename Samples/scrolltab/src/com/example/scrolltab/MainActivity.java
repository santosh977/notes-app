package com.example.scrolltab;

import java.util.ArrayList;

import com.example.scrolltab.R;

import android.app.TabActivity;
import android.content.Context;
import android.os.Bundle;
import android.renderscript.FileA3D.IndexEntry;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TabHost;
import android.widget.TextView;

@SuppressWarnings("deprecation")
public class MainActivity extends TabActivity implements TabHost.TabContentFactory {
     ListView lv;
     TextView txt;
     ImageView img;
     Button btn;
     ArrayList<String> arr = new ArrayList<String>();
     ArrayList<String> arr1 = new ArrayList<String>();
    ArrayList<Integer> arr2 = new ArrayList<Integer>();
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		lv = (ListView)findViewById(R.id.listView1);
		lv.setAdapter(new IconicAdapter(this));
		 arr.add("sharma");
		 arr.add("sharma");
		 arr.add("sharma");
		 arr.add("sharma");
		 arr.add("sharma");
		 arr.add("sharma");
		 arr.add("sharma");
		 arr.add("sharma");
		 arr.add("sharma");
		 arr1.add("shar");
		 arr1.add("shma");
		 arr1.add("srma");
		 arr1.add("shrma");
		 arr1.add("shrma");
		 arr1.add("sarma");
		 arr1.add("sarma");
		 arr1.add("srma");
		 arr1.add("sma");
		 Integer[] arr2 = {
		            R.drawable.pic1,
		            R.drawable.pic2,		            
		            R.drawable.pic3,
		            R.drawable.pic4,
		            R.drawable.pic5,
		            R.drawable.pic6,
		            R.drawable.pic7,
		            R.drawable.pic8,
		            R.drawable.pic9,
		            R.drawable.pic10,
		            R.drawable.pic11
		    };
		final TabHost tabHost = getTabHost();

        for (int i=1; i <= 6; i++) {
            String name = "Tab " + i;
            tabHost.addTab(tabHost.newTabSpec(name)
                    .setIndicator(name)
                    .setContent(this));
        }	
	}
	 public View createTabContent(String tag) {
	        final TextView tv = new TextView(this);
	        tv.setText("Content for tab with tag " + tag);
	        return tv;
	    }
	 

private class IconicAdapter extends ArrayAdapter<String>{

	public IconicAdapter(Context context) {
		super(context, R.layout.list, R.id.textView1, arr);
		// TODO Auto-generated constructor stub
	}
	public View getView(int position, View view, ViewGroup parent) {
		View list =super.getView(position, view, parent);
		img = (ImageView)list.findViewById(R.id.imageView1);
		txt =(TextView)list.findViewById(R.id.textView2);
		btn =(Button)list.findViewById(R.id.button1);
	txt.setText(arr1.get(position));
	//img.setImageDrawable(arr2.get(position));
	//img.setImageResource(arr2.get(position));
	return list;
}
}

}