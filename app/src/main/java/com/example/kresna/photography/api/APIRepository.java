package com.example.kresna.photography.api;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIRepository {
    @GET("list")
    Call<Photos> getAllPhotos();
}
