package com.fafica.aulaviews.adapter;

import android.content.Context;
import android.support.v4.content.ContextCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.fafica.aulaviews.R;

/**
 * Created by pedrodimoura on 06/09/16.
 */

public class ListViewCustomAdapter extends BaseAdapter {

    private Context mContext;
    private String[] mStrings;

    public ListViewCustomAdapter(Context context, String[]strings) {
        this.mContext = context;
        this.mStrings = strings;
    }

    @Override
    public int getCount() {
        return (this.mStrings != null && this.mStrings.length > 0 ? this.mStrings.length : 0);
    }

    @Override
    public String getItem(int i) {
        return this.mStrings[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ListViewCustomViewHolder listViewCustomViewHolder;

        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.list_view_custom, viewGroup, false);

            listViewCustomViewHolder = new ListViewCustomViewHolder();
            listViewCustomViewHolder.imageView = (ImageView) view.findViewById(R.id.imageView);
            listViewCustomViewHolder.textView = (TextView) view.findViewById(R.id.textView);

            view.setTag(listViewCustomViewHolder);
        } else {
            listViewCustomViewHolder = (ListViewCustomViewHolder) view.getTag();
        }

        listViewCustomViewHolder.imageView.setImageDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.ic_planet));
        listViewCustomViewHolder.textView.setText(getItem(i));

        return view;
    }

    class ListViewCustomViewHolder {
        ImageView imageView;
        TextView textView;
    }

}
