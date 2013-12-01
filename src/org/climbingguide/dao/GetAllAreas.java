package org.climbingguide.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class GetAllAreas {
	
	private static final String LOG = GetAllAreas.class.getName();
	
	private SQLiteDatabase db;
	private SQLHelperArea dbHelperArea;
	
	public GetAllAreas(Context context){
		dbHelperArea = new SQLHelperArea(context);
	}
	
	public void open(){
		db = dbHelperArea.getWritableDatabase();
	}
	
	public void close(){
		dbHelperArea.close();
	}

	public List<String> getAllAreas()
	{	
		List<String> areas = new ArrayList<String>();
		String selectQuery = " SELECT * FROM " + SQLHelperArea.TABLE_AREAS;
		Log.i(LOG, selectQuery);
		
		Cursor c = db.rawQuery(selectQuery,null);
		
		if (c.moveToFirst())
		{
			do{
				String str;
				str=c.getString(c.getColumnIndex(SQLHelperArea.AREA_NAME));
				areas.add(str);
			}while(c.moveToNext());
		}
		c.close();
		return areas;
	}
}
