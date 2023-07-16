package com.kazimasum.qrdemo.Authentication.LoginModule;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;

import android.annotation.SuppressLint;
import android.app.ProgressDialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.Toast;

import com.kazimasum.qrdemo.Authentication.LoginModule.Model.LoginResponseModel;
import com.kazimasum.qrdemo.R;
import com.kazimasum.qrdemo.Retrofit.ApiInterface;
import com.kazimasum.qrdemo.Retrofit.RetrofitClient;
import com.kazimasum.qrdemo.Session.SharedPreference;
import com.kazimasum.qrdemo.scannerView;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class Login extends AppCompatActivity {
AppCompatButton login;
EditText email,password;
SharedPreference sharedPreference;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.codeFilesColor));
        sharedPreference = new SharedPreference(this);
        login = findViewById(R.id.login);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String Email = email.getText().toString().trim();
                String Password=password.getText().toString().trim();
         if (validation(Email,Password))
                CallApi();
            }
        });
    }
    private boolean validation(String email,String password){
        if (email.isEmpty()){
            Toast.makeText(this, "Enter your email..", Toast.LENGTH_SHORT).show();
            return false;
        }
        else if (password.isEmpty()) {
            Toast.makeText(this, "Enter your password..", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    private void CallApi()
    {
       final ProgressDialog pd = new ProgressDialog(this);
       // pd.show();
        pd.setMessage("Please wait....");
      String Email = email.getText().toString().trim();
      String Password = password.getText().toString().trim();
        ApiInterface apiInterface = new RetrofitClient().getRetrofit().create(ApiInterface.class);
        Call<LoginResponseModel>call = apiInterface.getLoginResponse(Email,Password);
        call.enqueue(new Callback<LoginResponseModel>() {
            @Override
            public void onResponse(Call<LoginResponseModel> call, Response<LoginResponseModel> response) {
                    if (response.code()==200){
                        sharedPreference.setLogin(true);
                        sharedPreference.saveData("token",response.body().getToken());
                        sharedPreference.saveData("employeeId",response.body().getData().getEmployee().getId().toString());
                        sharedPreference.saveData("name",response.body().getData().getAuth().getName());
                        sharedPreference.saveData("mobileno",response.body().getData().getAuth().getMobile());
                        sharedPreference.saveData("designation",response.body().getData().getEmployee().getDesignation());
                        sharedPreference.saveData("dob",response.body().getData().getEmployee().getDateOfBirth());
                        sharedPreference.saveData("email",response.body().getData().getAuth().getEmail());

                        Intent i = new Intent(Login.this, scannerView.class);
                        startActivity(i);
                        pd.dismiss();
                    } else if (response.body().getStatus()==403) {
                        Toast.makeText(Login.this, "No User found with given credentials", Toast.LENGTH_SHORT).show();
                    }

            }

            @Override
            public void onFailure(Call<LoginResponseModel> call, Throwable t) {
               pd.dismiss();
            }
        });
    }
}