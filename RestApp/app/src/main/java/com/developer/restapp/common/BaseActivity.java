package com.developer.restapp.common;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.developer.restapp.PostApp;
import com.developer.restapp.PostAppComponent;

import butterknife.ButterKnife;

public abstract class BaseActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedIdInstance){
        super.onCreate(savedIdInstance);
        setContentView(getLayout());
        injectDependencies();
        injectView();
    }

    @Override
    public void onStart(){
        super.onStart();
        if (getPresenter() != null)
            getPresenter().onStart();
    }

    @Override
    public void onStop(){
        super.onStop();
        if (getPresenter() != null)
            getPresenter().onStop();
    }

    protected abstract int getLayout();

    protected abstract BasePresenter getPresenter();

    private void injectDependencies(){
        setUpComponent(PostApp.getApp(this).getComponent());
    }

    private void injectView(){
        ButterKnife.bind(this);
    }

    public abstract void setUpComponent(PostAppComponent component);

}