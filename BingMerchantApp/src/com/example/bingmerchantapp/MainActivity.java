package com.example.bingmerchantapp;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ProgressBar;

public class MainActivity extends ActionBarActivity {

	public static Context context;
	public static String CurrentUserId;
	public static String CurrentUserEnv;
	public static String Keyword = "";

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		MainActivity.context = getApplicationContext();
//		ProgressBar appStartProgressBar = (ProgressBar) findViewById(R.id.appStartProgressBar);
//		appStartProgressBar.setIndeterminate(true);
//		
//		try {
//			Thread.sleep(1000);
//		} catch (InterruptedException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
		
		AppUtils.CheckLocalSavedUserId();
		CurrentUserId = "987654321";
		CurrentUserEnv="Merchant";
		Intent intent = null;
		if (AppUtils.StringIsNullOrEmpty(CurrentUserId) == false) {
			if (CurrentUserEnv.equals(AppConstants.DefaultAppEnv)) {
				intent = new Intent(this, SearchActivity.class);
			} else {
				intent = new Intent(this, MerchantRequestListActivity.class);
			}
		} else {
			intent = new Intent(this, MerchantSignup.class);
		}
		startActivity(intent);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		if (id == R.id.action_notif) {
			startActivity(new Intent(this, ConsumerRequestListActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
