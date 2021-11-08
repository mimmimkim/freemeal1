package com.example.freemeal2;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.freemeal2.R;

import java.util.ArrayList;

public class FavAdapter extends BaseAdapter {

    Context mContext = null;
    LayoutInflater mLayoutInflater = null;
    ArrayList<SampleDataFav> sample;

    public FavAdapter(Context context, ArrayList<SampleDataFav> data) {
        mContext = context;
        sample = data;
        mLayoutInflater = LayoutInflater.from(mContext);
    }

    @Override
    public int getCount() {
        return sample.size();
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public SampleDataFav getItem(int position) {
        return sample.get(position);
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = mLayoutInflater.inflate(R.layout.listview_custom_mypage, null);

        TextView soup_kitchen_name = (TextView)view.findViewById(R.id.soup_kitchen_name);

        soup_kitchen_name.setText(sample.get(position).getSoup_kitchen_name());




        return view;
    }
}
