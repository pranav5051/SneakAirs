package com.sneakairs.android;

import android.app.Application;
import android.content.Context;

import com.google.android.gms.maps.model.LatLng;
import com.google.gson.Gson;
import com.parse.ParseGeoPoint;
import com.sneakairs.android.models.NavigationPoint;
import com.sneakairs.android.models.NavigationPointLIst;
import com.sneakairs.android.models.ReminderGeoPoint;
import com.sneakairs.android.models.ReminderGeoPointList;
import com.sneakairs.android.utils.CacheUtils;
import com.sneakairs.android.utils.Constants;

import java.util.ArrayList;
import java.util.List;

import io.realm.Realm;

/**
 * Created by sumodkulkarni on 03/04/17.
 */

public class App extends Application {

    public static Context context;
    public static ArrayList<NavigationPoint> navigationPointList = new ArrayList<>();
    public static LatLng userGeoPoint;
    public static List<ReminderGeoPoint> remindersList = new ArrayList<>();
    public static List<NavigationPoint> navigationPoints = new ArrayList<>();
    public static String deviceMACAddress = "98:D3:31:FB:04:8A";
    public static boolean shouldPlayMusic = false;
//    public static boolean overRideMusicPlayback = false;

    public static boolean isBluetoothServiceRunning = false;
    public static boolean isMusicServiceRunning = false;
    public static boolean isReminderServiceRunning = false;
    public static boolean isNavigationServiceRunning = false;

    public static ParseGeoPoint navigationStartPoint;
    public static ParseGeoPoint navigationEndPoint;
    public static int distanceCovered = 0;
    public static int checkPointsCovered = 0;

    public static boolean isMusicPlaying = false;
    public static boolean wirelessControl = false;



    @Override
    public void onCreate() {
        super.onCreate();
        context = getApplicationContext();

        if (CacheUtils.get(Constants.KEY_REMINDER_GEO_POINTS) != null)
            remindersList = new Gson().fromJson(CacheUtils.get(Constants.KEY_REMINDER_GEO_POINTS), ReminderGeoPointList.class);

        if (CacheUtils.get(Constants.KEY_NAVIGATION_GEO_POINTS) != null)
            navigationPoints = new Gson().fromJson(CacheUtils.get(Constants.KEY_NAVIGATION_GEO_POINTS), NavigationPointLIst.class);

    }
}
