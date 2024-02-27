package com.developer.restapp.module;

import com.developer.restapp.domain.Post;
import com.developer.restapp.interactor.Interactor;

import java.util.ArrayList;

import dagger.Module;
import dagger.Provides;
import retrofit2.Retrofit;

@Module
public class InteractorModule {

    @Provides
    public ArrayList<Post> provideArray(){
        return new ArrayList<Post>();
    }

    @Provides
    public Interactor provideInteractor(Retrofit retrofit, ArrayList<Post> posts){
        return new Interactor(retrofit, posts);
    }

}