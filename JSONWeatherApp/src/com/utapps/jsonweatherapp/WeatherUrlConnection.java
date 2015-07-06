package com.utapps.jsonweatherapp;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;

import javax.net.ssl.HttpsURLConnection;

import android.util.Log;

public class WeatherUrlConnection {
	private static final String TAG = "WeatherFragment";
	
	public String setUrlConnection() throws MalformedURLException, IOException{
		Log.d(TAG, TAG);
		URL url = new URL(WeatherFragment.mUrl);
		HttpsURLConnection urlConnection = (HttpsURLConnection) url.openConnection();
		try{
			
			InputStream inputStream = new BufferedInputStream(urlConnection.getInputStream());
			String stream = readStream(inputStream);
			Log.d(TAG, stream);
			return stream;
		}finally{
			urlConnection.disconnect();
		}
		
	}
	
	private String readStream(InputStream inputStream) throws IOException{
		Log.d(TAG, TAG);
		StringBuilder stringBuilder = new StringBuilder();
		BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
		for(String line = bufferedReader.readLine(); line != null; line=bufferedReader.readLine()){
			stringBuilder.append(line);
		}
		inputStream.close();
		return stringBuilder.toString();
	}
	
	
	
}
