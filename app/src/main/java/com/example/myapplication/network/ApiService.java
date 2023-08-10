package com.example.myapplication.network;

import com.example.myapplication.data.ApiResponse;

import io.reactivex.rxjava3.core.Observable;
import retrofit2.http.GET;

public interface ApiService {
    @GET("top-headlines?country=us&apiKey=f4d90081d07c4113a2b6658efd5efc55")
    Observable<ApiResponse> getApiData();

}