package com.example.bingmerchantapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bingmerchantapp.data.Message;
import com.example.bingmerchantapp.dummy.DummyContent;

/**
 * A fragment representing a single MerchantRequest detail screen. This fragment
 * is either contained in a {@link MerchantRequestListActivity} in two-pane mode
 * (on tablets) or a {@link MerchantRequestDetailActivity} on handsets.
 */
public class MerchantRequestDetailFragment extends Fragment {
	/**
	 * The fragment argument representing the item ID that this fragment
	 * represents.
	 */
	public static final String ARG_ITEM_ID = "item_id";

	/**
	 * The dummy content this fragment is presenting.
	 */
	private Message mItem;

	/**
	 * Mandatory empty constructor for the fragment manager to instantiate the
	 * fragment (e.g. upon screen orientation changes).
	 */
	public MerchantRequestDetailFragment() {
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

		if (getArguments().containsKey(ARG_ITEM_ID)) {
			// Load the dummy content specified by the fragment
			// arguments. In a real-world scenario, use a Loader
			// to load content from a content provider.
			mItem = Message.ITEM_MAP.get(getArguments().getString(
					ARG_ITEM_ID));
		}
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		View rootView = inflater.inflate(
				R.layout.fragment_merchantrequest_detail, container, false);

		// Show the dummy content as text in a TextView.
		if (mItem != null) {
			((TextView) rootView.findViewById(R.id.requestConsumerName))
			.setText(mItem.getConsumer().getName());
			((TextView) rootView.findViewById(R.id.consumerCellPhone))
			.setText(mItem.getConsumer().getPhone());
			((TextView) rootView.findViewById(R.id.consumerMessage))
			.setText(mItem.getMessage());
			MerchantRequestDetailActivity.message = mItem;
		}

		return rootView;
	}
}
