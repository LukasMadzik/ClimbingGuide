package org.climbingguide.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.climbingguide.model.Route;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;


public class SQLAddRoute {
	
	private static String LOG = SQLAddRoute.class.getName();
	
	private SQLiteDatabase db;
	private SQLHelperRoute dbHelperRoute;
	
	
	public SQLAddRoute(Context context)
	{
		dbHelperRoute = new SQLHelperRoute(context);
	}
	public void open() 
	{
		db = dbHelperRoute.getWritableDatabase();
	}
	public void close()
	{
		dbHelperRoute.close();
	}

	public void addRoute(Route route)
	{
		
		ContentValues value = new ContentValues();
	
		value.put(SQLHelperRoute.ROUTE_NAME,route.getName());
		value.put(SQLHelperRoute.ID_OF_SECTOR,route.getIdOfSector());
		value.put(SQLHelperRoute.DIFFICULTY,route.getDificulty());
		value.put(SQLHelperRoute.LENGTH,route.getLength());
		
		Log.i(LOG,"Inster to table route -->" + value);
		
		db.insert(SQLHelperRoute.TABLE_ROUTE, null, value);
	    db.close(); 
	}
}
