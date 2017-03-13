package com.kmap.mobileaccelerometer;

import android.location.Location;

import com.google.android.gms.location.LocationListener;

/**
 * Created by Kithmini on 3/10/2017.
 */

public class MyLocListener implements LocationListener {
    double lat;
    double lng;

    @Override
    public void onLocationChanged(Location location) {
        if(location!=null){
          lat = location.getLatitude();
          lng = location.getLongitude();
        }
    }

}
