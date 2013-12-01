package org.climbingguide.dao;

import java.util.ArrayList;
import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class GetAllSectors {
	
	private static final String LOG = GetAllSectors.class.getName();
	
	private SQLiteDatabase db;
	private SQLHelperSector dbHelperSector;
	
	public GetAllSectors(Context context){
		dbHelperSector = new SQLHelperSector(context);
	}
	
	public void open(){
		db = dbHelperSector.getWritableDatabase();
	}
	
	public void close(){
		dbHelperSector.close();
	}
	
	public List<String> getAllSectors()
	{	
		List<String> sector = new ArrayList<String>();
		String selectQuery = " SELECT * FROM " + SQLHelperSector.TABLE_SECTOR;
		Log.i(LOG,selectQuery);
		
		Cursor c = db.rawQuery(selectQuery,null);
		
		if (c.moveToFirst())
		{
			do{
				String str;
				str=c.getString(c.getColumnIndex(SQLHelperSector.SECTOR_NAME));
				sector.add(str);
			}while(c.moveToNext());
		}
		c.close();
		return sector;
	}

}
