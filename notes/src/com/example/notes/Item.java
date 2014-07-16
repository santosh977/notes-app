package com.example.notes;

import android.graphics.Bitmap;

/**
 * 
 * @author manish.s
 * 
 */

public class Item {
	Bitmap image;
	String title;

	public Item(String title, Bitmap image) {
		super();
		this.title = title;
		this.image = image;

	}

	public Bitmap getImage() {
		return image;
	}

	public void setImage(Bitmap image) {
		this.image = image;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

}
