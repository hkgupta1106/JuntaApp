package com.skeleton.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.skeleton.R;
import com.skeleton.adapter.RecyclerViewAdapter;

/**
 * Created by himanshu on 18/5/17.
 */

public class Profile2Fragment extends Fragment {

    private TextView tvCustomText;
    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profile2, container, false);

        tvCustomText = (TextView) view.findViewById(R.id.tv_customtext);
        tvCustomText.setText("Profile Completeness");

        RecyclerViewAdapter recyclerViewAdapter = new RecyclerViewAdapter(getContext());

        RecyclerView recyclerView = (RecyclerView) view.findViewById(R.id.rvlayout);
        recyclerView.setLayoutManager(new GridLayoutManager(getContext(), 2));
        recyclerView.setAdapter(recyclerViewAdapter);
        recyclerView.setHasFixedSize(true);

        return view;
    }
}
