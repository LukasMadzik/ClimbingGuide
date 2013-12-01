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
import android.widget.Toast;

public class DatabaseHandler extends SQLiteOpenHelper implements InterfaceArea, InterfaceSector, InterfaceRoute, InterfaceGlobal{

		
		 public DatabaseHandler(Context context) {
		        super(context, DATABASE_NAME, null, DATABASE_VERSION);
		    }
		
		@Override
		public void onCreate(SQLiteDatabase db) {
			
			db.execSQL(CREATE_TABLE_AREAS);
			db.execSQL(CREATE_TABLE_SECTORS);
			db.execSQL(CREATE_TABLE_ROUTES);
		}
		
		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// TODO Auto-generated method stub
			db.execSQL("DROP TABLE IF EXIST "+TABLE_AREAS);
			db.execSQL("DROP TABLE IF EXIST "+TABLE_SECTORS);
			db.execSQL("DROP TABLE IF EXIST "+TABLE_ROUTES);
			
			onCreate(db);
			
		}
		

		
				
				
}
