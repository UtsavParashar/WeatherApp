package com.utapps.jsonweatherapp;

public class WeatherModel {
	private String mLocation;
	private String mCountry;
	private int mTemp;
	
	public String getLocation() {
		return mLocation;
	}
	public void setLocation(String location) {
		mLocation = location;
	}
	public String getCountry() {
		return mCountry;
	}
	public void setCountry(String country) {
		mCountry = country;
	}
	public int getTemp() {
		return mTemp;
	}
	public void setTemp(int temp) {
		mTemp = temp;
	}
	
	
}
