package com.siziksu.layers.domain;

public interface BaseDomainContract<D> {

    void register(D domain);

    void unregister();
}
