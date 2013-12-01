package org.climbingguide.dao;

public interface InterfaceArea {
	
	public static final String TABLE_AREAS = "areas";
	public static final String ID_AREA = "id";
	public static final String AREA_NAME = "area_name";
	public static final String AREA_DATE = "area_date";
	
	public static final String CREATE_TABLE_AREAS = "CREATE TABLE " + TABLE_AREAS 
			+ " ( " + ID_AREA + " INTEGER PRIMARY KEY AUTOINCREMENT , " 
			+ AREA_NAME + " TEXT " + " ) ;";

	
}
