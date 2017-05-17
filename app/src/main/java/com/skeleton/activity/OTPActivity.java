package com.skeleton.activity;

//import android.content.Intent;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;
//import android.widget.TextView;

import com.skeleton.R;
import com.skeleton.constant.AppConstant;
import com.skeleton.model.SignUpResponseModel;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.ApiInterface;
import com.skeleton.retrofit.CommonParams;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;

import java.util.HashMap;

import io.paperdb.Paper;

/**
 * otp activity
 */
public class OTPActivity extends AppCompatActivity implements AppConstant {

    private EditText etText1, etText2, etText3, etText4;
    private Button btnVerify, btnResendOtp, btnEditNo;
    private String otp, accessToken;
    private TextView tvCustomText, tvPhoneNo, tvCountryCode, tvSkip;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_otp);
        etText1 = (EditText) findViewById(R.id.et_text1);
        etText2 = (EditText) findViewById(R.id.et_text2);
        etText3 = (EditText) findViewById(R.id.et_text3);
        etText4 = (EditText) findViewById(R.id.et_text4);
        btnVerify = (Button) findViewById(R.id.btn_verify);
        btnResendOtp = (Button) findViewById(R.id.btn_resendotp);
        btnEditNo = (Button) findViewById(R.id.btn_editno);
        tvCustomText = (TextView) findViewById(R.id.tv_customtext);
        tvPhoneNo = (TextView) findViewById(R.id.tv_phoneno);
        tvCountryCode = (TextView) findViewById(R.id.tv_countrycode);
        tvSkip = (TextView) findViewById(R.id.tv_skip);


        Paper.init(getApplicationContext());
        etText1.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(final CharSequence s, final int start, final int before, final int count) {
                if (etText1.getText().toString().length() == 1) {
                    etText2.requestFocus();
                }
            }

            public void beforeTextChanged(final CharSequence s, final int start,
                                          final int count, final int after) {
            }

            public void afterTextChanged(final Editable s) {
            }

        });

        etText2.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(final CharSequence s, final int start, final int before, final int count) {
                if (etText2.getText().toString().length() == 1) {
                    etText3.requestFocus();
                }
            }

            public void beforeTextChanged(final CharSequence s, final int start,
                                          final int count, final int after) {
            }

            public void afterTextChanged(final Editable s) {
            }

        });

        etText3.addTextChangedListener(new TextWatcher() {

            public void onTextChanged(final CharSequence s, final int start, final int before, final int count) {
                if (etText3.getText().toString().length() == 1) {
                    etText4.requestFocus();
                }
            }

            public void beforeTextChanged(final CharSequence s, final int start,
                                          final int count, final int after) {
            }

            public void afterTextChanged(final Editable s) {
            }

        });

        accessToken = Paper.book().read("accessToken");
        final SignUpResponseModel signUpResponseModel = Paper.book().read("userProfile");

        tvCustomText.setText("Phone Number Verification");
        tvCountryCode.setText(signUpResponseModel.getData().getUserDetails().getCountryCode());
        tvPhoneNo.setText(signUpResponseModel.getData().getUserDetails().getPhoneNo());
        tvSkip.setVisibility(View.GONE);
        btnVerify.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

                otp = etText1.getText().toString() + etText2.getText().toString() + etText3.getText().toString()
                        + etText4.getText().toString();

                Toast.makeText(getApplicationContext(), otp, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), signUpResponseModel.getData().getUserDetails().getPhoneNo(), Toast.LENGTH_SHORT).show();
                HashMap<String, String> checkData = new CommonParams.Builder()
                        .add(KEY_FRAGMENT_COUNTRYCODE, signUpResponseModel.getData().getUserDetails().getCountryCode())
                        .add(KEY_FRAGMENT_MOBILENO, signUpResponseModel.getData().getUserDetails().getPhoneNo())
                        .add(KEY_FRAGMENT_OTP_CODE, otp).build().getMap();
                ApiInterface apiInterface = RestClient.getApiInterface();
                apiInterface.verifyOTP(accessToken, checkData)
                        .enqueue(new ResponseResolver<SignUpResponseModel>(getApplicationContext(), true, true) {
                            @Override
                            public void success(final SignUpResponseModel signUpResponseModel) {
                                Toast.makeText(getApplicationContext(), "OTP Verified", Toast.LENGTH_SHORT).show();
                                startActivity(new Intent(OTPActivity.this, ProfileActivity.class));
                            }

                            @Override
                            public void failure(final APIError error) {
                            }
                        });
            }
        });

        btnResendOtp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                ApiInterface apiInterface = RestClient.getApiInterface();
                apiInterface.resendOtp(accessToken).enqueue(new ResponseResolver<SignUpResponseModel>(getApplicationContext(), true, true) {
                    @Override
                    public void success(final SignUpResponseModel signUpResponseModel) {
                        Toast.makeText(getApplicationContext(), "New Otp sent", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void failure(final APIError error) {

                    }
                });
            }
        });

        btnEditNo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {

            }
        });

    }
}