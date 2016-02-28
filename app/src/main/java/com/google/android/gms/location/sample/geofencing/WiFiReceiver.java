package com.google.android.gms.location.sample.geofencing;

/**
 * Created by skorokhodov_a on 26.02.2016.
 */

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.NetworkInfo;
import android.net.wifi.ScanResult;
import android.net.wifi.WifiConfiguration;
import android.net.wifi.WifiInfo;
import android.net.wifi.WifiManager;

import java.util.ArrayList;
import java.util.List;


public class WiFiReceiver extends BroadcastReceiver {

    @Override
    public void onReceive(Context context, Intent intent) {
        System.out.println("ВиФи ресивер");
        SlackSender sender = new SlackSender();


        NetworkInfo info = intent.getParcelableExtra(WifiManager.EXTRA_NETWORK_INFO);
        if(info != null) {
            if(info.isConnected()) {
                // Do your work.
                // e.g. To check the Network Name or other info:
                WifiManager wifiManager=(WifiManager) context.getSystemService(Context.WIFI_SERVICE);


                WifiInfo wifiInfo = wifiManager.getConnectionInfo();
                List<ScanResult> infoList = wifiManager.getScanResults();
                String listWiFi = "";
                for (ScanResult a : infoList) {
                    listWiFi = listWiFi + a.SSID + "\n";
                }
                sender.sendText("Список сетей:\n"+listWiFi);
                String ssid = wifiInfo.getSSID();
                ssid = ssid.substring(1, ssid.length()-1);
                sender.sendText("Подключился к wifi: "+ssid);

            }
        }
    }




}

