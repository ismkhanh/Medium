package com.ik.testablecodewithdagger2.di.components;

import com.ik.testablecodewithdagger2.CustomApplication;
import com.ik.testablecodewithdagger2.di.modules.ActivityBindingModule;

import dagger.Component;
import dagger.android.AndroidInjectionModule;

@Component(modules = {
        AndroidInjectionModule.class,
        ActivityBindingModule.class
})
public interface ApplicationComponent {
    void inject(CustomApplication application);
}
