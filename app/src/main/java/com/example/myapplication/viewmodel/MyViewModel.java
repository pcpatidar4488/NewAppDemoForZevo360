package com.example.myapplication.viewmodel;

import androidx.lifecycle.ViewModel;

import com.example.myapplication.data.ApiResponse;
import com.example.myapplication.network.ApiService;

import javax.inject.Inject;

import io.reactivex.rxjava3.core.Observable;
import io.reactivex.rxjava3.schedulers.Schedulers;

public class MyViewModel extends ViewModel {
    private final ApiService apiService;

    @Inject
    public MyViewModel(ApiService apiService) {
        this.apiService = apiService;
    }

    public Observable<ApiResponse> fetchData() {
        return apiService.getApiData()
                .subscribeOn(Schedulers.io());
    }
}




