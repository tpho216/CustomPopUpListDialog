package com.tpho.custompopuplistdialog;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.List;

public class ListItemArrayAdapter extends ArrayAdapter<ListItemActivity.Item> {

    private final List<ListItemActivity.Item> list;
    private final Activity context;

    static class ViewHolder {
        protected TextView name;
        protected ImageView photo;
    }

    public ListItemArrayAdapter(Activity context, List<ListItemActivity.Item> list) {
        super(context, R.layout.activity_itemcode_row, list);
        this.context = context;
        this.list = list;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        View view = null;

        if (convertView == null) {
            LayoutInflater inflator = context.getLayoutInflater();
            view = inflator.inflate(R.layout.activity_itemcode_row, null);
            final ViewHolder viewHolder = new ViewHolder();
            viewHolder.name = (TextView) view.findViewById(R.id.name);
            viewHolder.photo = (ImageView) view.findViewById(R.id.photo);
            view.setTag(viewHolder);
        } else {
            view = convertView;
        }

        ViewHolder holder = (ViewHolder) view.getTag();
        holder.name.setText(list.get(position).getName());
        holder.photo.setImageDrawable(list.get(position).getFlag());
        return view;
    }
}