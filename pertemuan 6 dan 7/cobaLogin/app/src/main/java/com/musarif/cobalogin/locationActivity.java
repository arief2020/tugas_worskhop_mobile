package com.musarif.cobalogin;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.pm.PackageManager;
import android.location.Location;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class locationActivity extends AppCompatActivity {

    @SuppressLint("MissingPermission")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_location);

        FusedLocationProviderClient mFusedLocation = LocationServices.getFusedLocationProviderClient(this);
        mFusedLocation.getLastLocation().addOnSuccessListener(this, new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                if (location != null){
                    // Do it all with location
                    Log.d("My Current location", "Lat : " + location.getLatitude() + " Long : " + location.getLongitude());
                    // Display in Toast
                    Toast.makeText(locationActivity.this,
                            "Lat : " + location.getLatitude() + " Long : " + location.getLongitude(),
                            Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}