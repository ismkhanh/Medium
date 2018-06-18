package com.ik.testablecodewithdagger2.di.components;

import com.ik.testablecodewithdagger2.MainActivity;
import com.ik.testablecodewithdagger2.di.modules.RepositoryModule;

import javax.inject.Singleton;

import dagger.Subcomponent;
import dagger.android.AndroidInjector;


@Singleton
@Subcomponent(modules = RepositoryModule.class)
public interface MainActivitySubcomponent extends AndroidInjector<MainActivity>{

    @Subcomponent.Builder
    abstract class Builder extends AndroidInjector.Builder<MainActivity>{}
}
