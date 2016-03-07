package com.pocketwiki.pocketwiki;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.CheckBox;
import android.widget.TextView;

import java.util.List;

/**
 * Created by chinmay on 24/1/16.
 */
public class EntityListAdapter extends BaseAdapter {

    private List<String> mDataSet;
    private Context mContext;
    private LayoutInflater mInflater;

    public EntityListAdapter(List<String> dataSet, Context context) {
        this.mDataSet = dataSet;
        this.mContext = context;
        mInflater = (LayoutInflater) mContext.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
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
        if(position==0){

        }
        if (convertView == null) {
            convertView = mInflater.inflate(R.layout.list_item_entity, parent, false);
            holder = new ViewHolder();
            holder.tvEntityName = (TextView) convertView.findViewById(R.id.listitem_entity_tv_name);
            convertView.setTag(holder);
        } else {
            holder = (ViewHolder) convertView.getTag();
        }

        holder.tvEntityName.setText(mDataSet.get(position));

        return convertView;
    }

    private static class ViewHolder {
        public TextView tvEntityName;
    }
}
