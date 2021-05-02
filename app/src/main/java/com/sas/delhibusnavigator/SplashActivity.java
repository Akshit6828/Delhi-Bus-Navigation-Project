package com.sas.delhibusnavigator;

import android.app.Activity; 
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.Menu;
import android.widget.Toast;

public class SplashActivity extends Activity implements Runnable {

	public final String database = "run.db";
	public final static String table = "run";
	public final static String Column_val = "val";
	
	static SQLiteDatabase check;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_splash);
		Thread timer = new Thread(this);
		timer.start();
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.splash, menu);
		return true;
	}

	@Override
	public void run() {
		try {
			Thread.sleep(1500);
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			
			
			
		//	Intent startingPoint = new Intent("com.sas.delhibusnavigator.MAINACTIVITY");
			//startActivity(Intent.createChooser(startingPoint,"check"));
		}
		Intent startingPoint = new Intent("com.sas.delhibusnavigator.MAINACTIVITY");
		startActivity(startingPoint);
	
	}

	@Override
	protected void onPause() {
		super.onPause();
		finish();
	}

	@Override
	protected void onResume() {
		check = openOrCreateDatabase(database, SQLiteDatabase.CREATE_IF_NECESSARY|SQLiteDatabase.OPEN_READWRITE, null);
		check.execSQL("CREATE TABLE IF NOT EXISTS " + table + " (" +
				Column_val + " TEXT NOT NULL);");
		super.onResume();
	}

	@Override
	public boolean onKeyDown(int keyCode, KeyEvent event) {
		if (keyCode == KeyEvent.KEYCODE_BACK)
			return true;
		else
			return super.onKeyDown(keyCode, event);
	}

}
