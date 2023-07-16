package com.kazimasum.qrdemo.Retrofit;

import com.kazimasum.qrdemo.Authentication.LoginModule.Model.LoginResponseModel;
import com.kazimasum.qrdemo.CheckoutModel.checkOutModel;

import retrofit2.Call;
import retrofit2.http.Header;
import retrofit2.http.Headers;
import retrofit2.http.POST;
import retrofit2.http.Query;

public interface ApiInterface
{
@POST("api/users/login")
    Call<LoginResponseModel>getLoginResponse(
            @Query("email")String email,
            @Query("password")String password
);
@Headers("Accept: application/json")
    @POST("api/employees/attendance")
    Call<checkOutModel>checkOut(
            @Header("Authorization")String token,
            @Query("user_latitude")String user_latitude,
            @Query("user_longitude")String user_longitude,
            @Query("qr_lat")String qr_lat,
            @Query("qr_long")String qr_long,
            @Query("employee_id")int employee_id
    );
}
