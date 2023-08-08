package com.kazimasum.qrdemo;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.appcompat.widget.Toolbar;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.kazimasum.qrdemo.CheckoutModel.checkOutModel;
import com.kazimasum.qrdemo.Retrofit.ApiInterface;
import com.kazimasum.qrdemo.Retrofit.RetrofitClient;
import com.kazimasum.qrdemo.Session.SharedPreference;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {
    private static final int REQUEST_LOCATION_PERMISSION = 1;
    private FusedLocationProviderClient fusedLocationClient;
    AppCompatButton checkOut;
    private LocationCallback locationCallback;
     Toolbar toolbar;
     SharedPreference sharedPreference;
     TextView fullName,MobileNo,Designation,Email,Dob,distanceFromQR;
     double Distance=0;
     double lat =0,lot=0;
    double latitude ;
    double longitude;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Window window = getWindow();
        window.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
        window.setStatusBarColor(getResources().getColor(R.color.codeFilesColor));
        toolbar= findViewById(R.id.toolbar);
        checkOut = findViewById(R.id.checkOut);
        sharedPreference = new SharedPreference(this);
        String Name  = sharedPreference.getData("name");
        String mobileNo = sharedPreference.getData("mobileno");
        String designation = sharedPreference.getData("designation");
        String email = sharedPreference.getData("email");
        String dob = sharedPreference.getData("dob");
         String str = dob.substring(0,10);
        fullName = findViewById(R.id.fullName);
        Designation = findViewById(R.id.designation);
        MobileNo = findViewById(R.id.mobileNo);
        Email = findViewById(R.id.email);
        Dob=findViewById(R.id.dob);
//        distanceFromQR = findViewById(R.id.distanceFromQR);

        fullName.setText(Name);
        MobileNo.setText(mobileNo);
        Designation.setText(designation);
        Email.setText(email);
        Dob.setText(str);


        toolbar.setTitle(Name);
        setSupportActionBar(toolbar);

        fusedLocationClient = LocationServices.getFusedLocationProviderClient(this);


        locationCallback = new LocationCallback() {
            @Override
            public void onLocationResult(LocationResult locationResult) {
                if (locationResult == null) {
                    return;
                }
                for (Location location : locationResult.getLocations()) {
                     latitude = location.getLatitude();
                     longitude = location.getLongitude();

//                     lat=latitude;
//                     lot =longitude;
//                     sharedPreference.saveData("lat",String.valueOf(lat));
//                     sharedPreference.saveData("lot",String.valueOf(lot));
//                    if (calculateDistance(28.6142246767,77.3849460483,latitude,longitude)<=1){
//                       // double roundedValue = Math.round(Distance * 100.0) / 100.0;
//                        //distanceFromQR.setText(String.valueOf(roundedValue)+" meter");
//                    }


                   // Toast.makeText(MainActivity.this, "Latitude: " + latitude + ", Longitude: " + longitude, Toast.LENGTH_SHORT).show();
                }
            }
        };

        checkOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CallApi();
            }
        });
        // Check for location permission
        if (ContextCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) == PackageManager.PERMISSION_GRANTED) {
            requestLocationUpdates();
        } else {
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.ACCESS_FINE_LOCATION}, REQUEST_LOCATION_PERMISSION);
        }



    }

    private void CallApi()
    {
       String token = sharedPreference.getData("token");
       String Lat =String.valueOf(latitude);
       String Long = String.valueOf(longitude);
       int id = Integer.parseInt(sharedPreference.getData("employeeId"));
        ApiInterface apiInterface = new RetrofitClient().getRetrofit().create(ApiInterface.class);
        Call<checkOutModel>call = apiInterface.checkOut("Bearer "+token,Lat,Long,"28.618612","77.392016",id);
        call.enqueue(new Callback<checkOutModel>() {
            @Override
            public void onResponse(Call<checkOutModel> call, Response<checkOutModel> response) {
                if (response.code()==200){
                    Toast.makeText(MainActivity.this, response.body().getMessage(), Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(MainActivity.this,scannerView.class));
                    finish();
                }
            }

            @Override
            public void onFailure(Call<checkOutModel> call, Throwable t) {

            }
        });
    }

    private void requestLocationUpdates() {
        LocationRequest locationRequest = LocationRequest.create();
//        locationRequest.setPriority(LocationRequest.PRIORITY_HIGH_ACCURACY);
//        locationRequest.setInterval(1000);

        if (ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_FINE_LOCATION) != PackageManager.PERMISSION_GRANTED && ActivityCompat.checkSelfPermission(this, Manifest.permission.ACCESS_COARSE_LOCATION) != PackageManager.PERMISSION_GRANTED) {
            // TODO: Consider calling
            //    ActivityCompat#requestPermissions
            // here to request the missing permissions, and then overriding
            //   public void onRequestPermissionsResult(int requestCode, String[] permissions,
            //                                          int[] grantResults)
            // to handle the case where the user grants the permission. See the documentation
            // for ActivityCompat#requestPermissions for more details.
            return;
        }
        fusedLocationClient.requestLocationUpdates(locationRequest, locationCallback, null);
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        if (requestCode == REQUEST_LOCATION_PERMISSION) {
            if (grantResults.length > 0 && grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                requestLocationUpdates();
            } else {
                Toast.makeText(this, "Location permission denied", Toast.LENGTH_SHORT).show();
            }
        }
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        fusedLocationClient.removeLocationUpdates(locationCallback);
    }


    public  float calculateDistance(double startLatitude, double startLongitude, double destLatitude, double destLongitude) {
        Location startPoint = new Location("start");
        startPoint.setLatitude(startLatitude);
        startPoint.setLongitude(startLongitude);

        Location destPoint = new Location("destination");
        destPoint.setLatitude(destLatitude);
        destPoint.setLongitude(destLongitude);
          Distance = startPoint.distanceTo(destPoint)/1000;
        return startPoint.distanceTo(destPoint)/1000;
    }

}
