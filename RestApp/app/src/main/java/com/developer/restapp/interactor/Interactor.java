package com.developer.restapp.interactor;

import com.developer.restapp.domain.Post;
import com.developer.restapp.io.ApiService;
import com.developer.restapp.io.callback.PostServerCallback;

import java.io.IOException;
import java.util.ArrayList;

import javax.inject.Inject;

import retrofit2.HttpException;
import retrofit2.Retrofit;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.schedulers.Schedulers;

public class Interactor {

    public ArrayList<Post> posts;
    public Retrofit retrofit;

    @Inject
    public Interactor(Retrofit retrofit, ArrayList<Post> posts) {
        this.retrofit = retrofit;
        this.posts = posts;
    }

    public void posts(final PostServerCallback callback){
        retrofit.create(ApiService.class)
                .loadPost()
                .subscribeOn(Schedulers.newThread())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribe(posts -> {
                                        if (posts.isEmpty()){
                                            callback.onFailedLoadPost();
                                        }else{
                                            callback.onPostFound(posts);
                                        }
                                    },
                           throwable -> {
                                            if (throwable instanceof IOException){
                                                callback.onNetworkError();
                                            }

                                            if (throwable instanceof HttpException){
                                                callback.onServerError();
                                            }
                                        }
                          );
    }

}