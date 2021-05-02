package com.sas.delhibusnavigator;

import android.os.Bundle; 
import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

public class TutorialActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_tutorial);
		Intent t = getIntent();
		int val = t.getIntExtra("val", 0);
		int vals = val + 1;
		ContentValues values = new ContentValues();
		values.put(SplashActivity.Column_val, vals);
		String where = SplashActivity.Column_val + "=" + val;
		SplashActivity.check.update(SplashActivity.table, values, where, null);
		Button btn = (Button) findViewById(R.id.button1);
		btn.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				finish();
			}
		});
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.tutorial, menu);
		return true;
	}

}