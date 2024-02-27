package com.developer.restapp.module;

import android.content.Context;

import com.developer.restapp.interactor.Interactor;
import com.developer.restapp.presenter.Presenter;
import com.developer.restapp.ui.adapter.PostsResultsAdapter;
import com.developer.restapp.ui.view.View;

import dagger.Module;
import dagger.Provides;

@Module
public class PostModule {

    private View view;

    public PostModule(View view) {
        this.view = view;
    }

    @Provides
    public View provideView(){
        return view;
    }

    @Provides
    public Presenter providePresenter(View view, Interactor interactor){
        return new Presenter(view, interactor);
    }

    @Provides
    public PostsResultsAdapter provideAdapter(Context context){
        return new PostsResultsAdapter(context);
    }

}