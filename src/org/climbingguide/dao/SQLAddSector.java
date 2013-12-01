package org.climbingguide.dao;

import java.util.ArrayList;
import java.util.List;

import org.climbingguide.model.Sector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SQLAddSector {
	
	private static String LOG = SQLAddSector.class.getName();
	
	private SQLiteDatabase db;
	private SQLHelperSector dbHelperSector;
	
	public SQLAddSector(Context context)
	{
		dbHelperSector = new SQLHelperSector(context);
	}
	
	public void open() 
	{
		db = dbHelperSector.getWritableDatabase();
	}
	
	public void close()
	{
		dbHelperSector.close();
	}
	
	public void addSector(Sector sector)
	{
		
		ContentValues value = new ContentValues();

		value.put(SQLHelperSector.SECTOR_NAME,sector.getName());
		value.put(SQLHelperSector.ID_OF_AREA,sector.getIdOfArea());
		
		Log.i(LOG,"Inster to table area -->" + value);
		
		db.insert(SQLHelperSector.TABLE_SECTOR, null, value);
	    db.close(); 
	}
	

}
