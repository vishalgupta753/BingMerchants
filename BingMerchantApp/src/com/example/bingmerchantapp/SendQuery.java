package com.example.bingmerchantapp;

import com.example.bingmerchantapp.data.Merchant;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;

public class SendQuery extends Activity {

	private Merchant merchant;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_send_query);
	}

	public void SetPortalData() {
		Intent intent = getIntent();
		merchant = (Merchant) intent.getParcelableExtra("MerchantData");

		TextView name = (TextView) findViewById(R.id.queryPageMerchantName);
		name.setText(merchant.getName());

		TextView cellPhone = (TextView) findViewById(R.id.sendQueryCellPhone);
		cellPhone.setText(merchant.getPhone());
		
		TextView address = (TextView) findViewById(R.id.sendQueryMerchantAddress);
		address.setText(merchant.getAddress());
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.send_query, menu);
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

	public void SendQueryToConsumer() {
		EditText query = (EditText) findViewById(R.id.consumerQuery);
		String consumerQuery = query.getText().toString();
		if (AppUtils.StringIsNullOrEmpty(consumerQuery) == false)
			AppUtils.SendQueryToMerchant(merchant, query.getText().toString());
		
		Intent intent = new Intent(this, SearchQuery.class);
		startActivity(intent);
	}
}
