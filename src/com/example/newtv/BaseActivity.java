package com.example.newtv;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class BaseActivity extends Activity {

	String[] strArr = new String[] { "选中图片放大", " LinearLayout按下(pressed)或获取焦点（focused)时背景设置不同颜色或图片", "XML解析", "zhaoliu", "qianqi" };
	private ListView lv;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_base);
		lv = (ListView) findViewById(R.id.lv);
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(BaseActivity.this, android.R.layout.simple_list_item_1,
				strArr);
		lv.setAdapter(adapter);
		final Intent intent=new Intent();
		lv.setOnItemClickListener(new OnItemClickListener() {

			@Override
			public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
				// TODO Auto-generated method stub
				Toast.makeText(getApplicationContext(), "" + position + strArr[position], Toast.LENGTH_SHORT).show();
				switch (position) {
				case 0:
					intent.setClass(BaseActivity.this, MainActivity.class);
					break;
				case 1:
					intent.setClass(BaseActivity.this, SecondActivity.class);
					break;
				case 2:
					intent.setClass(BaseActivity.this, XMLPullActivity.class);
					break;
				case 3:

					break;

				default:
					break;
				}
				startActivity(intent);
			}
		});
	}

}
