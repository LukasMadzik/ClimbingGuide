package org.cimbingguide.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.Date;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.JSONObject;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

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
	 		EditText e2   = (EditText)findViewById(R.id.editText2);
	 		//id_of_sector, vyriesi sa potom
			EditText e3   = (EditText)findViewById(R.id.editText3);
			EditText e4   = (EditText)findViewById(R.id.editText4);
			EditText e5   = (EditText)findViewById(R.id.editText5);
			TextView v1 = (TextView)findViewById(R.id.textView1);
			TextView v2 = (TextView)findViewById(R.id.textView2);
			TextView v3 = (TextView)findViewById(R.id.textView3);
			TextView v4 = (TextView)findViewById(R.id.textView4);
			TextView v5 = (TextView)findViewById(R.id.textView5);
			TextView v6 = (TextView)findViewById(R.id.textView6);
			
	 		JSONObject json = new JSONObject();
	 		Calendar c = Calendar.getInstance();
	 	    int mYear = c.get(Calendar.YEAR);
	 	    int mMonth = c.get(Calendar.MONTH);
	 	    int mDay = c.get(Calendar.DAY_OF_MONTH);
	 	    String date = (new StringBuilder()
	 	    .append(mYear)
	 	    .append(mMonth + 1)
	 	    .append(mDay)).toString();
	 	    
	    	try {
				json.put("route_name", e1.getText().toString());
				json.put("sector", e2.getText().toString());
				json.put("difficulty", e3.getText().toString());
				json.put("bolts", e4.getText().toString());
				json.put("length", e5.getText().toString());
				json.put("date", date);
			} catch (JSONException e) {
				e.printStackTrace();
			}

	    	
	    	try {
				v1.setText((CharSequence) json.get("route_name"));
				v3.setText((CharSequence) json.get("difficulty"));
				v4.setText((CharSequence) json.get("bolts"));
				v5.setText((CharSequence) json.get("length"));
			} catch (JSONException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    	
	    	v6.setText(date);
	    	
	   }
	};
	
	
	
}
