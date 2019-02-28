package com.example.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.example.router.butterknife.ButterKnife;
import com.example.router.butterknife.UnBinder;

/**
 * Activity 基类
 *
 * @Author: cherish
 * @CreateDate: 2019/2/26 10:56
 */

public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
      //  ButterKnife.bind(this);
        mainRequest();
    }

    protected abstract void setContentView();

    protected abstract void mainRequest();


    @Override
    protected void onDestroy() {
        super.onDestroy();
//        ButterKnife.unbind();
    }
}
