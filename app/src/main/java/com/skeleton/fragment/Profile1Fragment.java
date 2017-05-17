package com.skeleton.fragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import com.skeleton.R;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.ApiInterface;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;

/**
 * Created by himanshu on 16/5/17.
 */

public class Profile1Fragment extends Fragment {
    private TextView tvRelationshipHistory;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profile1, container, false);

        tvRelationshipHistory = (TextView) view.findViewById(R.id.tv_relationshiphitory);
        ApiInterface apiInterface = RestClient.getApiInterface();
        apiInterface.getResponse().enqueue(new ResponseResolver<com.skeleton.model.profile.Response>(getContext(), true, true) {

            @Override
            public void success(final com.skeleton.model.profile.Response response) {
                Toast.makeText(getContext(), response.getMessage(), Toast.LENGTH_SHORT).show();
                tvRelationshipHistory.setText(response.getData().getRelationshipHistory().get(0));
            }

            @Override
            public void failure(final APIError error) {

            }
        });
        return view;
    }
}
