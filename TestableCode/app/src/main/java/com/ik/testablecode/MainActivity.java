package com.ik.testablecode;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements Callback {

    private TextView mTextView;
    private Repository mRepository;

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);
        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.text_view);

        //create the dependency for Repository class
        ApiService apiService = new ApiService();
        MyDatabase database = new MyDatabase();

        //get Repository class instance
        mRepository = Repository.getRepository(apiService, database);

        //request for data
        mRepository.getData(this);
    }

    @Override
    public void cacheData(String data) {
        if (data != null)
            mTextView.setText(data);
    }

    @Override
    public void liveData(String data) {
        if (data != null)
            mTextView.setText(data);
    }

    @Override
    public void onDestroy() {
        super.onDestroy();

        //making sure Activity is not leaked
        mRepository.getData(null);
    }
}
