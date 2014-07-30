package com.example.bingmerchantapp;

import android.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.bingmerchantapp.data.Merchant;
import com.example.bingmerchantapp.data.Message;
import com.example.bingmerchantapp.dummy.DummyContent;

/**
 * A fragment representing a single ConsumerRequest detail screen. This fragment
 * is either contained in a {@link ConsumerRequestListActivity} in two-pane mode
 * (on tablets) or a {@link ConsumerRequestDetailActivity} on handsets.
 */
public class ConsumerRequestDetailFragment extends Fragment {
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
	public ConsumerRequestDetailFragment() {
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
				R.layout.fragment_consumerrequest_detail, container, false);

		// Show the dummy content as text in a TextView.
		if (mItem != null) {
				((TextView) rootView.findViewById(R.id.customerRequestMerchantName))
				.setText(mItem.getMerchant().getName());
				((TextView) rootView.findViewById(R.id.customerRequestMerchantBusiness))
				.setText(mItem.getMerchant().toString());
				((TextView) rootView.findViewById(R.id.merchantCellPhone))
				.setText(mItem.getMerchant().getPhone());
				
				String  messageStatus = "";
				if (mItem.getMessageStatus().equals("o"))
				{
					messageStatus = "Requested business has not reverted back";
				}
				else if (mItem.getMessageStatus().equals("a"))
				{
					messageStatus = "Your request has been accepted";
				}
				else if (mItem.getMessageStatus().equals("d"))
				{
					messageStatus = "Your request has been declined";
				}
				else if (mItem.getMessageStatus().equals("c"))
				{
					messageStatus = "Your request has been completed";
				}
				
				((TextView) rootView.findViewById(R.id.merchantStatus))
				.setText(messageStatus);
				
				ConsumerRequestDetailActivity.message = mItem;
		}
		return rootView;
	}
}
