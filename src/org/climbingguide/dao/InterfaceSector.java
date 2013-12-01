package org.climbingguide.dao;

public interface InterfaceSector {

	public static final String TABLE_SECTORS = "sectors";
	public static final String ID_SECTOR = "id_sector";
	public static final String SECTOR_NAME = "sector_name";
	public static final String ID_OF_AREA = "id_of_area";
	public static final String SECTOR_DATE = "sector_date";
	
	public static final String CREATE_TABLE_SECTORS = "CREATE TABLE " + TABLE_SECTORS 
			+ " ( " + ID_SECTOR + " INTEGER PRIMARY KEY AUTOINCREMENT , " 
			+ SECTOR_NAME + " TEXT , " + ID_OF_AREA + " INTEGER " + " ) ;";
	
}
