package org.cimbingguide.gui;

import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

import com.example.climbingguide.LukasLauncher;
import com.example.climbingguide.R;

public class CreateRoute extends Activity{
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.create_route);

		Button b1 = (Button) findViewById(R.id.button1);
		
		b1.setOnClickListener(onClickListener);
	}
	
	private OnClickListener onClickListener = new OnClickListener() {
	     @Override
	     public void onClick(final View v) {
	    	 
	 		EditText e1   = (EditText)findViewById(R.id.editText1);
	 		//EditText e2   = (EditText)findViewById(R.id.editText2);
	 		//id_of_sector, vyriesi sa potom
			EditText e3   = (EditText)findViewById(R.id.editText3);
			EditText e4   = (EditText)findViewById(R.id.editText4);
			EditText e5   = (EditText)findViewById(R.id.editText5);
			
	 		JSONObject json = new JSONObject();
	    	try {
				json.put("route_name", e1.getText().toString());
				json.put("difficulty", e3.getText().toString());
				json.put("bolts", e4.getText().toString());
				json.put("length", e5.getText().toString());
			} catch (JSONException e) {
				e.printStackTrace();
			}

	   }
	};

}
