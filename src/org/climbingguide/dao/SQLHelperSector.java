package org.climbingguide.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLHelperSector extends SQLiteOpenHelper {
	
	private static final String LOG = SQLHelperSector.class.getName();
	
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "climbingGuide.db";
	
	public static final String TABLE_SECTOR = "sectors";
	public static final String ID_SECTOR = "id_sector";
	public static final String SECTOR_NAME = "sector_name";
	public static final String ID_OF_AREA = "id_of_area";
	public static final String SECTOR_DATE = "sector_date";
	
	public static final String CREATE_TABLE_SECTOR = "CREATE TABLE " + TABLE_SECTOR 
			+ " ( " + ID_SECTOR + " INTEGER PRIMARY KEY AUTOINCREMENT , " 
			+ SECTOR_NAME + " TEXT , " + ID_OF_AREA + " INTEGER " + " ) ;";
	
	public static final String DROP_TABLE_SECTOR = "DROP TABLE IF EXIST" + TABLE_SECTOR;
	
	  public SQLHelperSector(Context context){
	        super(context, DATABASE_NAME, null, DATABASE_VERSION);
	    }

	    @Override
	    public void onCreate(SQLiteDatabase db){
	        Log.i(LOG, "Create sector database -> " + CREATE_TABLE_SECTOR);
	        db.execSQL(CREATE_TABLE_SECTOR);
	    }

	    @Override
	    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
	        db.execSQL(DROP_TABLE_SECTOR);
	        onCreate(db);
	    }

}
