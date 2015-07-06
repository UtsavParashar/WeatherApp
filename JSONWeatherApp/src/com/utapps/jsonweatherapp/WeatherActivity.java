package com.utapps.jsonweatherapp;

import android.support.v4.app.Fragment;


public class WeatherActivity extends SingleFragmentActivity {

    @Override
    protected Fragment createFragment() {
    	// TODO Auto-generated method stub
    	return new WeatherFragment();
    }
}
