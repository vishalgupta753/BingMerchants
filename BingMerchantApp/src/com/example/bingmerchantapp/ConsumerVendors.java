package com.example.bingmerchantapp;

import java.util.ArrayList;

import com.example.bingmerchantapp.data.Merchant;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;

public class ConsumerVendors extends ActionBarActivity {
	
	private ArrayList<Merchant> merchantData;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_consumer_vendors);
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.consumer_vendors, menu);
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
	
	public void GetQueryRelativeMerchants()
	{
		EditText query = (EditText)findViewById(R.id.serviceQuery);
		String searchQuery = query.getText().toString();
		
		if(AppUtils.StringIsNullOrEmpty(searchQuery)==false)
		{
			EnableButtons();
			merchantData = AppUtils.GetQueryRelativeMerchants(searchQuery);
			for (Merchant merchant : merchantData) {
				if(merchant.getIsFavouriteMerchant())
				{
					
				}
			}
		}
	}
	
	public void GetAllMerchants()
	{
		//for(Merchant merchant : merchantData)
		//{
			
		//}
	}
	
	public void GetFavouriteMerchants()
	{
		for(Merchant merchant : merchantData)
		{
			if(merchant.getIsFavouriteMerchant())
			{
				
			}
		}
	}
	
	private void EnableButtons()
	{
		findViewById(R.id.favouriteMerchantButton).setVisibility(1);
		findViewById(R.id.allMerchantButton).setVisibility(1);
		findViewById(R.id.favouriteMerchantButton).setEnabled(true);
		findViewById(R.id.allMerchantButton).setEnabled(true);
	}
}
