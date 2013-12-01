package org.climbingguide.dao;

import java.util.ArrayList;
import java.util.List;

import org.climbingguide.model.Route;


import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;


public class DaoRoute extends SQLiteOpenHelper implements InterfaceRoute, InterfaceGlobal  {
	
	public DaoRoute(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_ROUTES);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXIST "+TABLE_ROUTES);
		onCreate(db);
	}
	
	public List<String> gettAllRoutes()
	{	
		List<String> route = new ArrayList<String>();
		String selectQuery = " SELECT * FROM " + TABLE_ROUTES;
		Log.e(LOG,selectQuery);
		
		
		SQLiteDatabase db = this.getReadableDatabase();
		
		Cursor c = db.rawQuery(selectQuery,null);
		
		if (c.moveToFirst())
		{
			do{
				String str;
				str=c.getString(c.getColumnIndex(ROUTE_NAME));
				// + + other
				
				route.add(str);
			}while(c.moveToNext());
		}
		
		return route; // return route object
	}

	public void addRoute(Route route)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues value = new ContentValues();
	
		value.put(ROUTE_NAME,route.getName());
		value.put(ID_OF_SECTOR,route.getIdOfSector());
		value.put(DIFFICULTY,route.getDificulty());
		value.put(LENGTH,route.getLength());
		
		db.insert(TABLE_ROUTES, null, value);
	    db.close(); 
	}
}
