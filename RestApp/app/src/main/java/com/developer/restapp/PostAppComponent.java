package com.developer.restapp;

import android.content.Context;

import com.developer.restapp.module.NetModule;

import javax.inject.Singleton;

import dagger.Component;
import retrofit2.Retrofit;

@Singleton
@Component(
            modules = {AppModule.class, NetModule.class}
          )
public interface PostAppComponent {

    Context getContext();
    Retrofit getRetrofit();

}