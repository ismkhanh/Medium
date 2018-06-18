package com.ik.testablecodewithdagger2.di.modules;


import com.ik.testablecodewithdagger2.ApiService;
import com.ik.testablecodewithdagger2.MyDatabase;
import com.ik.testablecodewithdagger2.Repository;

import javax.inject.Singleton;

import dagger.Module;
import dagger.Provides;

@Module
public class RepositoryModule {

    @Provides
    @Singleton
    public Repository providesRepository(ApiService apiService, MyDatabase database) {
        return new Repository(apiService, database);
    }

    @Provides
    @Singleton
    ApiService providesApiService() {
        return new ApiService();
    }

    @Provides
    @Singleton
    MyDatabase providesMyDatabase() {
        return new MyDatabase();
    }

}
