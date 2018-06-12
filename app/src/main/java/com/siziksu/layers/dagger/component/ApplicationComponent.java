package com.siziksu.layers.dagger.component;

import com.siziksu.layers.App;
import com.siziksu.layers.dagger.module.ApplicationModule;
import com.siziksu.layers.dagger.module.DataModule;
import com.siziksu.layers.dagger.module.DomainModule;
import com.siziksu.layers.dagger.module.PresenterModule;
import com.siziksu.layers.data.Repository;
import com.siziksu.layers.data.client.LoremIpsumCacheClient;
import com.siziksu.layers.data.client.LoremIpsumClient;
import com.siziksu.layers.data.client.PreferencesClient;
import com.siziksu.layers.domain.main.LoremDomain;
import com.siziksu.layers.presenter.main.PresenterPresenter;
import com.siziksu.layers.ui.view.main.MainActivity;

import javax.inject.Singleton;

import dagger.Component;

@Singleton
@Component(
        modules = {
                ApplicationModule.class,
                DataModule.class,
                DomainModule.class,
                PresenterModule.class
        }
)
public interface ApplicationComponent {

    void inject(App target);

    void inject(PresenterPresenter target);

    void inject(Repository target);

    void inject(PreferencesClient target);

    void inject(LoremIpsumClient target);

    void inject(LoremIpsumCacheClient target);

    void inject(MainActivity target);

    void inject(LoremDomain target);
}
