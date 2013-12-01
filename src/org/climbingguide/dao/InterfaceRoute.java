package org.climbingguide.dao;

public interface InterfaceRoute {
	
	public static final String TABLE_ROUTES = "routes";
	public static final String ID_ROUTE = "id_route";
	public static final String ROUTE_NAME = "route_name";
	public static final String ID_OF_SECTOR = "id_sector";
	public static final String DIFFICULTY = "difficulty";
	public static final String BOLTS = "bolts";
	public static final String LENGTH = "length";
	public static final String ROUTE_DATE = "route_date";

	
	public static final String CREATE_TABLE_ROUTES = "CREATE TABLE " + TABLE_ROUTES + " ( " 
			+ ID_ROUTE + " INTEGER PRIMARY KEY AUTOINCREMENT , " + ROUTE_NAME 
			+ " TEXT , " + ID_OF_SECTOR + " INTEGER , " + DIFFICULTY + " TEXT , " 
			+ BOLTS + " INTEGER , " + LENGTH + " INTEGER " + " ) ;"; 

}
