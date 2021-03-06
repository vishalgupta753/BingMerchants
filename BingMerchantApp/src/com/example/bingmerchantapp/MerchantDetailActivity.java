package com.example.bingmerchantapp;

import com.example.bingmerchantapp.data.Merchant;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;
import android.app.AlertDialog;

import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;

/**
 * An activity representing a single Merchant detail screen. This activity is
 * only used on handset devices. On tablet-size devices, item details are
 * presented side-by-side with a list of items in a {@link MerchantListActivity}
 * .
 * <p>
 * This activity is mostly just a 'shell' activity containing nothing more than
 * a {@link MerchantDetailFragment}.
 */
public class MerchantDetailActivity extends Activity {

	public static Merchant merchant;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_merchant_detail);

		// Show the Up button in the action bar.
		getActionBar().setDisplayHomeAsUpEnabled(true);

		// savedInstanceState is non-null when there is fragment state
		// saved from previous configurations of this activity
		// (e.g. when rotating the screen from portrait to landscape).
		// In this case, the fragment will automatically be re-added
		// to its container so we don't need to manually add it.
		// For more information, see the Fragments API guide at:
		//
		// http://developer.android.com/guide/components/fragments.html
		//
		if (savedInstanceState == null) {
			// Create the detail fragment and add it to the activity
			// using a fragment transaction.
			Bundle arguments = new Bundle();
			arguments.putString(MerchantDetailFragment.ARG_ITEM_ID, getIntent()
					.getStringExtra(MerchantDetailFragment.ARG_ITEM_ID));
			MerchantDetailFragment fragment = new MerchantDetailFragment();
			fragment.setArguments(arguments);
			getFragmentManager().beginTransaction()
					.add(R.id.merchant_detail_container, fragment).commit();
		}
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		int id = item.getItemId();
		if (id == android.R.id.home) {
			// This ID represents the Home or Up button. In the case of this
			// activity, the Up button is shown. For
			// more details, see the Navigation pattern on Android Design:
			//
			// http://developer.android.com/design/patterns/navigation.html#up-vs-back
			//
			navigateUpTo(new Intent(this, MerchantListActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}

	public void SendQueryToConsumer(View view) {
		EditText query = (EditText) findViewById(R.id.consumerQuery);
		String consumerQuery = query.getText().toString();
		if (AppUtils.StringIsNullOrEmpty(consumerQuery) == false)
			AppUtils.SendQueryToMerchant(merchant, query.getText().toString());
		
		new AlertDialog.Builder(this)
	    .setTitle("Send Query")
	    .setMessage("Your Query has been successfully saved")
	    .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
	        public void onClick(DialogInterface dialog, int which) { 
	        	gotoSearchQueryPage();
	        }
	     })
	    .setIcon(android.R.drawable.ic_dialog_alert)
	     .show();
		
		
	}
	
	public void gotoSearchQueryPage()
	{
		Intent intent = new Intent(this, SearchActivity.class);
		startActivity(intent);
		finish();
	}
}
