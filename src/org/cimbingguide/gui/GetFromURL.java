package org.cimbingguide.gui;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Map;

import org.apache.http.HttpEntity;
import org.apache.http.HttpResponse;
import org.apache.http.StatusLine;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.DefaultHttpClient;
import org.json.JSONException;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.os.Bundle;
import android.os.StrictMode;
import android.util.Log;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.example.climbingguide.R;

public class GetFromURL extends Activity{
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		    StrictMode.ThreadPolicy policy = new StrictMode.
		    ThreadPolicy.Builder().permitAll().build();
		    StrictMode.setThreadPolicy(policy); 
		    setContentView(R.layout.get_from_url);
		    String read = read();
		    Button b1 = (Button) findViewById(R.id.button1);
			
			b1.setOnClickListener(onClickListener);

		  }

		  public String read() {
			StringBuilder builder = new StringBuilder();
			HttpClient client = new DefaultHttpClient();
			HttpGet httpGet = new HttpGet("http://climbingguide.madzik.sk/routes.php");
			try {
				HttpResponse response = client.execute(httpGet);
				StatusLine statusLine = response.getStatusLine();
				int statusCode = statusLine.getStatusCode();
				if (statusCode == 200) {
					HttpEntity entity = response.getEntity();
					InputStream content = entity.getContent();
					BufferedReader reader = new BufferedReader(new InputStreamReader(content));
					String line;
					while ((line = reader.readLine()) != null) {
						builder.append(line);
					}
				} 
				else {
					Log.e(GetFromURL.class.toString(), "Failed to download file");
				}
			} 
			catch (ClientProtocolException e) {
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
			return builder.toString();
		  }
		  
		  private OnClickListener onClickListener = new OnClickListener() {
			     @Override
			     public void onClick(final View v) {
					 TextView v1 = (TextView)findViewById(R.id.textView1);
				 	
					 v1.setText(read());
					
					 
			     }
			};
		  
		  
}
