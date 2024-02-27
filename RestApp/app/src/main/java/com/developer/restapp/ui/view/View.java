package com.developer.restapp.ui.view;

import com.developer.restapp.domain.Post;

import java.util.ArrayList;

public interface View {

    void displayPosts(ArrayList<Post> posts);
    void displayErrorPost();
    void displayNetworkError();
    void displayServerError();

}