package com.developer.restapp.io.callback;

import com.developer.restapp.domain.Post;

import java.util.ArrayList;

public interface PostServerCallback extends ServerCallback {

    void onPostFound(ArrayList<Post> posts);
    void onFailedLoadPost();

}