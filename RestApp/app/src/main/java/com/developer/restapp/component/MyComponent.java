package com.developer.restapp.component;

import com.developer.restapp.PostAppComponent;
import com.developer.restapp.common.ActivityScope;
import com.developer.restapp.interactor.Interactor;
import com.developer.restapp.module.InteractorModule;
import com.developer.restapp.module.NetModule;
import com.developer.restapp.module.PostModule;
import com.developer.restapp.presenter.Presenter;
import com.developer.restapp.ui.activity.LoadPostFragment;
import com.developer.restapp.ui.adapter.PostsResultsAdapter;

import dagger.Component;

@ActivityScope
@Component(
            dependencies = PostAppComponent.class,
            modules = {InteractorModule.class, PostModule.class}
          )
public interface MyComponent {

    void inject(LoadPostFragment fragment);

    Presenter getPresenter();
    Interactor getInteractor();

    PostsResultsAdapter getAdapter();

}