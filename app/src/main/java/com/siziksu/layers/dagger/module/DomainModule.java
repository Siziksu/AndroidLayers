package com.siziksu.layers.dagger.module;

import com.siziksu.layers.domain.main.LoremDomain;
import com.siziksu.layers.domain.main.LoremDomainContract;
import com.siziksu.layers.domain.main.MainLoremDomainContract;

import dagger.Module;
import dagger.Provides;

@Module
public final class DomainModule {

    @Provides
    LoremDomainContract<MainLoremDomainContract> providesLoremDomain() {
        return new LoremDomain();
    }
}
