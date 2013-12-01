package com.example.climbingguide;

import java.util.ArrayList;
import java.util.List;

import org.cimbingguide.gui.ShowAreas;
import org.climbingguide.dao.GetAllAreas;
import org.climbingguide.dao.GetAllRoutes;
import org.climbingguide.dao.GetAllSectors;
import org.climbingguide.dao.SQLAddArea;
import org.climbingguide.dao.SQLAddRoute;
import org.climbingguide.dao.SQLAddSector;
import org.climbingguide.update.Update;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MarekLauncher extends Activity{

	private GetAllAreas  getAreas;
	private GetAllSectors  getSectors;
	private GetAllRoutes  getRoutes;
	


	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.start);
		try{
	
			showAll();
			
		}catch(Exception e)
		{
			Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
			Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
			Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
			Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
			Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
			Toast.makeText(getApplicationContext(), e.toString(), Toast.LENGTH_SHORT).show();
		}
		
	}
	public void showAll()
	{

		
			getAreas = new GetAllAreas(getApplicationContext());
        	getAreas.open();

        	getSectors = new GetAllSectors(getApplicationContext());
        	getSectors.open();
        	
        	getRoutes = new GetAllRoutes(getApplicationContext());
        	getRoutes.open();
         

		
		ListView list = (ListView) findViewById(R.id.listView1);
		List<String> str = new ArrayList<String>();

		 str.addAll(getAreas.getAllAreas());
		 str.addAll(getSectors.getAllSectors()); 
		 str.addAll(getRoutes.getAllRoutes());
		
		 
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,str);
	
		list.setAdapter(adapter);
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
		return true;
	}

	
	public boolean onOptionsItemSelected(MenuItem item)
	{
		
		  switch (item.getItemId()) {
	        case R.id.update:
				Update update = new Update();
				update.updateA(getApplicationContext());
				update.updateS(getApplicationContext());
				update.updateR(getApplicationContext());
	    
		        	return true;
	        	
	        default:
	        return super.onOptionsItemSelected(item);
	        }
			
	}
	
}
