package com.example.newtv;

import java.io.InputStream;
import java.util.ArrayList;

import org.xmlpull.v1.XmlPullParser;
import org.xmlpull.v1.XmlPullParserFactory;
import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

public class XMLPullActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_xmlpull);
		parseXml();
	}

	ArrayList<ChannelItem> channels = new ArrayList<ChannelItem>();

	private void parseXml() {
		XmlPullParserFactory factory;
		try {
			InputStream open = getResources().getAssets().open("resource.xml");
			factory = XmlPullParserFactory.newInstance();
			XmlPullParser xpp = factory.newPullParser();
			xpp.setInput(open, "UTF-8");
			int evtType = xpp.getEventType();
			// 一直循环，直到文档结束
			ChannelItem channel = null;
			ArrayList<String> properties = null;
			while (evtType != XmlPullParser.END_DOCUMENT) {
				switch (evtType) {
				case XmlPullParser.START_TAG:
					if (xpp.getName().equals("channel")) {
						channel = new ChannelItem();
						properties = new ArrayList<String>();
						channel.setProperties(properties);
						channel.setName(xpp.getAttributeValue(0));
						channels.add(channel);
					}
					if (xpp.getName().equals("item")) {
						String name = xpp.getAttributeValue(0);
						if (xpp.nextText().equals("true")) {
							properties.add(name);
						}
					}
					break;
				case XmlPullParser.END_TAG:
					break;
				default:
					break;
				}
				// 获得下一个节点的信息
				evtType = xpp.next();
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
