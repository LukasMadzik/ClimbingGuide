package org.climbingguide.dao;

import java.util.ArrayList;
import java.util.List;

import org.climbingguide.model.Sector;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class DaoSectors extends SQLiteOpenHelper implements InterfaceSector, InterfaceGlobal  {
	
	public DaoSectors(Context context)
	{
		super(context, DATABASE_NAME, null, DATABASE_VERSION);
	}
	
	@Override
	public void onCreate(SQLiteDatabase db) {
		db.execSQL(CREATE_TABLE_SECTORS);
	}

	@Override
	public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
		db.execSQL("DROP TABLE IF EXIST "+TABLE_SECTORS);
		onCreate(db);
	}
	
	public List<String> gettAllSectors()
	{	
		List<String> sector = new ArrayList<String>();
		String selectQuery = " SELECT * FROM " + TABLE_SECTORS;
		Log.e(LOG,selectQuery);
		
		SQLiteDatabase db = this.getReadableDatabase();
		Cursor c = db.rawQuery(selectQuery,null);
		
		if (c.moveToFirst())
		{
			do{
				String str;
				str=c.getString(c.getColumnIndex(SECTOR_NAME));
				sector.add(str);
			}while(c.moveToNext());
		}
		
		return sector;
	}

	public void addSector(Sector sector)
	{
		SQLiteDatabase db = this.getWritableDatabase();
		
		ContentValues value = new ContentValues();

		value.put(SECTOR_NAME,sector.getName());
		value.put(ID_OF_AREA,sector.getIdOfArea());
		
		db.insert(TABLE_SECTORS, null, value);
	    db.close(); 
	}
	

}
