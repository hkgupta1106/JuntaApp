package com.skeleton.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.skeleton.R;

/**
 * Created by himanshu on 19/5/17.
 */

public class RecyclerViewAdapter extends android.support.v7.widget.RecyclerView.Adapter<RecyclerViewAdapter.ViewHolder> {

    private static final int NUM = 10;
    private Context context;

    /**
     * @param context context
     */
    public RecyclerViewAdapter(final Context context) {
        this.context = context;
    }

    @Override
    public RecyclerViewAdapter.ViewHolder onCreateViewHolder(final ViewGroup parent, final int viewType) {

        View convertView = LayoutInflater.from(context).inflate(R.layout.viewholder_profile2, parent, false);
        ViewHolder viewHolder = new RecyclerViewAdapter.ViewHolder(convertView);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(final RecyclerViewAdapter.ViewHolder holder, final int position) {

    }

    /**
     * view holder
     */
    public class ViewHolder extends RecyclerView.ViewHolder {
        /**
         * @param itemView itemm view
         */
        public ViewHolder(final View itemView) {
            super(itemView);


        }
    }

    @Override
    public int getItemCount() {
        return NUM;
    }
}
