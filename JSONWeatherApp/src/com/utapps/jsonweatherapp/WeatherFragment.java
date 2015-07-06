package com.utapps.jsonweatherapp;

import java.io.IOException;
import java.net.MalformedURLException;

import android.app.ProgressDialog;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

public class WeatherFragment extends Fragment {
	
	private static final String TAG = "WeatherFragment";

	ProgressDialog mProgressDialog;

	private Button mLocationButton;
	private EditText mLocationEditText;
	private Button mWeatherButton;
	private EditText mCountryEditText;

	WeatherModel mWeatherModel = new WeatherModel();
	WeatherUrlConnection mWeatherUrlConnection;

	private final static String mUrlApi = "http://api.openweathermap.org/data/2.5/weather?q=";
	static String mUrlLocation;
	static String mUrl = mUrlApi + mUrlLocation;

	String mUrlData;
	

	@Override
	public View onCreateView(LayoutInflater inflater,
			@Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
		// TODO Auto-generated method stub
		View v = inflater.inflate(R.layout.fragment_weather, container, false);

		mLocationButton = (Button) v.findViewById(R.id.location_button);
		mLocationButton.setEnabled(false);

		mLocationEditText = (EditText) v.findViewById(R.id.location_editText);
		

		mWeatherButton = (Button) v.findViewById(R.id.weather_button);
		mWeatherButton.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				mUrlLocation = mLocationEditText.getText().toString();
				mWeatherModel.setLocation(mUrlLocation);
				
				new GetData().execute();
			}
		});

		return v;
	}

	private class GetData extends AsyncTask<Void, Void, Void> {

//		@Override
//		protected void onPreExecute() {
//			// TODO Auto-generated method stub
//			super.onPreExecute();
//			mProgressDialog = new ProgressDialog(getActivity());
//			mProgressDialog.setMessage("Please wait");
//			mProgressDialog.setCancelable(false);
//			mProgressDialog.show();
//
//		}

		@Override
		protected Void doInBackground(Void... params) {
			// TODO Auto-generated method stub
			try {
				Log.d(TAG, mUrl);
				mUrlData = mWeatherUrlConnection.setUrlConnection();
				Log.d(TAG, mUrlData);
			} catch (MalformedURLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			return null;
		}

		@Override
		protected void onPostExecute(Void result) {
			// TODO Auto-generated method stub
			super.onPostExecute(result);
			
			mCountryEditText.setText(mUrlData);
		}

	}
}
