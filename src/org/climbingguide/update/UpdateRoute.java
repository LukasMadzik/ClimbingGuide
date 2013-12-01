package org.climbingguide.update;

import org.climbingguide.dao.SQLAddRoute;
import org.climbingguide.model.Route;

import android.content.Context;

public class UpdateRoute {

	public void updateSector(int id, String name,int id_of_sector,String dificulty,int bolts,int length,Context context)
	{
		Route route = new Route ();

		route.setId(id);
		route.setName(name);
		route.setIdOfSector(id_of_sector);
		route.setDificulty(dificulty);
		route.setLength(length);
		route.setBolts(bolts);
		
		SQLAddRoute daor = new SQLAddRoute(context);
		daor.open();
		daor.addRoute(route);
		
	}
	
}
