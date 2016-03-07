package com.pocketwiki.pocketwiki;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;
import java.util.Map;

/**
 * Created by chinmay on 14/1/16.
 */
public class CityCategoryListAdapter extends BaseAdapter {

    Context mContext;
    LayoutInflater mInflater;
    List<CityCategoryListItemDTO> mDataSet;
    boolean mCheckBoxDesired;

    public CityCategoryListAdapter(List<CityCategoryListItemDTO> dataSet, Context context) {
        mContext = context;
        mDataSet = dataSet;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mCheckBoxDesired = false;
    }

    public CityCategoryListAdapter(List<CityCategoryListItemDTO> dataSet, Context context, boolean checkBoxDesired) {
        mContext = context;
        mDataSet = dataSet;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        mCheckBoxDesired = true;
    }

    @Override
    public int getCount() {
        return mDataSet.size();
    }

    @Override
    public Object getItem(int position) {
        return mDataSet.get(position);
    }

    @Override
    public long getItemId(int position) {
        return 0;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {

        final ViewHolder holder;
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item_city_category, parent, false);
            holder = new ViewHolder();
            holder.tvItemName = (TextView) convertView.findViewById(R.id.listitem_citycategory_tv_itemname);
            holder.tvEntityCount = (TextView) convertView.findViewById(R.id.listitem_citycategory_tv_entitycount);
            if(mCheckBoxDesired){
                convertView.findViewById(R.id.listitem_citycategory_rlt_cb).setVisibility(View.VISIBLE);
                holder.cbTick = (CheckBox) convertView.findViewById(R.id.listitem_citycategory_cb);
            }
            else {
                convertView.findViewById(R.id.listitem_citycategory_rlt_cb).setVisibility(View.GONE);
            }
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvItemName.setText(mDataSet.get(position).getItemName());
        holder.tvEntityCount.setText(String.valueOf(mDataSet.get(position).getEntityCount()) +
                " " +
                mContext.getResources().getString(R.string.suffix_entities));
        if(mCheckBoxDesired){

        }

        return convertView;
    }

    private static class ViewHolder {
        public TextView tvItemName;
        public TextView tvEntityCount;
        public CheckBox cbTick;
    }
}
