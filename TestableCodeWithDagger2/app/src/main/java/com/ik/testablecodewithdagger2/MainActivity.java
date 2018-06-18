package com.ik.testablecodewithdagger2;

import android.os.Bundle;
import android.widget.TextView;

import javax.inject.Inject;


public class MainActivity extends BaseActivity implements Callback {

    private TextView mTextView;
    @Inject Repository mRepository;

    @Override
    public void onCreate(Bundle saveInstanceState) {
        super.onCreate(saveInstanceState);

        setContentView(R.layout.activity_main);
        mTextView = findViewById(R.id.text_view);

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
