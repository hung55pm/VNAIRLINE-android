package com.fts.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.fts.constants.Constants;
import com.fts.models.Model_flight;

import java.util.ArrayList;

/**
 * Created by hungdn on 1/9/18.
 */

public class FlightAdapters extends BaseAdapter {

    private ArrayList<Model_flight> data;
    private Context context;
    LayoutInflater inflater = null;
    public FlightAdapters(Context context, ArrayList<Model_flight> data){
        this.context = context;
        this.data = data;
        inflater = (LayoutInflater) context.getSystemService(context.LAYOUT_INFLATER_SERVICE);
    }
    @Override
    public int getCount() {
        return data.size();
    }

    @Override
    public Object getItem(int position) {
        return data.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        return null;
    }
    private class ViewHolder {
        private TextView txtseries, txtunit, txtprice, txtmarketvalue;

    }
}
