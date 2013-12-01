package org.climbingguide.dao;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class SQLHelperRoute extends SQLiteOpenHelper {
	
	private static final String LOG = SQLHelperRoute.class.getName();
	
	public static final int DATABASE_VERSION = 1;
	public static final String DATABASE_NAME = "climbingGuide.db";
	
	public static final String TABLE_ROUTE = "routes";
	public static final String ID_ROUTE = "id_route";
	public static final String ROUTE_NAME = "route_name";
	public static final String ID_OF_SECTOR = "id_sector";
	public static final String DIFFICULTY = "difficulty";
	public static final String BOLTS = "bolts";
	public static final String LENGTH = "length";
	public static final String ROUTE_DATE = "route_date";

	public static final String CREATE_TABLE_ROUTE = "CREATE TABLE " + TABLE_ROUTE + " ( " 
			+ ID_ROUTE + " INTEGER PRIMARY KEY AUTOINCREMENT , " + ROUTE_NAME 
			+ " TEXT , " + ID_OF_SECTOR + " INTEGER , " + DIFFICULTY + " TEXT , " 
			+ BOLTS + " INTEGER , " + LENGTH + " INTEGER " + " ) ;";
	
	private static final String DROP_TABLE_ROUTE = "DROP TABLE IF EXIST " + TABLE_ROUTE;
	

    public SQLHelperRoute(Context context)  {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.i(LOG, "Create route database -> " + CREATE_TABLE_ROUTE);
        db.execSQL(CREATE_TABLE_ROUTE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL(DROP_TABLE_ROUTE);
        onCreate(db);
    }

	
}
