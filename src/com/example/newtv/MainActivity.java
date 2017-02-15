package com.example.newtv;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.view.ViewCompat;
import android.support.v4.view.ViewPropertyAnimatorCompat;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;

public class MainActivity extends Activity implements OnFocusChangeListener, OnClickListener {

	private ImageView img1, img2, img3;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		img1 = (ImageView) findViewById(R.id.imageView1);
		img2 = (ImageView) findViewById(R.id.imageView2);
		img3 = (ImageView) findViewById(R.id.imageView3);
		img1.setOnClickListener(this);
		img2.setOnClickListener(this);
		img3.setOnClickListener(this);
		img1.setFocusable(true);
		img2.setFocusable(true);
		img3.setFocusable(true);
		ViewPropertyAnimatorCompat animate = ViewCompat.animate(img1);
		animate.scaleXBy(1.1f).scaleYBy(1.1f).start();
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		// TODO Auto-generated method stub
		if (hasFocus) {
			switch (v.getId()) {
			case R.id.imageView1:
				ViewPropertyAnimatorCompat animate = ViewCompat.animate(img1);
				animate.scaleXBy(1.1f).scaleYBy(1.1f).start();
				break;

			case R.id.imageView2:
				ViewPropertyAnimatorCompat animate2 = ViewCompat.animate(img2);
				animate2.scaleXBy(1.1f).scaleYBy(1.1f).start();
				break;

			case R.id.imageView3:
				ViewPropertyAnimatorCompat animate3 = ViewCompat.animate(img3);
				animate3.scaleXBy(1.1f).scaleYBy(1.1f).start();
				break;

			default:
				break;
			}
		}
	}

	@Override
	public void onClick(View v) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.imageView1:
			ViewPropertyAnimatorCompat animate = ViewCompat.animate(img1);
			animate.scaleXBy(1.1f).scaleYBy(1.1f).start();
			break;

		case R.id.imageView2:
			ViewPropertyAnimatorCompat animate2 = ViewCompat.animate(img2);
			animate2.scaleXBy(1.1f).scaleYBy(1.1f).start();
			break;

		case R.id.imageView3:
			ViewPropertyAnimatorCompat animate3 = ViewCompat.animate(img3);
			animate3.scaleXBy(1.1f).scaleYBy(1.1f).start();
			break;

		default:
			break;
		}
	}
}
