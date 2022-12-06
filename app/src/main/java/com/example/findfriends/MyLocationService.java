package com.example.findfriends;

import android.annotation.SuppressLint;
import android.app.Service;
import android.content.Intent;
import android.location.Location;
import android.os.IBinder;
import android.telephony.SmsManager;

import androidx.annotation.NonNull;

import com.google.android.gms.location.FusedLocationProviderClient;
import com.google.android.gms.location.LocationCallback;
import com.google.android.gms.location.LocationRequest;
import com.google.android.gms.location.LocationResult;
import com.google.android.gms.location.LocationServices;
import com.google.android.gms.tasks.OnSuccessListener;

public class MyLocationService extends Service {
    String numero;
    public MyLocationService() {
    }

    @Override
    public void onCreate() {
        super.onCreate();
    }

    @SuppressLint("MissingPermission")
    @Override
    public int onStartCommand(Intent intent, int flags, int startId) {
        // we had the choice to write this code in both Oncreate and OnStartCommand
        //but  we did it here because we have intent to get the numero from
        numero = intent.getStringExtra("numero");

        //recuperation position gps
        FusedLocationProviderClient mClient = LocationServices.getFusedLocationProviderClient(this);
        mClient.getLastLocation().addOnSuccessListener(new OnSuccessListener<Location>() {
            @Override
            public void onSuccess(Location location) {
                sendSms(location);

            }
        });
        // we want to get the location every 10 minutes
        LocationRequest request = LocationRequest.create().setSmallestDisplacement(100).setFastestInterval(6000);
        LocationCallback action = new LocationCallback() {
            @Override
            public void onLocationResult(@NonNull LocationResult locationResult) {
                Location location = locationResult.getLastLocation();
            }
        };
        mClient.requestLocationUpdates(request,action,null);


        return super.onStartCommand(intent, flags, startId);
    }

    private void sendSms(Location location) {
        if (location != null) {
        SmsManager manager = SmsManager.getDefault();
        manager.sendTextMessage(
                numero,
                null,
                "findFriends: Ma Position est :#" + location.getLongitude() + "#" + location.getLatitude(),
                null, null);}
    }

    @Override
    public IBinder onBind(Intent intent) {
        // TODO: Return the communication channel to the service.
        return null;
    }
}