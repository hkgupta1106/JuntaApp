package com.skeleton.fragment;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.skeleton.R;
import com.skeleton.model.SignUpResponseModel;
import com.skeleton.model.profile.Response;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.ApiInterface;
import com.skeleton.retrofit.MultipartParams;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;
import com.skeleton.util.customview.MaterialEditText;

import java.util.HashMap;
import java.util.List;

import io.paperdb.Paper;
import okhttp3.RequestBody;

/**
 * Created by himanshu on 16/5/17.
 */

public class Profile1Fragment extends BaseFragment {
    private MaterialEditText etRelationshipHistory, etEthencity, etReligion, etHeight, etBodyType, etSmoking, etDrinking, etOrientation;
    private Response response1;
    private TextView tvText1, tvText2, tvText3, tvText4, tvText5, tvText6, tvText7, tvText8;
    private Button btnNext;
    private String accessToken;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        final View view = inflater.inflate(R.layout.fragment_profile1, container, false);
        init(view);

        ApiInterface apiInterface = RestClient.getApiInterface();
        apiInterface.getResponse().enqueue(new ResponseResolver<com.skeleton.model.profile.Response>(getContext(), true, true) {

            @Override
            public void success(final com.skeleton.model.profile.Response response) {
                Toast.makeText(getContext(), response.getMessage(), Toast.LENGTH_SHORT).show();
                response1 = response;
                etRelationshipHistory.setOnClickListener(Profile1Fragment.this);
                etEthencity.setOnClickListener(Profile1Fragment.this);
                etReligion.setOnClickListener(Profile1Fragment.this);
                etHeight.setOnClickListener(Profile1Fragment.this);
                etBodyType.setOnClickListener(Profile1Fragment.this);
                etSmoking.setOnClickListener(Profile1Fragment.this);
                etDrinking.setOnClickListener(Profile1Fragment.this);
                etOrientation.setOnClickListener(Profile1Fragment.this);
                btnNext.setOnClickListener(Profile1Fragment.this);
            }

            @Override
            public void failure(final APIError error) {

            }
        });
        return view;
    }

    @Override
    public void onClick(final View v) {
        super.onClick(v);
        switch (v.getId()) {
            case R.id.et_relationshiphitory:
                alertDropBox("Relationship History", response1.getData().getRelationshipHistory(), etRelationshipHistory, tvText1);
                break;
            case R.id.et_ethnicity:
                alertDropBox("Ethnicity", response1.getData().getEthnicity(), etEthencity, tvText2);
                break;
            case R.id.et_religion:
                alertDropBox("Religion", response1.getData().getReligion(), etReligion, tvText3);
                break;
            case R.id.et_height:
                alertDropBox("Height", response1.getData().getHeight(), etHeight, tvText4);
                break;
            case R.id.et_bodytype:
                alertDropBox("BodyType", response1.getData().getBodyType(), etBodyType, tvText5);
                break;
            case R.id.et_smoking:
                alertDropBox("Smoking", response1.getData().getSmoking(), etSmoking, tvText6);
                break;
            case R.id.et_drinking:
                alertDropBox("Drinking", response1.getData().getDrinking(), etDrinking, tvText7);
                break;
            case R.id.et_orientation:
                alertDropBox("Orientation", response1.getData().getOrientation(), etOrientation, tvText8);
                break;
            case R.id.btn_next:
                update();
                break;
            default:
                break;
        }
    }

    /**
     * @param mTitle     title
     * @param list       list
     * @param etItem     item
     * @param tvSelector selector
     */
    public void alertDropBox(final String mTitle, final List<String> list, final MaterialEditText etItem
            , final TextView tvSelector) {
        final CharSequence[] cs = list.toArray(new CharSequence[list.size()]);
        AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
        builder.setTitle(mTitle);
        builder.setItems(cs, new DialogInterface.OnClickListener() {
            public void onClick(final DialogInterface dialog, final int item) {
                etItem.setText(cs[item]);
                tvSelector.setBackgroundResource(R.color.green);
            }
        });
        AlertDialog alert = builder.create();
        alert.show();
    }

    /**
     * @param view view
     */
    public void init(final View view) {
        etRelationshipHistory = (MaterialEditText) view.findViewById(R.id.et_relationshiphitory);
        etEthencity = (MaterialEditText) view.findViewById(R.id.et_ethnicity);
        etReligion = (MaterialEditText) view.findViewById(R.id.et_religion);
        etHeight = (MaterialEditText) view.findViewById(R.id.et_height);
        etBodyType = (MaterialEditText) view.findViewById(R.id.et_bodytype);
        etSmoking = (MaterialEditText) view.findViewById(R.id.et_smoking);
        etDrinking = (MaterialEditText) view.findViewById(R.id.et_drinking);
        etOrientation = (MaterialEditText) view.findViewById(R.id.et_orientation);
        tvText1 = (TextView) view.findViewById(R.id.tv_text1);
        tvText2 = (TextView) view.findViewById(R.id.tv_text2);
        tvText3 = (TextView) view.findViewById(R.id.tv_text3);
        tvText4 = (TextView) view.findViewById(R.id.tv_text4);
        tvText5 = (TextView) view.findViewById(R.id.tv_text5);
        tvText6 = (TextView) view.findViewById(R.id.tv_text6);
        tvText7 = (TextView) view.findViewById(R.id.tv_text7);
        tvText8 = (TextView) view.findViewById(R.id.tv_text8);
        btnNext = (Button) view.findViewById(R.id.btn_next);

        Paper.init(getContext());

        accessToken = Paper.book().read("accessToken");
    }

    /**
     * update data
     */
    public void update() {
        HashMap<String, RequestBody> hashMap = new MultipartParams.Builder()
                .add(KEY_FRAGMENT_RELATIONSHIP_HISTORY, etRelationshipHistory.getText().toString())
                .add(KEY_FRAGMENT_ETHNICITY, etEthencity.getText().toString())
                .add(KEY_FRAGMENT_RELIGION, etReligion.getText().toString())
                .add(KEY_FRAGMENT_HEIGHT, etHeight.getText().toString())
                .add(KEY_FRAGMENT_BODY_TYPE, etBodyType.getText().toString())
                .add(KEY_FRAGMENT_SMOKING, etSmoking.getText().toString())
                .add(KEY_FRAGMENT_DRINKING, etDrinking.getText().toString())
                .add(KEY_FRAGMENT_ORIENTAION, etOrientation.getText().toString())
                .build().getMap();
        RestClient.getApiInterface().updateProfile(accessToken, hashMap)
                .enqueue(new ResponseResolver<SignUpResponseModel>(getActivity(), true, true) {
                    @Override
                    public void success(final SignUpResponseModel signUpResponseModel) {
                        Toast.makeText(getContext(), "update successfully", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failure(final APIError error) {
                        Toast.makeText(getContext(), error.getMessage(), Toast.LENGTH_SHORT).show();
                    }
                });
    }

}