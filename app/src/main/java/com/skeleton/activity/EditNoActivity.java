package com.skeleton.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.skeleton.R;
import com.skeleton.constant.AppConstant;
import com.skeleton.model.SignUpResponseModel;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.MultipartParams;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;
import com.skeleton.util.customview.MaterialEditText;

import java.util.HashMap;

import io.paperdb.Paper;
import okhttp3.RequestBody;

/**
 * edit no acticity
 */

public class EditNoActivity extends AppCompatActivity implements AppConstant {

    private MaterialEditText etMobileNo;
    private String accessToken;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_edit_no);
        etMobileNo = (MaterialEditText) findViewById(R.id.et_mobileno);
        final Button btnSubmit = (Button) findViewById(R.id.btn_submit);
        Paper.init(getApplicationContext());
        accessToken = Paper.book().read("accessToken");


        btnSubmit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                Toast.makeText(getApplicationContext(), etMobileNo.getText(), Toast.LENGTH_SHORT).show();
                HashMap<String, RequestBody> hashMap = new MultipartParams.Builder()
                        .add(KEY_NEW_NUMBER, etMobileNo.getText())
                        .build().getMap();
                RestClient.getApiInterface().updateProfile(accessToken, hashMap)
                        .enqueue(new ResponseResolver<SignUpResponseModel>(getApplicationContext(), true, true) {
                            @Override
                            public void success(final SignUpResponseModel signUpResponseModel) {
                                Toast.makeText(getApplicationContext(), "mobile no updated", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(EditNoActivity.this, OTPActivity.class));
                            }

                            @Override
                            public void failure(final APIError error) {

                            }
                        });
            }

        });
    }
}
