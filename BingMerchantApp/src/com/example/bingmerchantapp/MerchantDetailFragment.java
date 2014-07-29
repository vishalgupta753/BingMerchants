package com.example.bingmerchantapp;

import com.example.bingmerchantapp.data.Merchant;

import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;


/**
 * A fragment representing a single Merchant detail screen. This fragment is
 * either contained in a {@link MerchantListActivity} in two-pane mode (on
 * tablets) or a {@link MerchantDetailActivity} on handsets.
 */
public class MerchantDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The dummy content this fragment is presenting.
	 */
	private Merchant mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public MerchantDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = Merchant.ITEM_MAP.get(getArguments().getString(
					ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(R.layout.fragment_merchant_detail,
				container, false);

		// Show the dummy content as text in a TextView.
		if (mItem != null) {
			((TextView) rootView.findViewById(R.id.queryPageMerchantName))
					.setText(mItem.getName());
			((TextView) rootView.findViewById(R.id.sendQueryCellPhone))
			.setText(mItem.getPhone());
			((TextView) rootView.findViewById(R.id.sendQueryMerchantAddress))
			.setText(mItem.getAddress());
		}

		return rootView;
	}
}
