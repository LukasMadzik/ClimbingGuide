package com.example.climbingguide;

import org.cimbingguide.gui.CreateArea;
import org.cimbingguide.gui.CreateRoute;
import org.cimbingguide.gui.CreateSector;
import org.cimbingguide.gui.GetFromURL;
import org.climbingguide.update.Update;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.Toast;

public class LukasLauncher extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.lukas_nieco);

		Button b1 = (Button) findViewById(R.id.button1);
		Button b2 = (Button) findViewById(R.id.button2);
		Button b3 = (Button) findViewById(R.id.button3);
		Button b4 = (Button) findViewById(R.id.button4);
		
		b1.setOnClickListener(onClickListener);
		b2.setOnClickListener(onClickListener);
		b3.setOnClickListener(onClickListener);
		b4.setOnClickListener(onClickListener);
		
	}
	
	private OnClickListener onClickListener = new OnClickListener() {
	     @Override
	     public void onClick(final View v) {
	         switch(v.getId()){
	             case R.id.button1:
	            	 
	            	 Intent intent1 = new Intent(LukasLauncher.this, CreateRoute.class);
	            	 startActivity(intent1);
	            	 
	             break;
	             case R.id.button2:
	            	 Intent intent2 = new Intent(LukasLauncher.this,CreateSector.class);
	            	 startActivity(intent2);
	             break;
	             case R.id.button3:
	            	 Intent intent3 = new Intent(LukasLauncher.this,CreateArea.class);
	            	 startActivity(intent3);
	             break;
	             case R.id.button4:
	            	 Intent intent4 = new Intent(LukasLauncher.this,GetFromURL.class);
	            	 startActivity(intent4);
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
		Update update = new Update();
		  switch (item.getItemId()) {
	        case R.id.update:
	        		
	    
		        	return true;
	        	
	        default:
	        return super.onOptionsItemSelected(item);
	        }
			
	}
}
