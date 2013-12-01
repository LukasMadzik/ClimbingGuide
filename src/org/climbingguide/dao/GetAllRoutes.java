package org.climbingguide.dao;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class GetAllRoutes {
	

	private static String LOG = SQLAddArea.class.getName();
	
	private SQLiteDatabase db;
	private SQLHelperRoute dbHelperRoute;
	
	public GetAllRoutes(Context context)
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

	
	public List<String> getAllRoutes()
	{	
		List<String> route = new ArrayList<String>();
		String selectQuery = " SELECT * FROM " + SQLHelperRoute.TABLE_ROUTE;
		Log.i(LOG,selectQuery);
		
		Cursor c = db.rawQuery(selectQuery,null);
		
		if (c.moveToFirst())
		{
			do{
				String str;
				str=c.getString(c.getColumnIndex(SQLHelperRoute.ROUTE_NAME));
			
				
				route.add(str);
			}while(c.moveToNext());
		}
		c.close();
		return route; 
	}
	
	

}
