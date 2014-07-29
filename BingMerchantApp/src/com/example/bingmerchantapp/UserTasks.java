package com.example.bingmerchantapp;

import com.example.bingmerchantapp.AppConstants.ConsumerStatus;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

public class UserTasks extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_user_tasks);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.user_tasks, menu);
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
	
	public void gotToMerchantRevertScreeen(View view) {
		
		//TODO Rest call to fetch the merchant reverts for this customer.
		
		Intent intent = null;
		intent = new Intent(this, MerchantReverts.class);
		startActivity(intent);
	}
	
	public void gotToNewServiceSearch(View view) {

		Intent intent = null;
		intent = new Intent(this, NewServiceSearch.class);
		startActivity(intent);
	}
	
	public void gotToRecentServiceReview(View view) {
		
		//TODO Rest call to fetch recent services
		Intent intent = null;
		intent = new Intent(this, RecentServiceReviews.class);
		startActivity(intent);
	}
	
	public void gotToAddVendor(View view) {
		
		Intent intent = null;
		intent = new Intent(this, ConsumerAddVendor.class);
		startActivity(intent);
	}

	public void gotToMyProfile(View view) {
		
		Intent intent = null;
		intent = new Intent(this, ConsumerProfile.class);
		startActivity(intent);
	}
	
	
}

