package com.developer.restapp.common;

import android.app.Activity;
import android.support.v4.app.Fragment;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.developer.restapp.PostAppComponent;

import butterknife.ButterKnife;

public abstract class BaseFragment extends Fragment {

    protected Context CONTEXT;

    @Override
    public void onAttach(Activity activity){
        super.onAttach(activity);
        CONTEXT = activity;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        injectDependencies();
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(getFragmentLayout(), container, false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        bindViews(view);
    }

    @Override
    public void onStart() {
        super.onStart();
        getPresenter().onStart();
    }

    @Override
    public void onStop() {
        super.onStop();
        getPresenter().onStop();
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbindViews();

    }

    protected abstract int getFragmentLayout();

    protected abstract BasePresenter getPresenter();

    public void injectDependencies() {

    }

    private void bindViews(View rootView) {
        ButterKnife.bind(this, rootView);
    }

    private void unbindViews() {
        //ButterKnife.unbind(this);
    }

    @Deprecated
    protected void setUpComponent(PostAppComponent component){}

}