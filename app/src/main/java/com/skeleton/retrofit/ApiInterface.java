package com.skeleton.retrofit;

import com.skeleton.model.SignUpResponseModel;

import java.util.HashMap;

import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.PUT;
import retrofit2.http.PartMap;

import static com.skeleton.constant.ApiKeyConstant.AUTHORIZATION;

/**
 * Developer: Saurabh Verma
 * Dated: 27-09-2016.
 */
public interface ApiInterface {
    String UPDATE_LOCATION = "api/v1/user/updateLocation";
    String SUB_URL = "api/user/register";
    String SUB_LOGIN_URL = "api/user/login";
    String VERIFY_OTP_URL = "api/user/verifyOTP";
    String GET_PROFILE = "api/user/getProfile";
    String RESEND_OTP = "api/user/resendOTP";
    String GET_CONSTANT = "api/profile/constants";
    String UPDATE_PROFILE = "api/user/updateProfile";
//    /**
//     * @param map
//     * @return
//     */
//    @Multipart
//    @POST("api/v1/user/createUser")
//    Call<LoginResponse> register(@PartMap HashMap<String, RequestBody> map);
//
//
//    /**
//     * @param map
//     * @return
//     */
//    @FormUrlEncoded
//    @PUT("api/v1/user/socialLogin")
//    Call<LoginResponse> socialLogin(@FieldMap HashMap<String, String> map);
//
//    /**
//     * @param authorization
//     * @param map
//     * @return
//     */
//    @FormUrlEncoded
//    @PUT("api/v1/user/loginToken")
//    Call<LoginResponse> accessTokenLogin(@Header(AUTHORIZATION) String authorization,
//                                         @FieldMap HashMap<String, String> map);
//
//
//    /**
//     * @param email
//     * @return
//     */
//    @FormUrlEncoded
//    @POST("api/v1/user/forgotpassword")
//    Call<CommonResponse> forgotPassword(@Field("email") String email);
//
//    /**
//     * @param map
//     * @return
//     */
//    @FormUrlEncoded
//    @PUT("api/v1/user/loginCredential")
//    Call<LoginResponse> login(@FieldMap HashMap<String, String> map);


    /**
     * Update location call.
     *
     * @param authorization the authorization
     * @param map           the map
     * @return the call
     */
    @FormUrlEncoded
    @POST(UPDATE_LOCATION)
    Call<CommonParams> updateLocation(@Header(AUTHORIZATION) String authorization,
                                      @FieldMap HashMap<String, String> map);

    /**
     * @param map map
     * @return map
     */
    @Multipart
    @POST(SUB_URL)
    Call<SignUpResponseModel> postUser(@PartMap HashMap<String, RequestBody> map);

    /**
     * @param authorization string
     * @param map           hash map
     * @return map
     */
    @POST(SUB_LOGIN_URL)
    Call<SignUpResponseModel> userLogin(@Header(AUTHORIZATION) String authorization,
                                        @Body HashMap<String, String> map);

    /**
     * @param authorization authorization
     * @param map           hash map
     * @return map
     */
    @PUT(VERIFY_OTP_URL)
    Call<SignUpResponseModel> verifyOTP(@Header(AUTHORIZATION) String authorization,
                                        @Body HashMap<String, String> map);

    /**
     * @param authoriation authorization
     * @return model
     */
    @GET(GET_PROFILE)
    Call<SignUpResponseModel> getProfile(@Header(AUTHORIZATION) String authoriation);

    /**
     * @param authorization authorization
     * @return access Token
     */
    @PUT(RESEND_OTP)
    Call<SignUpResponseModel> resendOtp(@Header(AUTHORIZATION) String authorization);

    /**
     * @return response
     */
    @GET(GET_CONSTANT)
    Call<com.skeleton.model.profile.Response> getResponse();

    /**
     * @param authorization access token
     * @param map           hash map
     * @return map
     */
    @Multipart
    @PUT(UPDATE_PROFILE)
    Call<SignUpResponseModel> updateProfile(@Header(AUTHORIZATION) String authorization,
                                            @PartMap HashMap<String, RequestBody> map);
}

