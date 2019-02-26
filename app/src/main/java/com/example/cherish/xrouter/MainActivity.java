package com.example.cherish.xrouter;

import android.content.Intent;
import android.view.View;

import com.example.common.base.BaseActivity;
import com.example.login.LoginActivity;

public class MainActivity extends BaseActivity {

    @Override
    protected void setContentView() {
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void mainRequest() {

    }

    @Override
    protected void onClick() {
    }

    public void login(View view) {
        startActivity(new  Intent(this,LoginActivity.class));
    }
}
