package com.example.bingmerchantapp;

import com.example.bingmerchantapp.data.Message;

import android.content.Intent;
import android.os.Bundle;
import android.app.Activity;

import android.view.MenuItem;
import android.view.View;
import android.widget.RadioButton;
import android.widget.RadioGroup;

/**
 * An activity representing a single MerchantRequest detail screen. This
 * activity is only used on handset devices. On tablet-size devices, item
 * details are presented side-by-side with a list of items in a
 * {@link MerchantRequestListActivity}.
 * <p>
 * This activity is mostly just a 'shell' activity containing nothing more than
 * a {@link MerchantRequestDetailFragment}.
 */
public class MerchantRequestDetailActivity extends Activity {

	public static Message message;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_merchantrequest_detail);

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
			arguments.putString(
					MerchantRequestDetailFragment.ARG_ITEM_ID,
					getIntent().getStringExtra(
							MerchantRequestDetailFragment.ARG_ITEM_ID));
			MerchantRequestDetailFragment fragment = new MerchantRequestDetailFragment();
			fragment.setArguments(arguments);
			getFragmentManager().beginTransaction()
					.add(R.id.merchantrequest_detail_container, fragment)
					.commit();
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
			navigateUpTo(new Intent(this, MerchantRequestListActivity.class));
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
	
	public void SendRequestStatus (View view)
	{
		String status = "o";
		if (view.getId()== R.id.submitRequestResponse)
		{
		RadioGroup rg = (RadioGroup) findViewById(R.id.radioGroup1);
		RadioButton rb = (RadioButton) findViewById(rg.getCheckedRadioButtonId());
		if (rb.getId() == R.id.radio0)
			status = "a";
		else
			status = "d";
		}
		else
		{
			status = "c";
		}
		AppUtils.UpdateStatus(message, status);
		startActivity(new Intent (this, MerchantRequestListActivity.class));
		finish();
	}
}
