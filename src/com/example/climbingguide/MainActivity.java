package com.example.climbingguide;


import java.util.ArrayList;
import java.util.List;

import org.cimbingguide.gui.ShowAreas;
import org.climbingguide.dao.SQLAddArea;
import org.climbingguide.model.Area;
import org.climbingguide.model.Route;
import org.climbingguide.model.Sector;
import org.climbingguide.update.Update;
import org.climbingguide.update.UpdateArea;

import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		
		b1.setClickable(true);
		b2.setClickable(true);
		
		b1.setOnClickListener(onClickListener);
		b2.setOnClickListener(onClickListener);
	
		
		
		
	}
	
	private OnClickListener onClickListener = new OnClickListener() {
	     @Override
	     public void onClick(final View v) {
	         switch(v.getId()){
	             case R.id.button1:
	            	 
	            	 Intent intent = new Intent(MainActivity.this, MarekLauncher.class);
	            	 startActivity(intent);
	            	 
	             break;
	             case R.id.button2:
	            	 Intent intentt = new Intent(MainActivity.this,LukasLauncher.class);
	            	 startActivity(intentt);
	             break;
	         }

	   }
	};
	
	
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
