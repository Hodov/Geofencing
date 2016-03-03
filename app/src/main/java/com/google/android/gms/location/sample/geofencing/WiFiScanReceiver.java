package com.google.android.gms.location.sample.geofencing;

import android.content.BroadcastReceiver;
import android.content.ComponentName;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.pm.PackageManager;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;
import android.preference.PreferenceManager;

import com.firebase.client.Firebase;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by Andrey on 28.02.2016.
 */
public class WiFiScanReceiver extends BroadcastReceiver {
    @Override
    public void onReceive(Context context, Intent intent) {
        // Code to execute when SCAN_RESULTS_AVAILABLE_ACTION event occurs
        WifiManager wifiManager = (WifiManager) context.getSystemService(Context.WIFI_SERVICE);

        WifiInfo wifiInfo = wifiManager.getConnectionInfo();

        List<ScanResult> infoList = wifiManager.getScanResults();
        String listWiFi = "";

        for (ScanResult a : infoList) {
            if (this.enteredPlaceBool(context)) {
                if (Constants.BAY_AREA_WIFI.get(this.enteredPlace(context)).equals(a.SSID)) {
                    new SlackSender().sendText("Пришел " + this.enteredPlace(context));
                    inBar(true, context);
                    sendData(this.enteredPlace(context));
                    disableScanReceiver(context);

                }
            }
            listWiFi = listWiFi + a.SSID + "\n";
        }
        //new SlackSender().sendText("Список сетей:\n" + listWiFi);

        //if (ScanAsFastAsPossible) wifiManager.startScan(); // relaunch scan immediately
        //else { /* Schedule the scan to be run later here */}
    }

    private boolean enteredPlaceBool(Context context) {
        //SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        boolean defaultValue = true;
        return sharedPref.getBoolean("entered", defaultValue);
    }

    private String enteredPlace(Context context) {
        //SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        String defaultValue = "";
        return sharedPref.getString("place", defaultValue);
    }

    private void inBar(Boolean bool, Context context) {
        //SharedPreferences sharedPref = getActivity().getPreferences(Context.MODE_PRIVATE);
        SharedPreferences sharedPref = PreferenceManager.getDefaultSharedPreferences(context);
        SharedPreferences.Editor editor = sharedPref.edit();
        editor.putBoolean("inBar", bool);
        editor.commit();

    }

    private void disableScanReceiver(Context context) {
        System.out.println("Деактивируем скан ресивер");
        ComponentName receiver = new ComponentName(context, WiFiScanReceiver.class);

        PackageManager pm = context.getPackageManager();

        pm.setComponentEnabledSetting(receiver,
                PackageManager.COMPONENT_ENABLED_STATE_DISABLED,
                PackageManager.DONT_KILL_APP);
    }

    private void sendData(String place) {
        Firebase ref = new Firebase("https://barfly.firebaseio.com/users/hodov/bars/" + place);
        ref.child("entered").setValue("true");
        String uuid = UUID.randomUUID().toString();
        Firebase ref2 = new Firebase("https://barfly.firebaseio.com/users/hodov/bars/" + place + "/enters/"+uuid);
        String date = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss").format(new Date());
//        ref2.child("time").setValue(System.currentTimeMillis());
        ref2.child("time").setValue(date);

    }

}
