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

public class SpinnerCustomAdapter extends BaseAdapter {

    private Context mContext;
    private View mView;

    public SpinnerCustomAdapter(Context context) {
        this.mContext = context;
    }

    @Override
    public int getCount() {
        return this.mContext.getResources().getStringArray(R.array.spinner_array).length;
    }

    @Override
    public String getItem(int i) {
        return this.mContext.getResources().getStringArray(R.array.spinner_array)[i];
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        SpinnerCustomViewHolder spinnerCustomViewHolder;

        if (view == null) {
            view = LayoutInflater.from(this.mContext).inflate(R.layout.spinner_custom, viewGroup, false);

            spinnerCustomViewHolder = new SpinnerCustomViewHolder();
            spinnerCustomViewHolder.imageView = (ImageView) view.findViewById(R.id.imageView);
            spinnerCustomViewHolder.textView = (TextView) view.findViewById(R.id.textView);

            view.setTag(spinnerCustomViewHolder);
        } else {
            spinnerCustomViewHolder = (SpinnerCustomViewHolder) view.getTag();
        }

        spinnerCustomViewHolder.imageView.setImageDrawable(ContextCompat.getDrawable(this.mContext, R.drawable.ic_planet));
        spinnerCustomViewHolder.textView.setText(getItem(i));

        return view;
    }

    private class SpinnerCustomViewHolder {
        ImageView imageView;
        TextView textView;
    }

}
