package com.example.bingmerchantapp;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

public class SearchActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_search);
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
		if(id == R.id.action_notif){
			startActivity(new Intent(this,ConsumerRequestListActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void goToMerchantList(View view)
	{
		EditText ET = (EditText) findViewById(R.id.editText1);
		MainActivity.Keyword = ET.getText().toString();
		startActivity(new Intent(this,MerchantListActivity.class));
		ET.setText("");
	}
}
