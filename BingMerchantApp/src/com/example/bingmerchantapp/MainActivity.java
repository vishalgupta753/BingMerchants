package com.example.bingmerchantapp;

import android.support.v7.app.ActionBarActivity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainActivity extends ActionBarActivity {
	
	public AppConstants.MerchantStatus myAppMerchantStatus; 
	public AppConstants.ConsumerStatus myConsumerStatus; 
	
	public static Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
    
    public void gotoMerchantScreen (View view)
    {
    	Intent intent;
    	if (myAppMerchantStatus == AppConstants.MerchantStatus.NewMarchant)
    	{
    		intent = new Intent(this, MerchantSignup.class);
    	}
    	else
    	{
      		intent = new Intent(this, MerchantRequests.class);
    	}
    	startActivity(intent);
    }
    
    public void gotoCustomerScreen (View view)
    {
    	Intent intent;
    	if (myConsumerStatus == AppConstants.ConsumerStatus.NewConsumer)
    	{
    		intent = new Intent(this, ConsumerSignup.class);
    	}
    	else
    	{
      		intent = new Intent(this, ConsumerVendors.class);
    	}
    	startActivity(intent);
    }
}
