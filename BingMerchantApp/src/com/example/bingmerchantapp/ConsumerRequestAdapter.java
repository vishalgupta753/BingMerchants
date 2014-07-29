package com.example.bingmerchantapp;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class ConsumerRequestAdapter extends ArrayAdapter<String> {
  private final Context context;
  private final String[] values;

  public ConsumerRequestAdapter(Context context, String[] values) {
    super(context, R.layout.consumer_request_row_layout, values);
    this.context = context;
    this.values = values;
  }

  @Override
  public View getView(int position, View convertView, ViewGroup parent) {
    LayoutInflater inflater = (LayoutInflater) context
        .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
    View rowView = inflater.inflate(R.layout.consumer_request_row_layout, parent, false);
    TextView textViewService = (TextView) rowView.findViewById(R.id.merchantServices);
    TextView textViewName = (TextView) rowView.findViewById(R.id.merchantName);
    ImageView imageView = (ImageView) rowView.findViewById(R.id.merchantIcon);
    textViewService.setText("some service");
    textViewName.setText("some name");

    return rowView;
  }
} 