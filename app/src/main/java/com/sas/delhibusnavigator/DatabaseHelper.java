package com.sas.delhibusnavigator;

import android.annotation.SuppressLint;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteException;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.util.LinkedList;

@SuppressLint("SdCardPath")
public class DatabaseHelper extends SQLiteOpenHelper {

	private SQLiteDatabase myDatabase;
	private final Context myContext;
	private static final String DATABASE_NAME = "bus.mp3";
	public final static String DATABASE_PATH = "/data/data/com.sas.delhibusnavigator/databases/";
	public static final int DATABASE_VERSION = 1;
	
	Cursor c;
	int countcheck;
	int countd;
	int countf;
	int counts;
	String[] destList = null;
	String destbus = null;
	String[] list;
	String[] list1;
	String[] listf;
	String[] sourceList = null;
	int tempk;

	public DatabaseHelper(Context context) {
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
		this.myContext = context;
	}
	
	public void createDatabase() throws IOException {
		boolean dbExist = checkDatabase();
		
		if(dbExist) {
			Log.v("DB Exists", "db exists");
		}
		
		boolean dbExist1 = checkDatabase();
		
		if(!dbExist1) {
			this.getReadableDatabase();
			try {
				this.close();
				copyDatabase();
			} catch (IOException e) {
				throw new Error("Error copying Database");
			}
		}
	}
	
	private boolean checkDatabase() {
		boolean checkDB = false;
		
		try {
			String myPath = DATABASE_PATH + DATABASE_NAME;
			File dbFile = new File(myPath);
			checkDB = dbFile.exists();
		} catch (SQLiteException e) {
		}
		
		return checkDB;
	}
	
	private void copyDatabase() throws IOException {
		String outFileName = DATABASE_PATH + DATABASE_NAME;
		
		OutputStream myOutput = new FileOutputStream(outFileName);
		InputStream myInput = myContext.getAssets().open(DATABASE_NAME);
		
		byte[] buffer = new byte[1024];
		int length;
		
		while ((length = myInput.read(buffer)) > 0) {
			myOutput.write(buffer, 0, length);
		}
		
		myInput.close();
		myOutput.flush();
		myOutput.close();
	}
	
	public void db_delete() {
		File file = new File(DATABASE_PATH + DATABASE_NAME);
		if (file.exists()) {
			file.delete();
			System.out.println("Delete Database File");
		}
	}
	
	public void openDatabase() throws SQLException {
		String myPath = DATABASE_PATH + DATABASE_NAME;
		myDatabase = SQLiteDatabase.openDatabase(myPath, null, SQLiteDatabase.OPEN_READWRITE);
	}
	
	public synchronized void closeDatabase() throws SQLException {
		if (myDatabase != null)
			myDatabase.close();
		super.close();
	}
	
	public Cursor getAllBusNumber() {
		String query = "SELECT * FROM BusRoute ORDER BY BusNumber";
		Cursor c = myDatabase.rawQuery(query, null);
		return c;
	}
	
	public Cursor searchBusNumber(String s) {
		String query = "SELECT * FROM BusRoute WHERE BusNumber LIKE '%" + s + "%' ORDER BY BusNumber";
		Cursor c = myDatabase.rawQuery(query, null);
		return c;
	}

	public LinkedList<String> getAutoFill() {
		String query = "SELECT DISTINCT Stop FROM BusStop";
		LinkedList<String> ll = new LinkedList<String>();
		Cursor c = myDatabase.rawQuery(query, null);
		c.moveToFirst();
		for(int i = 0; i <= c.getCount() - 1; i++) {
			ll.add(c.getString(0));
			c.moveToNext();
		}
		c.close();
		return ll;
	}
	
	public Cursor getSD(String bno) {
		String query = "SELECT * FROM BusRoute WHERE BusNumber='" + bno + "'";
		Cursor c = myDatabase.rawQuery(query, null);
		return c;
	}
	
	public LinkedList<String> getStops(String bno) {
		String query = "SELECT * FROM BusStop WHERE BusNumber='" + bno + "'";
		LinkedList<String> item = new LinkedList<String>();
		Cursor c = myDatabase.rawQuery(query, null);
		c.moveToFirst();
		for(int i = 0; i <= c.getCount() - 1; i++) {
			item.add(c.getString(1));
			c.moveToNext();
		}
		c.close();
		return item;
	}
	
	public LinkedList<String> getAutoStop() {
		String query = "SELECT DISTINCT Stop FROM BusStop";
		LinkedList<String> ll = new LinkedList<String>();
		Cursor c = myDatabase.rawQuery(query, null);
		c.moveToFirst();
		for(int i = 0; i <= c.getCount() - 1; i++) {
			ll.add(c.getString(0));
			c.moveToNext();
		}
		c.close();
		return ll;
	}
	
	public LinkedList<String> searchStop(String stop) {
		String query = "SELECT BusNumber FROM BusStop WHERE Stop='" + stop + "'";
		LinkedList<String> ll = new LinkedList<String>();
		Cursor c = myDatabase.rawQuery(query, null);
		c.moveToFirst();
		for(int i = 0; i <= c.getCount() - 1; i++) {
			ll.add(c.getString(0));
			c.moveToNext();
		}
		c.close();
		return ll;
	}

	public boolean getDirectRoute(String start, String end) {
		String query = "SELECT DISTINCT BusNumber FROM BusStop WHERE BusNumber IN (SELECT BusNumber FROM BusStop WHERE Stop='" + start + "' INTERSECT SELECT BusNumber FROM BusStop WHERE Stop ='" + end + "') ";
		Cursor c = myDatabase.rawQuery(query, null);
		int i = c.getCount();
		while(true) {
			if (!c.moveToNext()) {
				if (i != 0)
					break;
				return false;
			}
			String str = c.getString(c.getColumnIndex("BusNumber")) + " :  " + start + " to " + end;
			ViewRouteActivity.ll.add(str);
		}
		return true;
	}

	
	@Override
	public void onCreate(SQLiteDatabase db) {
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		if (newVersion > oldVersion) {
			Log.v("Database Uppgrade", "Database version higher than old.");
			db_delete();
		}
	}
}
