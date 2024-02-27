package com.developer.restapp;

import android.app.Application;
import android.content.Context;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class AppModule {

    private PostApp app;

    public AppModule(PostApp app) {
        this.app = app;
    }

    @Provides
    @Singleton
    public Application provideApplication(){
        return app;
    }

    @Provides
    @Singleton
    public Context provideContext() {
        return app;
    }

}