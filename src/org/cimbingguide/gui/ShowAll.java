package org.cimbingguide.gui;

import java.util.ArrayList;
import java.util.List;

import org.climbingguide.dao.DaoAreas;
import org.climbingguide.dao.DaoRoute;
import org.climbingguide.dao.DaoSectors;
import org.climbingguide.update.Update;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.climbingguide.R;

public class ShowAll extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		
		setContentView(R.layout.start);
		
		DaoAreas  daoa = new DaoAreas(this);
		DaoSectors daos = new DaoSectors(this);
		DaoRoute daor = new DaoRoute(this);
		
		ListView list = (ListView) findViewById(R.id.listView1);
		List<String> str = new ArrayList<String>();
		
		str.addAll(daoa.gettAllAreas());
		str.addAll(daos.gettAllSectors());
		
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
				update.updateA(this);
				update.updateS(this);
		        	return true;
	        	
	        default:
	        return super.onOptionsItemSelected(item);
	        }
			
	}

}

