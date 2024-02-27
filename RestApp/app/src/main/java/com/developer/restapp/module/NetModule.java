package com.developer.restapp.module;

import android.app.Application;
import android.content.SharedPreferences;
import android.preference.PreferenceManager;

import com.developer.restapp.util.Constants;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

@Module
public class NetModule {

    @Provides
    @Singleton
    public SharedPreferences provideSharedPreferences(Application application){
        return PreferenceManager.getDefaultSharedPreferences(application);
    }

    @Provides
    @Singleton
    public Cache provideHttpCache(Application application) {
        int cachesize = 10 * 1024 * 1024;
        Cache cache = new Cache(application.getCacheDir(), cachesize);
        return cache;
    }

    @Provides
    @Singleton
    public Gson provideGson(){
        GsonBuilder gson = new GsonBuilder();
        gson.setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES);
        return gson.create();
    }

    @Provides
    @Singleton
    public OkHttpClient provideOkHttpClient(Cache cache){
        OkHttpClient.Builder client = new OkHttpClient.Builder();

        HttpLoggingInterceptor logging = new HttpLoggingInterceptor();
        logging.setLevel(HttpLoggingInterceptor.Level.BODY);

        client.addInterceptor(logging);
        client.cache(cache);

        return client.build();
    }

    @Provides
    @Singleton
    public Retrofit provideRetrofit(Gson gson, OkHttpClient client){
        Retrofit retrofit = new Retrofit.Builder()
                                        .addConverterFactory(GsonConverterFactory.create(gson))
                                        .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                                        .baseUrl(Constants.BASE_URL)
                                        .client(client)
                                        .build();
        return retrofit;
    }

}