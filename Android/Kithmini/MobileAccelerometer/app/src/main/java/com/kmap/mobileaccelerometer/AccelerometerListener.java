package com.kmap.mobileaccelerometer;

/**
 * Created by Kithmini on 3/8/2017.
 */

public interface AccelerometerListener {

     void onAccelerationChanged(float x, float y, float z);

     void onShake(float force);

}
