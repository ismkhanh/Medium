package com.ik.testablecodewithdagger2;

/**
 * Created by ismailkhan on 01/05/18.
 */

public class MyDatabase {

    private String cache;

    public MyDatabase() {

    }

    public void saveApiValue(String apiValue) {
        cache = apiValue;
    }

    public String getStoredApiValue() {
        return cache;
    }
}



