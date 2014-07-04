package com.example.notes;

import android.app.Activity;
import android.content.Context;
import android.content.res.TypedArray;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.BaseAdapter;
import android.widget.Gallery;
import android.widget.ImageView;
import android.widget.Toast;
@SuppressWarnings("deprecation")
public class Homepage extends Activity {
	Integer[] imageIDs = {
            R.drawable.asquz,
            R.drawable.blu1,
            R.drawable.bns,
            R.drawable.cht,
            R.drawable.clg12,
            R.drawable.ll,
            R.drawable.share
    };

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.homepage);
		Gallery gallery = (Gallery) findViewById(R.id.gallery1); 
        gallery.setAdapter(new ImageAdapter(this)); 
        gallery.setOnItemClickListener(new OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, View v, int position, long id)
            {
                Toast.makeText(getBaseContext(),
                        "pic" + (position + 1) + " selected",
                        Toast.LENGTH_SHORT).show();

                //---display the images selected---
                ImageView imageView = (ImageView) findViewById(R.id.image1); 
                imageView.setImageResource(imageIDs[position]);
            } 
        });

    }

    public class ImageAdapter extends BaseAdapter {
        private Context context;
        private int itemBackground;
        public ImageAdapter(Context c)
        {
            context = c;

            //---sets a grey background; wraps around the images
            TypedArray a =
                obtainStyledAttributes(R.styleable.MyGallery); 
            itemBackground = a.getResourceId(
                R.styleable.MyGallery_android_galleryItemBackground, 0);
            a.recycle();
        }

        //---returns the number of images---
        public int getCount() {
            return imageIDs.length;
        }

        //---returns the ID of an item---
        public Object getItem(int position) {
            return position;
        }

        //---returns the ID of an item---
        public long getItemId(int position) {
            return position;
        }

        //---returns an ImageView view---
        public View getView(int position, View convertView, ViewGroup parent) {
            ImageView imageView = new ImageView(context);
            imageView.setImageResource(imageIDs[position]); 
            imageView.setScaleType(ImageView.ScaleType.FIT_XY); 
            imageView.setLayoutParams(new Gallery.LayoutParams( 150, 120 )); 
            imageView.setBackgroundResource(itemBackground); 
            return imageView;
        } 
    }

    
}

