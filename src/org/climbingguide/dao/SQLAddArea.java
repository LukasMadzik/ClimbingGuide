package org.climbingguide.dao;


import java.util.ArrayList;
import java.util.List;

import org.climbingguide.model.Area;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

public class SQLAddArea {

	private static final String LOG = SQLAddArea.class.getName();

    private SQLiteDatabase db;
    private SQLHelperArea dbHelperArea;

	public SQLAddArea(Context context){
        dbHelperArea = new SQLHelperArea(context);
	}

    public void open(){
        db = dbHelperArea.getWritableDatabase();
    }

    public void close(){
        dbHelperArea.close();
    }

    public void addArea(Area area){
		ContentValues value = new ContentValues();

		value.put(SQLHelperArea.AREA_NAME,area.getName());
		
		Log.i(LOG,"Inster to table area -->" + value);
		
		db.insert(SQLHelperArea.TABLE_AREAS, null, value);
	    db.close();
	}


	
}
