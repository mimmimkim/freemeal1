package com.example.freemeal2;

import java.util.HashMap;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.FieldMap;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface  MyAPI {
    @GET("/location")
    Call<List<LocationItem>> getLocation();

    @POST("/location/add")
    Call<LocationItem> postLocation(@Body LocationItem locationItem);
}
