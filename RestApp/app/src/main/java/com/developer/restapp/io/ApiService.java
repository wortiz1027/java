package com.developer.restapp.io;

import com.developer.restapp.domain.Post;
import com.developer.restapp.util.Constants;

import java.util.ArrayList;

import retrofit2.http.GET;
import io.reactivex.Observable;;

public interface ApiService {

    @GET(Constants.OPERATION)
    Observable<ArrayList<Post>> loadPost();

}