package com.sas.delhibusnavigator;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.SQLException;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import java.io.IOException;
import java.util.LinkedList;

public class RouteActivity extends Activity {

	String bno;
	TextView tvBNo, tvSource, tvDestination;
	ListView lv;
	//AdView av;
	DatabaseHelper myDbHelper;
	LinkedList<String> ll;
	ArrayAdapter<String> aa;
	
	//private InterstitialAd interstitial;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_route);
		setupActionBar();
		
		//interstitial = new InterstitialAd(this, "");
		//interstitial.loadAd(new AdRequest());
		//interstitial.setAdListener(this);
		
		Intent t = getIntent();
		bno = t.getStringExtra("bno");
		tvBNo = (TextView) findViewById(R.id.etBNo);
		tvSource = (TextView) findViewById(R.id.etSource);
		tvDestination = (TextView) findViewById(R.id.etDestination);
		lv = (ListView) findViewById(R.id.lvRoute);
		//av = (AdView) findViewById(R.id.avRoute);
		myDbHelper = new DatabaseHelper(this);
		try {
			myDbHelper.createDatabase();
		} catch (IOException e) {
			throw new Error("Unable to create database.");
		}
		try {
			myDbHelper.openDatabase();
		} catch (SQLException sqle) {
			throw sqle;
		}
		Cursor c = myDbHelper.getSD(bno);
		c.moveToFirst();
		tvBNo.setText(bno);
		tvSource.setText(c.getString(1));
		tvDestination.setText(c.getString(2));
		c.close();
		ll = myDbHelper.getStops(bno);
		aa = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, ll);
		lv.setAdapter(aa);
		//av.loadAd(new AdRequest());
	}

	private void setupActionBar() {
		getActionBar().setDisplayHomeAsUpEnabled(true);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.route, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		switch (item.getItemId()) {
		case android.R.id.home:
			this.finish();
			return true;
		}
		return super.onOptionsItemSelected(item);
	}


	@Override
	protected void onDestroy() {
		super.onDestroy();
	}

}
