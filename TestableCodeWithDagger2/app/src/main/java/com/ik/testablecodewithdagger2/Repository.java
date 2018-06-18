package com.ik.testablecodewithdagger2;

/**
 * Created by ismailkhan on 01/05/18.
 */

public class Repository {

    private ApiService mApiService;
    private MyDatabase mDatabase;

    private static Repository repository;

    public Repository(ApiService apiService, MyDatabase database) {
        mApiService = apiService;
        mDatabase = database;
    }

    public static Repository getRepository (ApiService apiService, MyDatabase database) {

        if (repository == null)
            repository = new Repository(apiService, database);

        return repository;

    }

    public void getData(Callback callback) {

        //get cache data from local database
        String cacheData = mDatabase.getStoredApiValue();
        //update the view
        if (callback != null)
            callback.cacheData(cacheData);

        //get live data from API
        String liveData = mApiService.getData();
        //saving the live data
        mDatabase.saveApiValue(liveData);
        //update the view
        if (callback != null)
            callback.liveData(liveData);
    }
}
