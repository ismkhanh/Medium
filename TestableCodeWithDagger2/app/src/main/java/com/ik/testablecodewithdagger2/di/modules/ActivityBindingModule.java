package com.ik.testablecodewithdagger2.di.modules;

import android.app.Activity;

import com.ik.testablecodewithdagger2.MainActivity;
import com.ik.testablecodewithdagger2.di.components.MainActivitySubcomponent;

import dagger.Binds;
import dagger.Module;
import dagger.android.ActivityKey;
import dagger.android.AndroidInjector;
import dagger.multibindings.IntoMap;

@Module(subcomponents = MainActivitySubcomponent.class)
public abstract class ActivityBindingModule {

    @Binds
    @IntoMap
    @ActivityKey(MainActivity.class)
    abstract AndroidInjector.Factory<? extends Activity>
    bindsMainActivityInjectorFactory(MainActivitySubcomponent.Builder builder);

}
