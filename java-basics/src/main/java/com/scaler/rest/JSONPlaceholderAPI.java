package com.scaler.rest;

import com.scaler.rest.model.Photo;
import retrofit2.Call;
import retrofit2.http.GET;

import java.util.List;

public interface JSONPlaceholderAPI {
    @GET("/photos")
    Call<List<Photo>> getPhotos();
}
