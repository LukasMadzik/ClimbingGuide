package org.climbingguide.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLHelperArea extends SQLiteOpenHelper {

    private static final String LOG = SQLHelperArea.class.getName();

    public static final int DATABASE_VERSION = 1;
    public static final String DATABASE_NAME = "climbingGuide.db";

	public static final String TABLE_AREAS = "areas";
	public static final String ID_AREA = "id";
	public static final String AREA_NAME = "area_name";
	public static final String AREA_DATE = "area_date";
	
	private static final String CREATE_TABLE_AREAS = "CREATE TABLE " + TABLE_AREAS
			+ " ( " + ID_AREA + " INTEGER PRIMARY KEY AUTOINCREMENT , " 
			+ AREA_NAME + " TEXT " + " ) ;";
	
    private static final String DROP_TABLE_AREAS = "DROP TABLE IF EXIST " + TABLE_AREAS;

    public SQLHelperArea(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(LOG, "Create areas database -> " + CREATE_TABLE_AREAS);
        db.execSQL(CREATE_TABLE_AREAS);
        
        Log.i(LOG, "Create sector database -> " + SQLHelperSector.CREATE_TABLE_SECTOR);
        db.execSQL(SQLHelperSector.CREATE_TABLE_SECTOR);
        
        Log.i(LOG, "Create route database -> " + SQLHelperRoute.CREATE_TABLE_ROUTE);
        db.execSQL(SQLHelperRoute.CREATE_TABLE_ROUTE);
       
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_AREAS);
        onCreate(db);
    }
}
