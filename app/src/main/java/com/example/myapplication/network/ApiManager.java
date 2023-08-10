package com.example.myapplication.network;

import com.example.myapplication.data.ApiResponse;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;

public class ApiManager {
    @Inject
    ApiService apiService;

    public Observable<ApiResponse> makeApiCall() {
        return apiService.getApiData();
    }
}
