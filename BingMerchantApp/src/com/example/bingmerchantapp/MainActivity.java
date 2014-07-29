package com.example.bingmerchantapp;

import com.example.bingmerchantapp.AppConstants.ConsumerStatus;
import com.example.bingmerchantapp.AppConstants.MerchantStatus;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class MainActivity extends ActionBarActivity {

	public static Context context;
	public static ConsumerStatus CurrentUserConsumerStatus;
	public static MerchantStatus CurrentUserMerchantStatus;
	public static String CurrentMerchantUserId;
	public static String CurrentConsumerUserId;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		MainActivity.context = getApplicationContext();
		setContentView(R.layout.activity_main);
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
		return super.onOptionsItemSelected(item);
	}

	public void gotoMerchantScreen(View view) {
//		//AppUtils.SaveLocalUserId("");
//		Intent intent = null;
//		if (AppUtils.StringIsNullOrEmpty(CurrentMerchantUserId) == false) {
//			intent = new Intent(this, MerchantRequests.class);
//		} else {
//			AppUtils.SetCuurentUserMerchantStatus();
//			if (CurrentUserMerchantStatus == MerchantStatus.NewMarchant) {
//				intent = new Intent(this, MerchantSignup.class);
//			} else {
//				intent = new Intent(this, MerchantRequests.class);
//			}
//		}
//		startActivity(intent);
	}
	
	public void gotoConsumerScreen(View view) {
		//AppUtils.SaveLocalUserId("");
		Intent intent = null;
		if (AppUtils.StringIsNullOrEmpty(CurrentConsumerUserId) == false) {
			intent = new Intent(this, ConsumerVendors.class);
		} else {
			AppUtils.SetCuurentUserConsumerStatus();
			if (CurrentUserConsumerStatus == ConsumerStatus.NewConsumer) {
				intent = new Intent(this, MerchantSignup.class);
			} else {
				intent = new Intent(this, ConsumerVendors.class);
			}
		}
		startActivity(intent);
	}
}
