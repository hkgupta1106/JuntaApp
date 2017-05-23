package com.skeleton.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.kbeanie.multipicker.api.entity.ChosenImage;
import com.skeleton.R;
import com.skeleton.activity.OTPActivity;
import com.skeleton.constant.AppConstant;
import com.skeleton.model.SignUpResponseModel;
import com.skeleton.retrofit.APIError;
import com.skeleton.retrofit.ApiInterface;
import com.skeleton.retrofit.MultipartParams;
import com.skeleton.retrofit.ResponseResolver;
import com.skeleton.retrofit.RestClient;
import com.skeleton.util.ValidateEditText;
import com.skeleton.util.customview.MaterialEditText;
import com.skeleton.util.imagepicker.ImageChooser;

import java.io.File;
import java.util.HashMap;
import java.util.List;

import io.paperdb.Paper;
import okhttp3.RequestBody;

/**
 * sign up fragment
 */

public class SignupFragment extends Fragment implements AppConstant {


    private MaterialEditText etName, etEmail, etMobileNo, etPassword, etConfirmPassword, etDob, etCountryCode;
    private Button btnSignup;
    private RadioGroup rgGender;
    private ValidateEditText validateEditText = new ValidateEditText();
    private ImageView ciProfilePic;
    private ImageChooser imageChooser;
    private File file;
    private HashMap<String, RequestBody> map;
    private int selectedGender;
    private RadioButton rbGender;
    private String accessToken;

    @Override
    public View onCreateView(final LayoutInflater inflater, final ViewGroup container, final Bundle savedInstanceState) {
        Paper.init(getContext());
        final View view = inflater.inflate(R.layout.fragment_signup, container, false);
        initiallization(view);
        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                selectedGender = rgGender.getCheckedRadioButtonId();
                rbGender = (RadioButton) view.findViewById(selectedGender);
                if (isValidate()) {
                    if ("Male".equals(rbGender)) {
                        selectedGender = 0;
                    } else {
                        selectedGender = 1;
                    }
                    updateDataInHashMap();

                    ApiInterface apiInterface = RestClient.getApiInterface();
                    apiInterface.postUser(map).enqueue(new ResponseResolver<SignUpResponseModel>(getActivity(), true, true) {


                        @Override
                        public void success(final SignUpResponseModel signUpResponseModel) {
                            Toast.makeText(getContext(), "successful", Toast.LENGTH_SHORT).show();
                            if ("200".equals(String.valueOf(signUpResponseModel.getStatusCode()))) {
                                clearEditText();
                                accessToken = signUpResponseModel.getData().getAccessToken();

                                Toast.makeText(getContext(), accessToken, Toast.LENGTH_SHORT).show();
                                Paper.book().write("accessToken", ACCESS_START + accessToken);
                                Toast.makeText(getActivity(), "200 success added to server", Toast.LENGTH_SHORT).show();
                                Intent intent = new Intent(getContext(), OTPActivity.class);
                                startActivity(intent);
                            }
                        }

                        @Override
                        public void failure(final APIError error) {

                        }
                    });
                }
            }
        });

        ciProfilePic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(final View v) {
                imageChooser = new ImageChooser(new ImageChooser.Builder(SignupFragment.this));
                imageChooser.selectImage(new ImageChooser.OnImageSelectListener() {
                    @Override
                    public void loadImage(final List<ChosenImage> list) {
                        file = new File(list.get(0).getOriginalPath());
                        if (file != null) {
                            Glide.with(SignupFragment.this)
                                    .load(list.get(0).getQueryUri())
                                    .into(ciProfilePic);
                        }
                    }

                    @Override
                    public void croppedImage(final File mCroppedImage) {

                    }
                });
            }
        });
        return view;
    }

    /**
     * @param view view
     */
    public void initiallization(final View view) {
        etName = (MaterialEditText) view.findViewById(R.id.et_name);
        etEmail = (MaterialEditText) view.findViewById(R.id.et_email);
        etMobileNo = (MaterialEditText) view.findViewById(R.id.et_contactno);
        etPassword = (MaterialEditText) view.findViewById(R.id.et_password);
        etConfirmPassword = (MaterialEditText) view.findViewById(R.id.et_confirm_password);
        etDob = (MaterialEditText) view.findViewById(R.id.et_dob);
        etCountryCode = (MaterialEditText) view.findViewById(R.id.et_countrycode);
        ciProfilePic = (ImageView) view.findViewById(R.id.ci_profilepic);
        btnSignup = (Button) view.findViewById(R.id.btn_Signup);
        rgGender = (RadioGroup) view.findViewById(R.id.rg_Gender);

    }

    /**
     * @return result
     */
    private boolean isValidate() {
        if (validateEditText.checkName(etName, true)
                && validateEditText.checkName(etName, false)
                && validateEditText.checkPhoneNumber(etMobileNo)
                && validateEditText.checkEmail(etEmail)
                && validateEditText.checkPassword(etPassword, false)
                && validateEditText.checkPassword(etConfirmPassword, true)
                && validateEditText.comparePassword(etPassword, etConfirmPassword)
                && selectedGender != -1) {
            return validateEditText.checkEmail(etEmail);
        } else {
            return false;
        }
    }

    @Override
    public void onActivityResult(final int requestCode, final int resultCode, final Intent data) {
        imageChooser.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void onRequestPermissionsResult(final int requestCode, final String[] permissions, final int[] grantResults) {
        imageChooser.onRequestPermissionsResult(requestCode, permissions, grantResults);
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    /**
     * hash map
     */
    public void updateDataInHashMap() {
        map = new MultipartParams.Builder()
                .add(KEY_FRAGMENT_FNAME, etName.getText().toString().trim())
                .add(KEY_FRAGMENT_LNAME, etName.getText().toString().trim())
                .add(KEY_FRAGMENT_DOB, etDob.getText().toString().trim())
                .add(KEY_FRAGMENT_COUNTRYCODE, etCountryCode.getText().toString().trim())
                .add(KEY_FRAGMENT_MOBILENO, etMobileNo.getText().toString().trim())
                .add(KEY_FRAGMENT_EMAIL, etEmail.getText().toString().trim())
                .add(KEY_FRAGMENT_PASSWORD, etPassword.getText().toString().trim())
                .add(KEY_FRAGMENT_LANGUAGE, LANGUAGE)
                .add(KEY_FRAGMENT_DEVICETYPE, DEVICE_TYPE)
                .add(KEY_FRAGMENT_DEVICETOKEN, DEVICE_TOKEN)
                .add(KEY_FRAGMENT_APPVERSION, APP_VERSION)
                .add(KEY_FRAGMENT_GENDER, selectedGender)
                .add(KEY_FRAGMENT_PROFILEPIC, ciProfilePic)
                .build().getMap();
    }

    /**
     * method to clear edit text
     */
    public void clearEditText() {
        etName.setText("");
        etMobileNo.setText("");
        etEmail.setText("");
        etDob.setText("");
        etPassword.setText("");
        etConfirmPassword.setText("");
    }

}
