package com.example.travelkp.network;

import com.example.travelkp.models.Hotel;
import com.example.travelkp.models.Tour;
import java.util.List;
import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("/api/hotels")
    Call<List<Hotel>> getHotels();

    @GET("/api/tours")
    Call<List<Tour>> getTours();
}