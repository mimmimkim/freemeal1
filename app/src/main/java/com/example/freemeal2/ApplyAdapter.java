package com.example.freemeal2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.List;

public class ApplyAdapter extends BaseAdapter {
    private List<ListViewApply> mData;

    public ApplyAdapter(List<ListViewApply> data) {
        this.mData = data;
    }

    @Override
    public int getCount() {
        return mData.size();
    }

    @Override
    public Object getItem(int position) {
        return mData.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View view, ViewGroup parent) {
        view= LayoutInflater.from(parent.getContext())
                .inflate(R.layout.liskview_apply, parent, false);

        TextView apply_soup_kitchen_name=view.findViewById(R.id.apply_soup_kitchen_name);

        ListViewApply apply_name=mData.get(position);
        apply_soup_kitchen_name.setText(apply_name.getApply());

        return view;
    }
}
