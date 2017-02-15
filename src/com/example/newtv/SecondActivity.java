package com.example.newtv;

import android.app.Activity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.View.OnFocusChangeListener;
import android.widget.ImageView;
import android.widget.Toast;

public class SecondActivity extends Activity implements OnFocusChangeListener {

	private ImageView ivMenu01;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_second);
		ivMenu01=(ImageView)findViewById(R.id.ivMenu01);
		ivMenu01.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "", Toast.LENGTH_SHORT).show();
//				ivMenu01.setBackgroundResource(R.drawable.left);
			}
		});
	}

	@Override
	public void onFocusChange(View v, boolean hasFocus) {
		// TODO Auto-generated method stub
		switch (v.getId()) {
		case R.id.ivMenu01:

			if (hasFocus) {
				ivMenu01.setBackgroundResource(R.drawable.left); // Focussed
																	// image
			} else {
				ivMenu01.setBackgroundResource(R.drawable.right); // Normal
																	// image
			}

			break;

		default:
			break;
		}
	}
	
	private View.OnTouchListener imageTouchListener = new View.OnTouchListener() {
	    @Override
	    public boolean onTouch(View v, MotionEvent event) {
	        if (event.getAction() == MotionEvent.ACTION_DOWN) {
	            // pointer goes down
	        	ivMenu01.setBackgroundResource(R.drawable.left); // Focussed
	        } else if (event.getAction() == MotionEvent.ACTION_UP) {
	            // pointer goes up
	        	ivMenu01.setBackgroundResource(R.drawable.right); // Focussed
	        }
	        // also let the framework process the event
	        return false;
	    }
	};
}
