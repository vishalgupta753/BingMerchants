package com.example.bingmerchantapp;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.RelativeLayout;

public class MerchantSignup extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.merchant_signup);
		setBusinessCheckBoxListner();
		
	}

	public void setBusinessCheckBoxListner ()
	{
		CheckBox merchantCheckBox = (CheckBox)findViewById(R.id.isMerchantCheckbox);
		merchantCheckBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {

		       @Override
		       public void onCheckedChanged(CompoundButton buttonView,boolean isChecked) {

		    	   //Toggle the visibility of the business fields based on the check box
		    	   if (isChecked)
		    	   {
		    		   CheckBox gpsCheckBox = (CheckBox)findViewById(R.id.merchantUseLocation);
			    	   gpsCheckBox.setVisibility(View.VISIBLE);
		    	   
			    	   EditText buName = (EditText)findViewById(R.id.businessName);
			    	   buName.setVisibility(View.VISIBLE);
			    	
			    	   EditText services = (EditText)findViewById(R.id.merchantServices);
			    	   services.setVisibility(View.VISIBLE);
		    	   
			    	   //Move the submit button down
			    	   Button submit = (Button)findViewById(R.id.merchantSubmitRegistration);

			    	   RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)submit.getLayoutParams();
			    	   params.addRule(RelativeLayout.BELOW, R.id.merchantServices);

			    	   submit.setLayoutParams(params);
		    	   }
		    	   else
		    	   {
		    		   CheckBox gpsCheckBox = (CheckBox)findViewById(R.id.merchantUseLocation);
			    	   gpsCheckBox.setVisibility(View.INVISIBLE);
		    	   
			    	   EditText buName = (EditText)findViewById(R.id.businessName);
			    	   buName.setVisibility(View.INVISIBLE);
			    	
			    	   EditText services = (EditText)findViewById(R.id.merchantServices);
			    	   services.setVisibility(View.INVISIBLE);
		    	   
			    	   //Move the submit button down
			    	   Button submit = (Button)findViewById(R.id.merchantSubmitRegistration);

			    	   RelativeLayout.LayoutParams params = (RelativeLayout.LayoutParams)submit.getLayoutParams();
			    	   params.addRule(RelativeLayout.BELOW, R.id.checkBoxesSignup);

			    	   submit.setLayoutParams(params);
		    	   }
		       }
		   }
		); 
	}
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.merchant_signup, menu);
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
	
	public void SaveMerchantData(View view)
	{
		EditText editText = (EditText) findViewById(R.id.merchantName);
		String merchantName = editText.getText().toString();
		editText = (EditText)findViewById(R.id.merchantServices);
		String merchantServices = editText.getText().toString();
		editText = (EditText)findViewById(R.id.merchantCellphone);
		String merchantCellphone = editText.getText().toString();
		editText = (EditText)findViewById(R.id.merchantZipcode);
		String merchantAddress = editText.getText().toString();
		
		CheckBox checkBox = (CheckBox)findViewById(R.id.merchantUseLocation);
		boolean useCurrentLocation = checkBox.isChecked();
		
		AppUtils.SaveNewMerchant(merchantName, merchantAddress, "", merchantCellphone, merchantServices);
		AppUtils.SaveLocalUserId(merchantCellphone, "m");
		
		Intent intent = new Intent(this, MerchantListActivity.class);
		startActivity(intent);
	}
}
