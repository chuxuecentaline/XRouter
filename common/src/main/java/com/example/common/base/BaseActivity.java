package com.example.common.base;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * Activity 基类
 *
 * @Author: cherish
 * @CreateDate: 2019/2/26 10:56
 */

public abstract class BaseActivity  extends AppCompatActivity{
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        mainRequest();
        onClick();
    }

    protected abstract void setContentView();
    protected abstract void mainRequest();
    protected abstract void onClick();
}
