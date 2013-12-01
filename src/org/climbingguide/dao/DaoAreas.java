package org.climbingguide.dao;

import java.util.ArrayList;
import java.util.List;

import org.climbingguide.model.Area;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DaoAreas extends SQLiteOpenHelper implements InterfaceArea, InterfaceGlobal{

	public DaoAreas(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_AREAS);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXIST "+TABLE_AREAS);
		onCreate(db);
	}
	
	public List<String> gettAllAreas()
	{	
		List<String> areas = new ArrayList<String>();
		String selectQuery = " SELECT * FROM " + TABLE_AREAS;
		Log.e(LOG,selectQuery);
		
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery,null);
		
		if (c.moveToFirst())
		{
			do{
				String str;
				str=c.getString(c.getColumnIndex(AREA_NAME));
				areas.add(str);
			}while(c.moveToNext());
		}
		
		return areas;
	}

	public void addArea(Area area)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues value = new ContentValues();

		value.put(AREA_NAME,area.getName());
		
		db.insert(TABLE_AREAS, null, value);
	    db.close(); 
	}

	
}
