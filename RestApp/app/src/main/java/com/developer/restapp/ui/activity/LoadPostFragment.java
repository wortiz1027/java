package com.developer.restapp.ui.activity;

import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.developer.restapp.PostApp;
import com.developer.restapp.R;
import com.developer.restapp.common.BaseFragment;
import com.developer.restapp.common.BasePresenter;
import com.developer.restapp.component.DaggerMyComponent;
import com.developer.restapp.domain.Post;
import com.developer.restapp.module.PostModule;
import com.developer.restapp.presenter.Presenter;
import com.developer.restapp.ui.adapter.PostsResultsAdapter;

import java.util.ArrayList;

import javax.inject.Inject;

public class LoadPostFragment extends BaseFragment implements com.developer.restapp.ui.view.View {

    @Inject
    Presenter presenter;

    @Inject
    PostsResultsAdapter adapter;

    private RecyclerView recyclerView;

    private LinearLayoutManager linearLayoutManager;

    @Override
    protected int getFragmentLayout() {
        return R.layout.fragment_load_post;
    }

    @Override
    protected BasePresenter getPresenter() {
        return presenter;
    }

    public void injectDependencies() {
        super.injectDependencies();

        DaggerMyComponent.builder()
                .postAppComponent(PostApp.getApp(CONTEXT).getComponent())
                .postModule(new PostModule(this))
                .build()
                .inject(this);
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_load_post, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.list_post);
        linearLayoutManager = new LinearLayoutManager(CONTEXT);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        presenter.loadPost();

        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(linearLayoutManager);

        recyclerView.setAdapter(adapter);

        return view;
    }

    @Override
    public void displayPosts(ArrayList<Post> posts) {
        adapter.replace(posts);
    }

    @Override
    public void displayErrorPost() {
        Toast.makeText(CONTEXT, R.string.error_load_posts_message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayNetworkError() {
        Toast.makeText(CONTEXT, R.string.error_network_message, Toast.LENGTH_LONG).show();
    }

    @Override
    public void displayServerError() {
        Toast.makeText(CONTEXT, R.string.error_server_message, Toast.LENGTH_LONG).show();
    }

}