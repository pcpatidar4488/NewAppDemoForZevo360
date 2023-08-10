package com.example.myapplication.di;

import com.example.myapplication.network.ApiService;
import com.example.myapplication.network.NetworkModule;
import com.example.myapplication.viewmodel.MyViewModel;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(modules = {NetworkModule.class})
public interface AppComponent {
    void inject(MyViewModel viewModel);
    // Add more inject methods if needed
}

