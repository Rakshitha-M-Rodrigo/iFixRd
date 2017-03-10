package com.example.asus_pc.distancecalculator;
import com.example.asus_pc.distancecalculator.POJO.Example;

import retrofit.Call;
import retrofit.http.GET;
import retrofit.http.Query;

/**
 * Created by ASUS-PC on 1/2/2017.
 */


public interface RetrofitMaps {

    /*
     * Retrofit get annotation with our URL
     * And our method that will return us details of student.
     */
    @GET("api/directions/json?key=AIzaSyD38-wn6f-ukM7Zr4t9FOOsx63hef7QbCo")
    Call<Example> getDistanceDuration(@Query("units") String units, @Query("origin") String origin, @Query("destination") String destination, @Query("mode") String mode);

}
