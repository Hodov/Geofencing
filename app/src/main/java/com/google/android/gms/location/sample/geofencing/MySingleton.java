package com.google.android.gms.location.sample.geofencing;

import android.app.Application;

import com.firebase.client.Firebase;

/**
 * Created by Andrey on 12.03.2016.
 */
public class MySingleton extends Application {
    public Firebase myFirebaseRef;
    @Override
    public void onCreate() {
        super.onCreate();
        Firebase.setAndroidContext(this);
        myFirebaseRef = new Firebase("https://barfly.firebaseio.com/");
    }

}
