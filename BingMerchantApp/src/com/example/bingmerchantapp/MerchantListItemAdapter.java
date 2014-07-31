package com.example.bingmerchantapp;

import java.util.List;
import java.util.Random;

import com.example.bingmerchantapp.data.Merchant;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MerchantListItemAdapter extends ArrayAdapter<Merchant> {
	private Context mContext;
	
	
	public MerchantListItemAdapter(Context context, int resource,
			int textViewResourceId, List<Merchant> objects) {
		super(context, resource, textViewResourceId, objects);
		this.mContext = context;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		View merchantListItemView = convertView;
		LayoutInflater inflater = (LayoutInflater)mContext 
		        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		if(merchantListItemView == null){
			merchantListItemView = inflater.inflate(R.layout.entity_list_view, parent, false);
		}
		
		Merchant merchantItem = getItem(position);
		
		TextView merchantBusinessName = (TextView) merchantListItemView.findViewById(R.id.merchantBusinessName);
		TextView merchantBusinessTags = (TextView) merchantListItemView.findViewById(R.id.merchantBusinessTags);
		ImageView image = (ImageView) merchantListItemView.findViewById(R.id.imageView1);
		int imageDrawable = AppUtils.getRandomImageInt();
		image.setImageResource (imageDrawable);

		merchantBusinessName.setText(merchantItem.getBusinessName());
		merchantBusinessTags.setText(merchantItem.getServices());
		TextView count = (TextView) merchantListItemView.findViewById(R.id.recommendedCount1);
		Random rand = new Random();
		int randomNum = rand.nextInt(10) + 1;
	    count.setText(String.valueOf(randomNum));
	    Boolean favVisibility = false;
	    if (randomNum % 2 == 0)
	    	favVisibility = true;
	    ImageView fav = (ImageView) merchantListItemView.findViewById(R.id.favorite);
	    if (!favVisibility)
	    	fav.setVisibility(View.INVISIBLE);
		
	    
		
		return merchantListItemView;
	}

	
}
